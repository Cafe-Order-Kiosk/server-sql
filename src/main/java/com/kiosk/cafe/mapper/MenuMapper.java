package com.kiosk.cafe.mapper;

import com.kiosk.cafe.dto.Menu;
import com.kiosk.cafe.dto.MenuSearchDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper {

    public List<Menu> selectMenuList(MenuSearchDto menuSearchDto) throws Exception;
    public Menu selectMenuInfo(int no) throws Exception;
    public int insertMenu(Menu menu) throws Exception;
    public int updateMenu(Menu menu) throws Exception;
    public int deleteMenu(Integer no) throws Exception;
    public void updateSaleCount(Integer no) throws Exception;

}
