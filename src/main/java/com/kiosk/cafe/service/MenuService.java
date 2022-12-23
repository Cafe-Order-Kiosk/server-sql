package com.kiosk.cafe.service;

import com.kiosk.cafe.dto.Menu;
import com.kiosk.cafe.dto.MenuSearchDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuService {

    public List<Menu> getMenuList(MenuSearchDto menuSearchDto) throws Exception;
    public Menu getMenuInfo(int no) throws Exception;
    public int registMenu(Menu menu) throws Exception;
    public int modifyMenu(Menu menu) throws Exception;
    public int removeMenu(Menu menu) throws Exception;
    public void modifySaleCount(int no) throws Exception;
}
