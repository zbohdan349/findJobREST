package com.findJob.app.service;

import com.findJob.app.model.Account;
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

    private final String UPLOAD_DIR = "uploads";
    private final Path root = Paths.get(UPLOAD_DIR);

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


    public boolean save(MultipartFile file) {
        Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            Path path = Paths.get(UPLOAD_DIR +"/"+account.getId());
            createFolder(path);
            Files.copy(file.getInputStream(),
                    path.resolve(account.getId()
                            + file.getOriginalFilename()
                                .substring(file.getOriginalFilename().lastIndexOf('.'))));
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    public Resource load(Integer id) {
        try {
            Path file = Paths.get(UPLOAD_DIR+"/"+id).resolve(id+".png");
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                 file = Paths.get(UPLOAD_DIR+"/"+1).resolve(1+".txt");
                return resource = new UrlResource(file.toUri());
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


