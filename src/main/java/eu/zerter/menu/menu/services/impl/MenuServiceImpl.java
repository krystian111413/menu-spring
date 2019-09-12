package eu.zerter.menu.menu.services.impl;

import eu.zerter.menu.menu.assemblers.MenuAssembler;
import eu.zerter.menu.menu.assemblers.MenuDtoAssembler;
import eu.zerter.menu.menu.entities.Menu;
import eu.zerter.menu.menu.repositories.MenuRepositories;
import eu.zerter.menu.menu.services.MenuService;
import eu.zerter.menu.models.MenuCreateDto;
import eu.zerter.menu.models.MenuDto;
import eu.zerter.menu.shared.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends CrudServiceImpl<Menu, MenuDto, MenuCreateDto> implements MenuService {

    public MenuServiceImpl(
            MenuRepositories menuRepositories,
            MenuDtoAssembler menuDtoAssembler,
            MenuAssembler menuAssembler
            ) {
        super(menuRepositories, menuDtoAssembler, menuAssembler);
    }


}
