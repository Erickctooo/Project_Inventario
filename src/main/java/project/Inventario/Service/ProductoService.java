package project.Inventario.Service;

import org.springframework.stereotype.Service;
import project.Inventario.Dtos.ProductoResponse;
import project.Inventario.Dtos.ProductosResponse;
import project.Inventario.Entity.Producto;
import project.Inventario.Exception.ProductoNotFound;
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

    public ProductoResponse obtenerById(Long id){

        Producto producto = productoRepository.findById(id).orElseThrow(()-> new ProductoNotFound("Product Not Found"));

        return ProductoMapper.toResponse(producto);
    }

    public ProductosResponse obtenerByNombre(String nombre){

        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);

        if(productos.isEmpty())
            throw new ProductoNotFound("Products Not Found");

        return ProductoMapper.tooResponse(productos);
    }

}
