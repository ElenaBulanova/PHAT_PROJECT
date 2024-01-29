package com.xask.phat_project.model.dao.item;

import com.xask.phat_project.model.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface IRepoItem extends CrudRepository<Item, Integer> {
    Item findById(int id);
}
