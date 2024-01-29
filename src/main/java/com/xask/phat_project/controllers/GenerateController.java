package com.xask.phat_project.controllers;

import com.xask.phat_project.model.dao.brand.IDaoBrand;
import com.xask.phat_project.model.dao.category.IDaoCategory;
import com.xask.phat_project.model.entities.Brand;
import com.xask.phat_project.model.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serv")
public class GenerateController {
    private final IDaoBrand daoBrand;
    private  final IDaoCategory daoCategory;

    @GetMapping("/generate")
    public void generate(){
        generateBrands();
        generateCategories();

    }

    private void generateBrands(){
        daoBrand.save(new Brand("Kangol"));
        daoBrand.save(new Brand("ProClub"));
        daoBrand.save(new Brand("Novesta"));
        daoBrand.save(new Brand("PHAT"));

    }
    private void generateCategories(){
        daoCategory.save(new Category("Головные уборы"));
        daoCategory.save(new Category("Одежда"));
        daoCategory.save(new Category("Обувь"));
        daoCategory.save(new Category("Сумки"));
        daoCategory.save(new Category("Аксессуары"));
        daoCategory.save(new Category("Творчество"));
    }
}
