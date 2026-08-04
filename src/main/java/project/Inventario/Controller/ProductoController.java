package project.Inventario.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.Inventario.Dtos.ProductosResponse;
import project.Inventario.Service.ProductoService;
import project.Inventario.Dtos.ResponseApi;

@RestController
@RequestMapping("inventario")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){

        this.productoService = productoService;
    }

    @Operation(
            summary = "Obtener todos los productos",
            description = "Obtiene la lista de todos los productos registrados en el inventario."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos obtenidos exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping()
    public ResponseEntity<ResponseApi<ProductosResponse>> obtenerProductos(){

        HttpStatus status = HttpStatus.OK;

        ProductosResponse productos = productoService.obtenerProductos();

        ResponseApi<ProductosResponse> response =
                new ResponseApi<>(status.getReasonPhrase(), productos);

        return ResponseEntity.ok(response);
    }



}
