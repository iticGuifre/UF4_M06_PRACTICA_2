package com.accesadades.botiga.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Repository.SubcategoryRepository;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public Subcategory findByName(String name) {
        return subcategoryRepository.findByName(name).orElse(null);
    }

    @Override
    public Set<Subcategory> findAllSubcategories() {
        return new HashSet<>(subcategoryRepository.findAll());
    }

}
