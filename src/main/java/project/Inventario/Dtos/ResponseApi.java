package project.Inventario.Dtos;

public record ResponseApi<T>(
        String message,
        T data
) {
}
