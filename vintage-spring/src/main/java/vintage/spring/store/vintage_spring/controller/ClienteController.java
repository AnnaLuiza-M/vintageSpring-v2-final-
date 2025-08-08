package vintage.spring.store.vintage_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vintage.spring.store.vintage_spring.dto.ClienteCreateDto;
import vintage.spring.store.vintage_spring.dto.ClienteResponseDto;
import vintage.spring.store.vintage_spring.dto.ClienteUpdateDto;
import vintage.spring.store.vintage_spring.entities.Cliente;
import vintage.spring.store.vintage_spring.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>>  findAll() {
       List<ClienteResponseDto> clientes = clienteService.pegarTodosClientes();
       return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id) {
        ClienteResponseDto cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(@RequestBody ClienteCreateDto novoCliente){
        ClienteResponseDto clienteCriado = clienteService.salvarCliente(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> update(@PathVariable Long id, @RequestBody ClienteUpdateDto novoCliente){
        ClienteResponseDto clienteAtualizado = clienteService.atualizarCliente(id, novoCliente);

        if (clienteAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> deleteById(@PathVariable Long id){
        ClienteResponseDto cliente = clienteService.buscarClientePorId(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deletarCliente(id);
        return ResponseEntity.ok(cliente);
    }
}
