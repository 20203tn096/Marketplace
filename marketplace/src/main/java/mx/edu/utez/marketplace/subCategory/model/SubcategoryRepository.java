package mx.edu.utez.marketplace.subCategory.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubCategory, Long> {
    //optional es un tipo de contenedor, tiene métodos
    Optional<SubCategory> findByDescription(String description);
    boolean existsById(long id);
    List<SubCategory> findAllByCategoryId(long id);
}
