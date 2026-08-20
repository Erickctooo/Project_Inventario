package project.Inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Inventario.Entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByNombreContainingIgnoreCase(String nombre);

}
