package vintage.spring.store.vintage_spring.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vintage.spring.store.vintage_spring.dto.ClienteCreateDto;
import vintage.spring.store.vintage_spring.dto.ClienteResponseDto;
import vintage.spring.store.vintage_spring.dto.ClienteUpdateDto;
import vintage.spring.store.vintage_spring.entities.Cliente;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T20:20:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toEntity(ClienteCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNome( dto.getNome() );
        cliente.setEmail( dto.getEmail() );

        return cliente;
    }

    @Override
    public ClienteResponseDto toResponseDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();

        clienteResponseDto.setNome( entity.getNome() );
        clienteResponseDto.setEmail( entity.getEmail() );
        clienteResponseDto.setId( entity.getId() );

        return clienteResponseDto;
    }

    @Override
    public void updateFromDto(ClienteUpdateDto dto, Cliente entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getNome() != null ) {
            entity.setNome( dto.getNome() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
    }
}
