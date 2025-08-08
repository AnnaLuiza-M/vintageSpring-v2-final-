package vintage.spring.store.vintage_spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vintage.spring.store.vintage_spring.dto.CompraCreateDto;
import vintage.spring.store.vintage_spring.dto.CompraResponseDto;
import vintage.spring.store.vintage_spring.service.CompraService;

import java.util.List;
@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
     CompraService compraService;


    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public ResponseEntity<List<CompraResponseDto>> findAll() {
        List<CompraResponseDto> compras = compraService.pegarTodasCompras();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraResponseDto> findById(@PathVariable Long id) {
        CompraResponseDto compra = compraService.buscarCompraPorId(id);

        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compra);
    }

    @PostMapping
    public ResponseEntity<CompraResponseDto> create(@RequestBody CompraCreateDto novaCompra){
        CompraResponseDto compraCriada = compraService.salvarCompra(novaCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(compraCriada);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<CompraResponseDto> deleteById(@PathVariable Long id){
        CompraResponseDto compra = compraService.buscarCompraPorId(id);

        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        compraService.deletarCompra(id);
        return ResponseEntity.ok(compra);
    }
}
