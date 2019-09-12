package eu.zerter.menu.shared.assemblers;

import java.util.List;
import java.util.stream.Collectors;

public abstract class InstanceDtoAssembler<ENTITY, INSTANCE_DTO> {
    public abstract INSTANCE_DTO fromEntity(ENTITY entity);

    public List<INSTANCE_DTO> fromEntityList(List<ENTITY> entityList) {
        return entityList.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
