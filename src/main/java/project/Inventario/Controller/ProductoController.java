package project.Inventario.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.Inventario.Dtos.ProductoResponse;
import project.Inventario.Dtos.ProductosResponse;
import project.Inventario.Service.ProductoService;
import project.Inventario.Dtos.ResponseApi;

@RestController
@RequestMapping("producto")
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
                new ResponseApi<>(status.value(),status.getReasonPhrase(), productos);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Obtener producto por su Id",
            description = "Obtiene un producto de lista de productos registrados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido exitosamente"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ResponseApi<ProductoResponse>> obtenerById(@PathVariable Long id){

        HttpStatus status = HttpStatus.OK;

        ProductoResponse producto = productoService.obtenerById(id);

        ResponseApi<ProductoResponse> response =
                new ResponseApi<>(status.value(),status.getReasonPhrase(), producto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/buscar")
    public ResponseEntity<ResponseApi<ProductosResponse>> obtenerByNombre(@RequestParam String nombre){

        HttpStatus status = HttpStatus.OK;

        ProductosResponse productos = productoService.obtenerByNombre(nombre);

        ResponseApi<ProductosResponse> response =
                new ResponseApi<>(status.value(),status.getReasonPhrase(), productos);

        return ResponseEntity.ok(response);
    }



}
