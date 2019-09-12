package eu.zerter.menu.shared.services;

import java.util.List;

public interface CrudService<INSTANCE_DTO, INSTANCE_CREATE_DTO> {

    public List<INSTANCE_DTO> findAll();

    public void create(INSTANCE_CREATE_DTO instanceCreateDto);

    public void createAll(List<INSTANCE_CREATE_DTO> instanceCreateDtoList);

    INSTANCE_DTO findById(String id);

    void replace(String id, INSTANCE_DTO instance_dto);

    void update(String id, INSTANCE_DTO instance_dto);

    void delete(String id);
}
