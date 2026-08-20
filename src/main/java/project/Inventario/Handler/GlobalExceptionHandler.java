package project.Inventario.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.Inventario.Dtos.ResponseApi;
import project.Inventario.Exception.ProductoNotFound;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNotFound.class)
    public ResponseEntity<ResponseApi<Void>> handleProductoNotFound(ProductoNotFound ex){

        HttpStatus status = HttpStatus.NOT_FOUND;

        ResponseApi<Void> response =
                new ResponseApi<>(status.value(), ex.getMessage(), null);

        return ResponseEntity.status(status).body(response);
    }
}
