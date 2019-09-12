package eu.zerter.menu.menu.assemblers;

import eu.zerter.menu.menu.entities.Menu;
import eu.zerter.menu.models.MenuCreateDto;
import eu.zerter.menu.models.MenuDto;
import eu.zerter.menu.shared.assemblers.EntityAssembler;
import org.springframework.stereotype.Component;

@Component
public class MenuAssembler extends EntityAssembler<Menu, MenuDto, MenuCreateDto> {

    @Override
    public Menu fromInstanceCreateDto(MenuCreateDto menuCreateDto) {
        Menu menu = new Menu();
        menu.setName(menuCreateDto.getName());
        menu.setCreatedOn(menuCreateDto.getCreatedOn());
        return menu;
    }

    @Override
    public Menu fromInstanceDto(MenuDto menuDto) {
        Menu menu = new Menu();
        menu.setId(menuDto.getId());
        menu.setCreatedOn(menuDto.getCreatedOn());
        menuDto.setName(menuDto.getName());
        return menu;
    }

    @Override
    public void replaceFromInstanceDto(Menu menu, MenuDto menuDto) {
        menu.setName(menuDto.getName());
    }

    @Override
    public void updateFromInstanceDto(Menu menu, MenuDto menuDto) {
        if (menuDto.getName() != null) {
            menu.setName(menuDto.getName());
        }
    }
}
