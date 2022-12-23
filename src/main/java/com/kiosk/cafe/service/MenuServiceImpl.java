package com.kiosk.cafe.service;

import com.kiosk.cafe.dto.Menu;
import com.kiosk.cafe.dto.MenuSearchDto;
import com.kiosk.cafe.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<Menu> getMenuList(MenuSearchDto menuSearchDto) throws Exception {
        return menuMapper.selectMenuList(menuSearchDto);
    }

    @Override
    public Menu getMenuInfo(int no) throws Exception {
        return menuMapper.selectMenuInfo(no);
    }

    @Override
    public int registMenu(Menu menu) throws Exception {
        return menuMapper.insertMenu(menu);
    }

    @Override
    public int modifyMenu(Menu menu) throws Exception {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int removeMenu(Menu menu) throws Exception {
        return menuMapper.deleteMenu(menu);
    }

    @Override
    public void modifySaleCount(int no) throws Exception {
        menuMapper.updateSaleCount(no);
    }
}
