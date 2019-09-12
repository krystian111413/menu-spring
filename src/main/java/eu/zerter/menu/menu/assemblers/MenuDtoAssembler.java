package eu.zerter.menu.menu.assemblers;

import eu.zerter.menu.menu.entities.Menu;
import eu.zerter.menu.models.MenuDto;
import eu.zerter.menu.shared.assemblers.InstanceDtoAssembler;
import org.springframework.stereotype.Component;

@Component
public class MenuDtoAssembler extends InstanceDtoAssembler<Menu, MenuDto> {

    @Override
    public MenuDto fromEntity(Menu menu) {
        MenuDto menuDto = new MenuDto();
        menuDto.setId(menu.getId());
        menuDto.setName(menu.getName());
        menuDto.setCreatedOn(menu.getCreatedOn());
        return menuDto;
    }
}
