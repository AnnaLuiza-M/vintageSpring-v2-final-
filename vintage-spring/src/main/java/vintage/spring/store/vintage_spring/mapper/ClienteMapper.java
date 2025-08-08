package vintage.spring.store.vintage_spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import vintage.spring.store.vintage_spring.dto.ClienteCreateDto;
import vintage.spring.store.vintage_spring.dto.ClienteResponseDto;
import vintage.spring.store.vintage_spring.dto.ClienteUpdateDto;
import vintage.spring.store.vintage_spring.entities.Cliente;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ClienteMapper {

    Cliente toEntity(ClienteCreateDto dto);

    ClienteResponseDto toResponseDto(Cliente entity);

    void updateFromDto(ClienteUpdateDto dto, @MappingTarget Cliente entity);

}
