package project.Inventario.Exception;

public class ProductoNotFound extends RuntimeException {
    public ProductoNotFound(String message) {
        super(message);
    }
}
