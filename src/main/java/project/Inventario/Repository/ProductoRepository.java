package project.Inventario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.Inventario.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
