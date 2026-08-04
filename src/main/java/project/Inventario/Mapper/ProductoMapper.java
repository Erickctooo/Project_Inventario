package project.Inventario.Mapper;

import project.Inventario.Dtos.ProductoResponse;
import project.Inventario.Dtos.ProductosResponse;
import project.Inventario.Entity.Producto;

import java.util.List;

public class ProductoMapper {

    public static ProductoResponse toResponse(Producto producto){

        return new ProductoResponse(

                producto.getId(),
                producto.getCodigo(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.isEstado()

        );
    }

    public static ProductosResponse tooResponse(List<Producto> productos){

        return new ProductosResponse(
                productos.stream().map(ProductoMapper::toResponse).toList()
        );
    }
}
