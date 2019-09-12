package eu.zerter.menu.shared.controllers;

import eu.zerter.menu.shared.services.CrudService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
public abstract class CrudController<INSTANCE_DTO, INSTANCE_CREATE_DTO> {

    private final CrudService<INSTANCE_DTO, INSTANCE_CREATE_DTO> crudService;

    @GetMapping
    List<INSTANCE_DTO> findAll() {
        return crudService.findAll();
    }

    @GetMapping("/{id}")
    INSTANCE_DTO findById(@PathVariable String id) {
        return crudService.findById(id);
    }

    @PostMapping
    void create(@RequestBody INSTANCE_CREATE_DTO instanceCreateDto) {
        crudService.create(instanceCreateDto);
    }

    @PostMapping("/all")
    void createAll(@RequestBody List<INSTANCE_CREATE_DTO> instanceCreateDtoList) {
        crudService.createAll(instanceCreateDtoList);
    }

    @PutMapping(value = "/{id}")
    void replace(@PathVariable String id, @RequestBody INSTANCE_DTO instance_dto) {
        crudService.replace(id, instance_dto);
    }

    @PatchMapping("/{id}")
    void update(@PathVariable String id, @RequestBody INSTANCE_DTO instance_dto) {
        crudService.update(id, instance_dto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        crudService.delete(id);
    }




}
