package vintage.spring.store.vintage_spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vintage.spring.store.vintage_spring.dto.CompraCreateDto;
import vintage.spring.store.vintage_spring.dto.CompraResponseDto;
import vintage.spring.store.vintage_spring.entities.Cliente;
import vintage.spring.store.vintage_spring.entities.Compra;
import vintage.spring.store.vintage_spring.entities.Disco;
import vintage.spring.store.vintage_spring.exception.RecursoNaoEncontradoException;
import vintage.spring.store.vintage_spring.mapper.CompraMapper;
import vintage.spring.store.vintage_spring.repository.ClienteRepository;
import vintage.spring.store.vintage_spring.repository.CompraRepository;
import vintage.spring.store.vintage_spring.repository.DiscoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompraService {

    private final CompraRepository compraRepo;
    private final ClienteRepository clienteRepo;
    private final DiscoRepository discoRepo;
    private final CompraMapper mapper;

    public CompraService(CompraRepository compraRepo, ClienteRepository clienteRepo, DiscoRepository discoRepo, CompraMapper mapper) {
        this.compraRepo = compraRepo;
        this.clienteRepo = clienteRepo;
        this.discoRepo = discoRepo;
        this.mapper = mapper;
    }

    public CompraResponseDto salvarCompra(CompraCreateDto dto) {
        Cliente cliente = clienteRepo.findById(dto.getIdCliente())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado: " + dto.getIdCliente()));

        Disco disco = discoRepo.findById(dto.getIdDisco())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Disco não encontrado: " + dto.getIdDisco()));

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setDisco(disco);
        Compra salva = compraRepo.save(compra);
        return mapper.toResponseDto(salva);
    }

    @Transactional(readOnly = true)
    public List<CompraResponseDto> pegarTodasCompras() {
        return compraRepo.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CompraResponseDto buscarCompraPorId(Long id) {
        Compra compra = compraRepo.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Compra não encontrada: " + id));
        return mapper.toResponseDto(compra);
    }

    public void deletarCompra(Long id) {
        if (!compraRepo.existsById(id)) {
            throw new RecursoNaoEncontradoException("Compra não encontrada: " + id);
        }
        compraRepo.deleteById(id);
    }
}
