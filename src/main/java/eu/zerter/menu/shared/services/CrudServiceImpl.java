package eu.zerter.menu.shared.services;

import eu.zerter.menu.shared.assemblers.EntityAssembler;
import eu.zerter.menu.shared.assemblers.InstanceDtoAssembler;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@AllArgsConstructor
@Service
public abstract class CrudServiceImpl<ENTITY, INSTANCE_DTO, INSTANCE_CREATE_DTO> implements CrudService<INSTANCE_DTO, INSTANCE_CREATE_DTO> {

    private final MongoRepository<ENTITY, String> repository;

    private final InstanceDtoAssembler<ENTITY, INSTANCE_DTO> instanceDtoAssembler;
    private final EntityAssembler<ENTITY, INSTANCE_DTO, INSTANCE_CREATE_DTO> entityAssembler;

    @Override
    public List<INSTANCE_DTO> findAll() {
        List<ENTITY> entityList = repository.findAll();
        return instanceDtoAssembler.fromEntityList(entityList);
    }

    @Override
    public void create(INSTANCE_CREATE_DTO instanceCreateDto) {
        ENTITY entity = entityAssembler.fromInstanceCreateDto(instanceCreateDto);
        repository.save(entity);
    }

    @Override
    public void createAll(List<INSTANCE_CREATE_DTO> instanceCreateDtoList) {
        List<ENTITY> entityList = entityAssembler.fromInstanceCreateDtoList(instanceCreateDtoList);
        repository.saveAll(entityList);
    }

    @Override
    public INSTANCE_DTO findById(String id) {
        ENTITY entity = repository.findById(id).orElseThrow(() -> {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Entity with that id doesn't exists");
        });
        return instanceDtoAssembler.fromEntity(entity);
    }

    @Override
    public void replace(String id, INSTANCE_DTO instance_dto) {
        ENTITY entity = repository.findById(id).orElseThrow(() -> {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Entity with that id doesn't exists");
        });
        entityAssembler.replaceFromInstanceDto(entity, instance_dto);
        repository.save(entity);
    }

    @Override
    public void update(String id, INSTANCE_DTO instance_dto) {
        ENTITY entity = repository.findById(id).orElseThrow(() -> {
            throw new HttpServerErrorException(HttpStatus.BAD_REQUEST, "Entity with that id doesn't exists");
        });
        entityAssembler.updateFromInstanceDto(entity, instance_dto);
        repository.save(entity);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
