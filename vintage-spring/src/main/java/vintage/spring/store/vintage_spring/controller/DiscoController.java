package vintage.spring.store.vintage_spring.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vintage.spring.store.vintage_spring.dto.DiscoCreateDto;
import vintage.spring.store.vintage_spring.dto.DiscoResponseDto;
import vintage.spring.store.vintage_spring.dto.DiscoUpdateDto;
import vintage.spring.store.vintage_spring.entities.Disco;
import vintage.spring.store.vintage_spring.service.DiscoService;

import java.util.List;

@RestController
@RequestMapping("/disco")
public class DiscoController {

    @Autowired
    DiscoService discoService;

    public DiscoController(DiscoService discoService) {
        this.discoService = discoService;
    }

    @GetMapping
    public ResponseEntity<List<DiscoResponseDto>> listarDisco() {
        List<DiscoResponseDto> discos = discoService.pegarTodosDiscos();
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscoResponseDto> findById(@PathVariable Long id) {
        DiscoResponseDto disco = discoService.buscarDiscoPorId(id);
        if(disco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(disco);
    }

    @PostMapping
    public ResponseEntity<DiscoResponseDto> salvarDisco(@RequestBody @Valid DiscoCreateDto novoDisco) {
        DiscoResponseDto discoCriado = discoService.salvarDisco(novoDisco);
        return ResponseEntity.status(HttpStatus.CREATED).body(discoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscoResponseDto> atualizarDisco(@PathVariable Long id, @RequestBody DiscoUpdateDto novoDisco) {
        DiscoResponseDto discoAtualizado = discoService.atualizarDisco(id, novoDisco);
        if(discoAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(discoAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DiscoResponseDto> deletarDisco(@PathVariable Long id) {
        DiscoResponseDto disco = discoService.buscarDiscoPorId(id);
        if(disco == null) {
            return ResponseEntity.notFound().build();
        }
        discoService.deletarDisco(id);
        return ResponseEntity.ok(disco);
    }
}
