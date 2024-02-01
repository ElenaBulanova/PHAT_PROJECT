package com.xask.phat_project.controllers;

import com.xask.phat_project.model.dao.brand.IDaoBrand;
import com.xask.phat_project.model.dao.category.IDaoCategory;
import com.xask.phat_project.model.dao.item.IDaoItem;
import com.xask.phat_project.model.entities.Brand;
import com.xask.phat_project.model.entities.Category;
import com.xask.phat_project.model.entities.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serv")
public class GenerateController {
    private final IDaoBrand daoBrand;
    private final IDaoCategory daoCategory;
    private final IDaoItem daoItem;

    @GetMapping("/generate")
    public void generate() {
//        generateBrands();
//        generateCategories();
//        generateItems();

    }

    @PostMapping("/findAllInCategory")
    public String findAllInCategory(@RequestParam Integer numberOfCategory) {
        return "Все товары из категории " + daoCategory.findById(numberOfCategory).getName()
                + ": " + daoItem.findItemsByCategoryId(numberOfCategory);
    }
    @GetMapping("/findAllInBrand")
    public String findAllInBrand(Integer brand_id){
        return "Все товары бренда " + daoBrand.findById(brand_id).getBrand()
                + ": " + daoItem.findItemsByBrandId(brand_id) + "id= " + brand_id;
    }
    @PostMapping("/deleteBrandById")
    public String deleteBrandById(@RequestParam Integer brand_id){
        String res = "Brand " + daoBrand.findById(brand_id).getBrand() + " deleted." + "Вместе с товарами: " + daoBrand.findById(brand_id).getStock();
        Brand brand = daoBrand.deleteById(brand_id);
        return  res;
    }



    private void generateBrands() {
        daoBrand.save(new Brand("Kangol"));
        daoBrand.save(new Brand("ProClub"));
        daoBrand.save(new Brand("Novesta"));
        daoBrand.save(new Brand("PHAT"));

    }

    private void generateCategories() {
        daoCategory.save(new Category("Головные уборы"));
        daoCategory.save(new Category("Одежда"));
        daoCategory.save(new Category("Обувь"));
        daoCategory.save(new Category("Сумки"));
        daoCategory.save(new Category("Аксессуары"));
        daoCategory.save(new Category("Творчество"));
    }


    private void generateItems() {

        Item item = new Item("Hat1", "Red", "12", daoBrand.findById(1), daoCategory.findById(1));
        addValueToSet(item.getBrand().getId(), item.getCategory().getId(), item);

        item = daoItem.save(new Item("Hat2", "Green", "1", daoBrand.findById(1), daoCategory.findById(1)));
        addValueToSet(item.getBrand().getId(), item.getCategory().getId(), item);

        item = daoItem.save(new Item("Hat3", "Blue", "10", daoBrand.findById(2), daoCategory.findById(1)));
        addValueToSet(item.getBrand().getId(), item.getCategory().getId(), item);

        item = daoItem.save(new Item("Boots", "Black", "3", daoBrand.findById(3), daoCategory.findById(3)));
        addValueToSet(item.getBrand().getId(), item.getCategory().getId(), item);

        item = daoItem.save(new Item("Boots", "Yellow", "5", daoBrand.findById(3), daoCategory.findById(3)));
        addValueToSet(item.getBrand().getId(), item.getCategory().getId(), item);

        System.out.println("daoCategory.findById(1).getItems() = " + daoCategory.findById(1).getItems().toString());
        System.out.println("daoBrand.findById(1).getStock() = " + daoBrand.findById(1).getStock().toString());
        System.out.println("daoBrand.findById(2).getStock() = " + daoBrand.findById(2).getStock().toString());
    }
    private void addValueToSet(int brandNumber, int categoryNumber, Item item){
        daoItem.save(item);
        Set<Item> itemSetCategory = daoCategory.findById(categoryNumber).getItems();
        itemSetCategory.add(item);
        Set<Item> itemSetBrand = daoBrand.findById(brandNumber).getStock();
        itemSetBrand.add(item);
    }
}
