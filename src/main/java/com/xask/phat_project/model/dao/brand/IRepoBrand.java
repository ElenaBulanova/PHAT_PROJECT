package com.xask.phat_project.model.dao.brand;

import com.xask.phat_project.model.entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepoBrand extends CrudRepository<Brand, Integer> {
    Brand findById(int id);


}
