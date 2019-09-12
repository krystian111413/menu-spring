package eu.zerter.menu.shared.assemblers;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityAssembler<ENTITY, INSTANCE_DTO, INSTANCE_CREATE_DTO> {
    public abstract ENTITY fromInstanceCreateDto(INSTANCE_CREATE_DTO instanceCreateDto);

    public abstract ENTITY fromInstanceDto(INSTANCE_DTO instance_dto);

    public List<ENTITY> fromInstanceDtoList(List<INSTANCE_DTO> instanceDtoList) {
        return instanceDtoList.stream().map(this::fromInstanceDto).collect(Collectors.toList());
    }

    public List<ENTITY> fromInstanceCreateDtoList(List<INSTANCE_CREATE_DTO> instanceCreateDtoList) {
        return instanceCreateDtoList.stream().map(this::fromInstanceCreateDto).collect(Collectors.toList());
    }

    public abstract void replaceFromInstanceDto(ENTITY entity, INSTANCE_DTO instance_dto);

    public abstract void updateFromInstanceDto(ENTITY entity, INSTANCE_DTO instance_dto);
}
