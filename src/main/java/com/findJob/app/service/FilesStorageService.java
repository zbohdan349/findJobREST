package com.findJob.app.service;

import com.findJob.app.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FilesStorageService {
    @Value("${server.name}")
    private  String SERVER_URL;

    private final String UPLOAD_DIR = "uploads/";

    private final String DEFAULT_IMG_DIR = UPLOAD_DIR +"defaultAvatar/";
    private final String DEFAULT_IMG= "avatar.png";

    private final String IMG_EXTENSION= ".png";

    private final Path root = Paths.get(UPLOAD_DIR);
    @Autowired
    private AuthenticationService authenticationService;

    private void createFolder(Path folder) {
        try {
            if(!Files.exists(folder)){
                Files.createDirectory(folder);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @PostConstruct
    public void init() {
        createFolder(root);
    }


    public boolean save(MultipartFile file) throws IOException {
        Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        checkExtension(file);
        try {
            String url = UPLOAD_DIR + account.getId();
            Path path = Paths.get(url);
            createFolder(path);

            Files.deleteIfExists(Paths.get(url + "/" + account.getId() + IMG_EXTENSION));

            Files.copy(file.getInputStream(),
                    path.resolve(account.getId()
                            + IMG_EXTENSION));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
    private void checkExtension(MultipartFile file) throws IOException {
        String extension = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf('.'));

        if (!IMG_EXTENSION.equals(extension)) {
            throw new IOException("Only png");
        }
    }

    public String getCurrUserImgPath(){
        return SERVER_URL+"files/"+ authenticationService.getCurrentAccount().getId();
    }

    public Resource load(Integer id) {
        try {
            Path file = Paths.get(UPLOAD_DIR+id).resolve(id+".png");
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                file = Paths.get(DEFAULT_IMG_DIR).resolve(DEFAULT_IMG);
                return new UrlResource(file.toUri());
                //throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}


