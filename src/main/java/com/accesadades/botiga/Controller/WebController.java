package com.accesadades.botiga.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.accesadades.botiga.Model.Category;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Model.Subcategory;
import com.accesadades.botiga.Service.CategoryService;
import com.accesadades.botiga.Service.ProductService;
import com.accesadades.botiga.Service.SubcategoryService;

import java.time.LocalDateTime;
import java.util.Set;

@Controller
public class WebController {
 
    @Autowired
    private ProductService productService;

    @Autowired
    private SubcategoryService subcategoryService;
    
    @Autowired
    private CategoryService categoryService;
 
    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
 
    @RequestMapping(value = "/catalog")
    public String catalog(Model model) {
        Set<Product> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "catalog";
    }

    @RequestMapping(value = {"/search", "/prodname"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String searchProductByName(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name != null) {
            Product product = productService.findProductsByName(name);
            model.addAttribute("product", product);
        }
        return "search";
    }

    // Endpoint que mostra el formulari
    @RequestMapping(value = "/crear", method = RequestMethod.GET)
    public String showProductForm(Model model) {
        Set<Subcategory> subcategories = subcategoryService.findAllSubcategories();
        model.addAttribute("subcategories", subcategories);
        return "create";
    }

    //Endpoint on es guarda el nou producte inserit al formulari
    @RequestMapping(value = "/productes/desar", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("nom") String name,
                              @RequestParam("descripcio") String description,
                              @RequestParam("unitats") int units,
                              @RequestParam("preu") float price,
                              @RequestParam("fabricant") String company,
                              @RequestParam("subcategoria") String subcategoryName,
                              Model model) {
        Subcategory subcategory = subcategoryService.findByName(subcategoryName);
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setUnits(units);
        product.setPrice(price);
        product.setCompany(company);
        product.setSubcategory(subcategory);

        productService.saveProduct(product);
        return "redirect:/catalog";
    }
}

