package com.findJob.app.controller;

import com.findJob.app.model.*;
import com.findJob.app.model.dto.*;
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
@CrossOrigin("http://localhost:3000")
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

    @Autowired
    private TeamWorkService teamWorkService;

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
    @ResponseBody
    public ResponseEntity<InputStreamResource> getFile(@PathVariable Integer id) throws IOException {
        Resource file = storageService.load(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""
                                + file.getFilename()
                                + "\"")
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(file.getInputStream()));
    }
    @GetMapping("/files/current")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Map<String,String>> getCurrentUserImgPath() throws IOException {
        Map<String,String> map =new HashMap<>();
        map.put("imgPath",storageService.getCurrUserImgPath());
        return ResponseEntity.ok(map);
    }
    @PostMapping("/vacancies")
    public  ResponseEntity<List<VacDto>> findWithParam(@RequestBody FilterReq req){
        return ResponseEntity.ok(vacancyServ.getFilter(req.getMinSalary(),req.getLevels(),req.getCategories()));
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/addVacancy")
    public  ResponseEntity<?> addVacancy(@RequestBody AddVacDto vacDto){
        return ResponseEntity.ok(vacancyServ.addVacancy(vacDto));
    }
    @GetMapping("/vacancies/{id}")
    public  VacDto getVacancyById(@PathVariable Integer id){
        return vacancyServ.getCategoryById(id);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/vacancies/home")
    public List<VacDto> getVacanciesByCompany(){
        return vacancyServ.getVacanciesByCompany() ;
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/categories")
    public ResponseEntity<?> addCategory(@RequestBody AddCategoryDto category){
        return ResponseEntity.ok(categoryServ.addCategory(category.getName()));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/teamwork")
    public ResponseEntity<?> addTeamWork(@RequestBody AddTeamworkReq teamworkReq){
        return ResponseEntity.ok(teamWorkService.addTeamWork(teamworkReq.getId()));
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/teamwork/active")
    public ResponseEntity<?> getActiveTeamWork(){
        return ResponseEntity.ok(teamWorkService.getActiveTeamWork());
    }
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/teamwork/{email}")
    public ResponseEntity<?> updateTeamWork(@PathVariable String email){
        return ResponseEntity.ok(teamWorkService.updateTeamWorkStatus(email));
    }
    @PostMapping("/registration")
    public ResponseEntity<?> registration(@RequestBody RegistrationReq req){
        return ResponseEntity.ok(authenticationService.registration(req));
    }

}
