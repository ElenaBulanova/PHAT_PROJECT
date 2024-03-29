package com.xask.phat_project.model.dao.brand;

import com.xask.phat_project.model.entities.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DBServiceBrand implements IDaoBrand {
    private final IRepoBrand brandRepo;

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepo.findAll();
    }

    @Override
    public Brand findById(int id) {
        return brandRepo.findById(id);
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepo.save(brand);
    }

    @Override
    public Brand update(Brand brand) {
        if (brandRepo.findById(brand.getId()).isPresent()){
            brandRepo.save(brand);
        }
        return brand;
    }

    @Override
    public Brand deleteById(int id) {
        Brand brand = findById(id);
        brandRepo.deleteById(id);
        return brand;
    }
}
