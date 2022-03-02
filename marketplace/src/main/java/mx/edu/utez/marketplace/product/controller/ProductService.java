package mx.edu.utez.marketplace.product.controller;

import mx.edu.utez.marketplace.product.model.Product;
import mx.edu.utez.marketplace.product.model.ProductImage;
import mx.edu.utez.marketplace.product.model.ProductRepository;
import mx.edu.utez.marketplace.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, productRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (productRepository.existsById(id))
            return new ResponseEntity<>(new Message("Ok", false, productRepository.findById(id)), HttpStatus.OK);
            return new ResponseEntity<>(new Message("No existe este producto", true, null), HttpStatus.BAD_REQUEST);
    }
    //lees y se las pasas a la base de datos
    @Transactional(rollbackFor = {SQLException.class})
     public ResponseEntity<Message> save(Product product){
         Optional<Product> exitsProduct = productRepository.findByName(product.getName());
         if(exitsProduct.isPresent())
             return new ResponseEntity<>(new Message("Este producto ya existe", true, null), HttpStatus.BAD_REQUEST);
         List<ProductImage> images = product.getImages(); //Obtenemos las imagenes temporalmente
         product.setImages(null);
         //Una vez que guardemos nos a a estar regresando nuestro id
         Product saveProduct = productRepository.saveAndFlush(product);
         images.forEach(image -> image.setProduct(saveProduct));
         saveProduct.setImages(images);
         return new ResponseEntity<>(new Message("Ok", false, productRepository.saveAndFlush(saveProduct)), HttpStatus.OK);
     }

     @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Product product){
        if(productRepository.existsById(product.getId()))
            return new ResponseEntity<>(new Message("Ok", false, productRepository.saveAndFlush(product)),HttpStatus.OK);
         return new ResponseEntity<>(new Message("El producto no existe", true, null),HttpStatus.BAD_REQUEST);
     }

    public ResponseEntity<Message> delete(long id){
        if (productRepository.existsById(id))
            return new ResponseEntity<>(new Message("Producto eliminado", false, productRepository.deleteById(id)), HttpStatus.OK);
        return new ResponseEntity<>(new Message("No existe este producto", true, null), HttpStatus.BAD_REQUEST);
    }
}
