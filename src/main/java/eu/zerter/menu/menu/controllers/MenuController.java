package eu.zerter.menu.menu.controllers;

import eu.zerter.menu.menu.services.MenuService;
import eu.zerter.menu.models.MenuCreateDto;
import eu.zerter.menu.models.MenuDto;
import eu.zerter.menu.shared.controllers.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController extends CrudController<MenuDto, MenuCreateDto> {

    public MenuController(MenuService menuService) {
        super(menuService);
    }
}
