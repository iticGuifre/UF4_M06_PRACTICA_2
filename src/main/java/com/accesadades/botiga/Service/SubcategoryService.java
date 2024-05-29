package com.accesadades.botiga.Service;

import java.util.List;
import java.util.Set;

import com.accesadades.botiga.Model.Subcategory;

public interface SubcategoryService {
    Subcategory findByName(String name);
    Set<Subcategory> findAllSubcategories();
}
