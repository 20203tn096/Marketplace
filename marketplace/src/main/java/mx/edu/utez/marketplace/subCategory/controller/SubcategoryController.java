package mx.edu.utez.marketplace.subCategory.controller;

import mx.edu.utez.marketplace.subCategory.model.SubCategory;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/subcategory")
@CrossOrigin(origins = {"*"})
public class SubcategoryController {
    @Autowired
    SubCategoryService subcategoryService;

    @GetMapping("/all")
    public ResponseEntity<Message> getAll(long id){
        return subcategoryService.findAll();
    }

    @GetMapping("/{subcategory}")
    public ResponseEntity<Message> getById(@PathVariable("subcategory") long id){
        return subcategoryService.findById(id);
    }

    @GetMapping("/all/{category}")
    public ResponseEntity<Message> getByCategory(@PathVariable("category") long id){
        return subcategoryService.findAllByCategory(id);
    }
    @PostMapping("/")
    public ResponseEntity<Message> createCategory(@RequestBody SubcategoryDTO subcategoryDTO){
        SubCategory subcategory = new SubCategory(subcategoryDTO.getDescription(), subcategoryDTO.getCategory(), subcategoryDTO.getStatus());
        return subcategoryService.insert(subcategory);
    }
}
