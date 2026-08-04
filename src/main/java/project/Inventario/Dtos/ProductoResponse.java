package project.Inventario.Dtos;

public record ProductoResponse(

        Long id,
        String Codigo,
        String Nombre,
        String Descripcion,
        double Precio,
        int Stock,
        boolean Estado
) {
}
