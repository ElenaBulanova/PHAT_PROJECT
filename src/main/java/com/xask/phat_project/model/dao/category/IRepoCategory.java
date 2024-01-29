package com.xask.phat_project.model.dao.category;

import com.xask.phat_project.model.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface IRepoCategory extends CrudRepository<Category, Integer> {
    Category findById(int id);
}
