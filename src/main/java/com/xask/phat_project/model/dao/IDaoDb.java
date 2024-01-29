package com.xask.phat_project.model.dao;

import java.util.List;
import java.util.Optional;

public interface IDaoDb<T> {
    List<T> findAll();
   T findById(int id);
    T save(T t);
    T update(T t);
    T deleteById(int id);
}
