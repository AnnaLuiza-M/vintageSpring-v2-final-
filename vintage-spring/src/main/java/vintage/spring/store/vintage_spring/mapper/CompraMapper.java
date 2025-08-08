package vintage.spring.store.vintage_spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import vintage.spring.store.vintage_spring.dto.CompraResponseDto;
import vintage.spring.store.vintage_spring.entities.Compra;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CompraMapper {

    @Mapping(source = "cliente.nome", target = "nome")
    @Mapping(source = "disco.titulo", target = "titulo")
    CompraResponseDto toResponseDto(Compra entity);
}
