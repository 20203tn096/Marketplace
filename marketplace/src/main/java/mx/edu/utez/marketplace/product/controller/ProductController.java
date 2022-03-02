package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.product.model.ProductImage;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = {"*"})
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return productService.findAll();
    }

    //requestparam va después del signo de admiración
    //pathvariable va directo en la uri
    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return  productService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody ProductDTO productDTO){
        List<ProductImage> images = new ArrayList<>();
    productDTO.getImages().forEach(image ->
            images.add(new ProductImage(image.getId(), image.getName(),
                    Base64.getDecoder().decode(image.getFileBase64().replace("", "+")), null)));
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getBrand(), productDTO.getPrice()
                ,productDTO.getQuantity(),productDTO.getStatus(), productDTO.getSubCategory(),images);
        return  productService.save(product);
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody ProductDTO productDTO){
        Product product = new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getBrand(), productDTO.getPrice()
                ,productDTO.getQuantity(),productDTO.getStatus(), productDTO.getSubCategory(),new ArrayList<>());
        return  productService.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> delete(@PathVariable("id") long id){
        return productService.delete(id);
    }
}
