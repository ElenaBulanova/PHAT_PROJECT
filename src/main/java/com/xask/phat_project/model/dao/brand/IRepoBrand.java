package com.xask.phat_project.model.dao.brand;

import com.xask.phat_project.model.entities.Brand;
import org.springframework.data.repository.CrudRepository;

public interface IRepoBrand extends CrudRepository<Brand, Integer> {
    Brand findById(int id);
    Brand deleteById(int id);


}
