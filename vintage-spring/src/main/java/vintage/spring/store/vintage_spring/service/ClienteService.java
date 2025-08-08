package vintage.spring.store.vintage_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vintage.spring.store.vintage_spring.dto.ClienteCreateDto;
import vintage.spring.store.vintage_spring.dto.ClienteResponseDto;
import vintage.spring.store.vintage_spring.dto.ClienteUpdateDto;
import vintage.spring.store.vintage_spring.entities.Cliente;
import vintage.spring.store.vintage_spring.exception.RecursoNaoEncontradoException;
import vintage.spring.store.vintage_spring.mapper.ClienteMapper;
import vintage.spring.store.vintage_spring.repository.ClienteRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClienteService {

    private final ClienteRepository repo;
    private final ClienteMapper mapper;

    public ClienteService(ClienteRepository repo, ClienteMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ClienteResponseDto salvarCliente(ClienteCreateDto dto) {
        Cliente entity = mapper.toEntity(dto);
        Cliente salvo = repo.save(entity);
        return mapper.toResponseDto(salvo);
    }

    @Transactional(readOnly = true)
    public List<ClienteResponseDto> pegarTodosClientes() {
        return repo.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClienteResponseDto buscarClientePorId(Long id) {
        Cliente entity = repo.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado: " + id));
        return mapper.toResponseDto(entity);
    }

    public ClienteResponseDto atualizarCliente(Long id, ClienteUpdateDto dto) {
        Cliente entity = repo.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado: " + id));
        mapper.updateFromDto(dto, entity);
        Cliente salvo = repo.save(entity);
        return mapper.toResponseDto(salvo);
    }

    public void deletarCliente(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNaoEncontradoException("Cliente não encontrado: " + id);
        }
        repo.deleteById(id);
    }
}
