package com.findJob.app.controller;

import com.findJob.app.model.*;
import com.findJob.app.model.dto.FilterReq;
import com.findJob.app.model.dto.VacDto;
import com.findJob.app.security.AuthRequest;
import com.findJob.app.service.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@RestController
@CrossOrigin
public class StartController {

    @Autowired
    private FilesStorageService storageService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CompanyServ companyServ;

    @Autowired
    private UserServ userServ;

    @Autowired
    private VacancyServ vacancyServ;

    @Autowired
    private CategoryServ categoryServ;

    @GetMapping("/")
    public  List<VacDto> start(){
        return vacancyServ.getRandom();
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok().body(authenticationService.login(request));
    }


    @GetMapping("/find")
    @SecurityRequirement(name = "Bearer Authentication")
    public  Map<String,Object> find(){

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("levels", Level.values());
        hashMap.put("categories",categoryServ.getAllCategories());
        hashMap.put("minSalary",vacancyServ.getMinSalary());
        hashMap.put("maxSalary",vacancyServ.getMaxSalary());
        return hashMap;
    }

    @PostMapping("/upload")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body((message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body((message));
        }
    }


    @GetMapping("/files/{id}")
    @SecurityRequirement(name = "Bearer Authentication")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImg(@PathVariable Integer id) throws IOException {
        Resource file = storageService.load(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""
                                + file.getFilename()
                                + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(file.getInputStream()));
    }
    @PostMapping("/vacancies")
    public  ResponseEntity<List<VacDto>> findWithParam(@RequestBody FilterReq req){
        return ResponseEntity.ok(vacancyServ.getFilter(req.getMinSalary(),req.getLevels(),req.getCategories()));
    }
    @GetMapping("/vacancies/{id}")
    public  VacDto vacancy(@PathVariable Integer id){
        return vacancyServ.getCategoryById(id);
    }
    /*
    @GetMapping("/addVacancy")
    public  String addVacancyGet(Model model){
        model.addAttribute("levels", Level.values());
        model.addAttribute("vacDto",new VacDto());
        model.addAttribute("categories",categoryServ.getAllCategories());
        return "addVacancy";
    }
    @PostMapping("/addVacancy")
    public  String addVacancy(@ModelAttribute VacDto vacDto, Model model){
        Vacancy vacancy = new Vacancy();

        vacancy.setName(vacDto.getName());
        vacancy.setBigDescription(vacDto.getBig());
        vacancy.setSalary(vacDto.getSalary());
        vacancy.setSmallDescription(vacDto.getSmall());
        vacancy.setLevel(vacDto.getLevel());
        Company company = new Company();
        company.setId(1);
        vacancy.setCategories(vacDto.getCategories());
        vacancy.setCompany(company);

        vacancyServ.save(vacancy);
        return "redirect:/find";
    }
    @GetMapping("/registration")
    public  String registration(Model model){

        return "RegForm1";
    }
    @GetMapping("/registration/client")
    public  String registrationUser(Model model){

        model.addAttribute("registration",new RegDto());

        return "RegForm2";
    }
    @PostMapping("/registration/client")
    public  String registrationUserPost(@ModelAttribute RegDto dto,Model model){

       model.addAttribute("registration",dto);

       userServ.save(dto);

       return "redirect:/login";
    }

    @GetMapping("/registration/company")
    public  String registrationCompany(Model model){

        model.addAttribute("registration",new RegDto());

        return "RegForm3";
    }

    @PostMapping("/registration/company")
    public  String registrationCompanyPost(@ModelAttribute RegDto dto,Model model){

        model.addAttribute("registration",dto);

        companyServ.save(dto);

        return "redirect:/login";
    }*/
}
