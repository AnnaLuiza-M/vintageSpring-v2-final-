package vintage.spring.store.vintage_spring.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vintage.spring.store.vintage_spring.dto.CompraResponseDto;
import vintage.spring.store.vintage_spring.entities.Cliente;
import vintage.spring.store.vintage_spring.entities.Compra;
import vintage.spring.store.vintage_spring.entities.Disco;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T20:20:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class CompraMapperImpl implements CompraMapper {

    @Override
    public CompraResponseDto toResponseDto(Compra entity) {
        if ( entity == null ) {
            return null;
        }

        CompraResponseDto compraResponseDto = new CompraResponseDto();

        compraResponseDto.setNome( entityClienteNome( entity ) );
        compraResponseDto.setTitulo( entityDiscoTitulo( entity ) );
        compraResponseDto.setId( entity.getId() );

        return compraResponseDto;
    }

    private String entityClienteNome(Compra compra) {
        if ( compra == null ) {
            return null;
        }
        Cliente cliente = compra.getCliente();
        if ( cliente == null ) {
            return null;
        }
        String nome = cliente.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }

    private String entityDiscoTitulo(Compra compra) {
        if ( compra == null ) {
            return null;
        }
        Disco disco = compra.getDisco();
        if ( disco == null ) {
            return null;
        }
        String titulo = disco.getTitulo();
        if ( titulo == null ) {
            return null;
        }
        return titulo;
    }
}
