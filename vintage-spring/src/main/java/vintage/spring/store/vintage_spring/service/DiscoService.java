package vintage.spring.store.vintage_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vintage.spring.store.vintage_spring.dto.DiscoCreateDto;
import vintage.spring.store.vintage_spring.dto.DiscoResponseDto;
import vintage.spring.store.vintage_spring.dto.DiscoUpdateDto;
import vintage.spring.store.vintage_spring.entities.Disco;
import vintage.spring.store.vintage_spring.exception.RecursoNaoEncontradoException;
import vintage.spring.store.vintage_spring.mapper.DiscoMapper;
import vintage.spring.store.vintage_spring.repository.DiscoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DiscoService {

    private final DiscoRepository repo;
    private final DiscoMapper mapper;

    public DiscoService(DiscoRepository repo, DiscoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public DiscoResponseDto salvarDisco(DiscoCreateDto dto) {
        System.out.println("DTO recebido:");
        System.out.println("Título: " + dto.getTitulo());
        System.out.println("Artista: " + dto.getArtista());
        System.out.println("Preço: " + dto.getPreco());
        Disco entity = mapper.toEntity(dto);
        Disco salvo = repo.save(entity);
        return mapper.toResponseDto(salvo);
    }

    @Transactional(readOnly = true)
    public List<DiscoResponseDto> pegarTodosDiscos() {
        return repo.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DiscoResponseDto buscarDiscoPorId(Long id) {
        Disco entity = repo.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disco não encontrado: " + id));
        return mapper.toResponseDto(entity);
    }

    public DiscoResponseDto atualizarDisco(Long id, DiscoUpdateDto dto) {
        Disco entity = repo.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disco não encontrado: " + id));

        mapper.updateFromDto(dto, entity);
        Disco salvo = repo.save(entity);
        return mapper.toResponseDto(salvo);
    }

    public void deletarDisco(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNaoEncontradoException("Disco não encontrado: " + id);
        }
        repo.deleteById(id);
    }
}
