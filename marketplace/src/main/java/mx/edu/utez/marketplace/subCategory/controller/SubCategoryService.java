package mx.edu.utez.marketplace.subCategory.controller;

import mx.edu.utez.marketplace.category.model.CategoryRepository;
import mx.edu.utez.marketplace.subCategory.model.SubCategory;
import mx.edu.utez.marketplace.subCategory.model.SubcategoryRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SubCategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public ResponseEntity<Message> findAllByCategory(long id) {
        if (categoryRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("Ok", false, subcategoryRepository.findAllByCategoryId(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("La categoria no existe", true, null), HttpStatus.BAD_REQUEST);

    }

    @Transactional
    public ResponseEntity<Message> findAll() {
        return new ResponseEntity<>(new Message("Ok", false, subcategoryRepository.findAll()), HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<Message> findById(long id) {
        if (subcategoryRepository.existsById(id)) {
            return new ResponseEntity<>(new Message("OK", false, subcategoryRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Subcategoria no encontrada", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> insert(SubCategory subcategory) {
        Optional<SubCategory> exitsSubcategory = subcategoryRepository.findByDescription(subcategory.getDescription());
        if (exitsSubcategory.isPresent()) {
            return new ResponseEntity<>(new Message("La subcategoria ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("OK", false, subcategoryRepository.saveAndFlush(subcategory)), HttpStatus.OK);
    }

    @Transactional(rollbackOn = {SQLException.class})
    public ResponseEntity<Message> update(SubCategory subcategory) {
        if (!subcategoryRepository.existsById(subcategory.getId())) {
            return new ResponseEntity<>(new Message("La subcategoria no existe", true, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("OK", false, subcategoryRepository.saveAndFlush(subcategory)), HttpStatus.OK);
    }

}
