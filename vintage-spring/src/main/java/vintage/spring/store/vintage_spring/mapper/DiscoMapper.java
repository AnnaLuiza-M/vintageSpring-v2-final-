package vintage.spring.store.vintage_spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import vintage.spring.store.vintage_spring.dto.DiscoCreateDto;
import vintage.spring.store.vintage_spring.dto.DiscoResponseDto;
import vintage.spring.store.vintage_spring.dto.DiscoUpdateDto;
import vintage.spring.store.vintage_spring.entities.Disco;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface DiscoMapper {

    Disco toEntity(DiscoCreateDto dto);

    DiscoResponseDto toResponseDto(Disco entity);

    void updateFromDto(DiscoUpdateDto dto, @MappingTarget Disco entity);
}
