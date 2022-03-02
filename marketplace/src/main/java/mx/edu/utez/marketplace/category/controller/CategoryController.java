package mx.edu.utez.marketplace.category.controller;

import mx.edu.utez.marketplace.category.model.Category;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = {"*"}) //cualquier aplicación externa tenga acceso a este controlador
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody CategoryDTO categoryDTO){
        Category category = new Category(categoryDTO.getDescription(), categoryDTO.getStatus());
        return categoryService.save(category);
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody CategoryDTO categoryDTO){
        Category category = new Category(categoryDTO.getId(),categoryDTO.getDescription(), categoryDTO.getStatus());
        return categoryService.update(category);
    }
}
///api/category/
///api/category/1


