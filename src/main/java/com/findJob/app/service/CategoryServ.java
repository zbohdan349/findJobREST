package com.findJob.app.service;

import com.findJob.app.model.Category;
import com.findJob.app.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServ {
    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public boolean addCategory(String name){


        Category category = new Category();
        category.setName(name);
        categoryRepo.save(category);
        return true;
    }


}
