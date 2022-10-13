package com.findJob.app.controller;

import com.findJob.app.model.*;
import com.findJob.app.model.dto.FilterReq;
import com.findJob.app.model.dto.RegDto;
import com.findJob.app.model.dto.VacDto;
import com.findJob.app.security.AuthRequest;
import com.findJob.app.security.JwtTokenUtil;
import com.findJob.app.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
public class StartController {

    @Autowired
    private FilesStorageService storageService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private CompanyServ companyServ;

    @Autowired
    private UserServ userServ;

    @Autowired
    private VacancyServ vacancyServ;

    @Autowired
    private CategoryServ categoryServ;

    @GetMapping("/")
    public  List<Vacancy> start(){

        return vacancyServ.getRandom();
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            Account account = (Account) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            HashMap<String,String> response = new HashMap<>();
            response.put("email", account.getEmail());
            response.put("accessToken",accessToken);


            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @GetMapping("/find")
    @SecurityRequirement(name = "Bearer Authentication")
    public  Map<String,Object> find(){

        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("categories",categoryServ.getAllCategories());
        hashMap.put("vacancies",vacancyServ.getAll());
        hashMap.put("levels", Level.values());
        return hashMap;
    }

    @PostMapping("/upload")
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


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
    /*@GetMapping("/find1")
    public  String findWithParam(Model model,
                                 @DefaultValue("0")@RequestParam(required = false) Integer salary,
                                 @RequestParam(required = false) List<Level> levels,
                                 @RequestParam(required = false) Category category
                                 ){
        model.addAttribute("filterReq", new FilterReq());

        model.addAttribute("categories",categoryServ.getAllCategories());

        model.addAttribute("vacancies",vacancyServ.getFilter(salary,levels,category));

        model.addAttribute("levels", Level.values());

        return "filterP";
    }
    @GetMapping("/vacancy/{id}")
    public  String vacancy(Model model,@PathVariable Integer id){
        model.addAttribute("vacancy",vacancyServ.getCategoryById(id));
        return "vacancy";
    }
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
