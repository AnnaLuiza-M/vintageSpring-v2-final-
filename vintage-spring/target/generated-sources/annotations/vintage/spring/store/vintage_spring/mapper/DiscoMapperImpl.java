package vintage.spring.store.vintage_spring.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import vintage.spring.store.vintage_spring.dto.DiscoCreateDto;
import vintage.spring.store.vintage_spring.dto.DiscoResponseDto;
import vintage.spring.store.vintage_spring.dto.DiscoUpdateDto;
import vintage.spring.store.vintage_spring.entities.Disco;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-08T20:20:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class DiscoMapperImpl implements DiscoMapper {

    @Override
    public Disco toEntity(DiscoCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        Disco disco = new Disco();

        disco.setTitulo( dto.getTitulo() );
        disco.setArtista( dto.getArtista() );
        disco.setPreco( dto.getPreco() );

        return disco;
    }

    @Override
    public DiscoResponseDto toResponseDto(Disco entity) {
        if ( entity == null ) {
            return null;
        }

        DiscoResponseDto discoResponseDto = new DiscoResponseDto();

        discoResponseDto.setId( entity.getId() );
        discoResponseDto.setTitulo( entity.getTitulo() );
        discoResponseDto.setArtista( entity.getArtista() );
        discoResponseDto.setPreco( entity.getPreco() );

        return discoResponseDto;
    }

    @Override
    public void updateFromDto(DiscoUpdateDto dto, Disco entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getTitulo() != null ) {
            entity.setTitulo( dto.getTitulo() );
        }
        if ( dto.getArtista() != null ) {
            entity.setArtista( dto.getArtista() );
        }
        if ( dto.getPreco() != null ) {
            entity.setPreco( dto.getPreco() );
        }
    }
}
