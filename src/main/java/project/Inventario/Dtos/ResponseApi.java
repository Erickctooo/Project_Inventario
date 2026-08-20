package project.Inventario.Dtos;

public record ResponseApi<T>(
        int httpCode,
        String httpmessage,
        T data
) {
}
