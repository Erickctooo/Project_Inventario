package project.Inventario.Service;

import org.springframework.stereotype.Service;
import project.Inventario.Dtos.ProductosResponse;
import project.Inventario.Entity.Producto;
import project.Inventario.Mapper.ProductoMapper;
import project.Inventario.Repository.ProductoRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public ProductosResponse obtenerProductos(){

        List<Producto> productos = productoRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Producto::getId))
                .toList();
        return ProductoMapper.tooResponse(productos);
    }

}
