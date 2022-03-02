package mx.edu.utez.marketplace.category.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository                                  //entidad, tipo de dato de su identificador
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
    boolean existsById(long id);

    //findDescription me regresa una categoría, Optional nos ayuda a filtrar o encontrar
    //existsById nos regresa un booleano

    //Optional = Contenedor de categoría

    //Clase que contiene todas nuestras consultas
    //Algún tipo de Dao()
    //Declaro los métodos que ocuparé
}
