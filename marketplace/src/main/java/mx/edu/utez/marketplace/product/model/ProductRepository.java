package mx.edu.utez.marketplace.product.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);
    boolean existsById(long id);
    Optional<Product> deleteById(long id);
}
