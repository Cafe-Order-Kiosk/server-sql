package com.kiosk.cafe.controller;

import com.kiosk.cafe.dto.Menu;
import com.kiosk.cafe.dto.MenuSearchDto;
import com.kiosk.cafe.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private MenuService menuService;

    // 해당 카테고리 메뉴 리스트 가져오기
    @PutMapping("/list")
    public ResponseEntity<List<Menu>> getMenuList(@RequestBody MenuSearchDto menuSearchDto) throws Exception {
        return ResponseEntity.ok().body(menuService.getMenuList(menuSearchDto));
    }

    // 해당 메뉴 가져오기
    @GetMapping("/{no}")
    public ResponseEntity<?> getMenuInfo(@PathVariable("no") int no) throws Exception {
        logger.debug("get menu no : {}",no);
        logger.debug("menuService.getMenuInfo(no) : {}", menuService.getMenuInfo(no));
        return ResponseEntity.ok().body(menuService.getMenuInfo(no));
    }

    // 메뉴 등록하기
    @PostMapping("/regist")
    public ResponseEntity<Void> registMenu(@RequestBody Menu menu) throws Exception{
        menuService.registMenu(menu);
        return ResponseEntity.ok().build();
    }

    // 메뉴 수정하기
    @PutMapping("/modify")
    public ResponseEntity<Void> modifyMenu(@RequestBody Menu menu) throws Exception {
        menuService.modifyMenu(menu);
        return ResponseEntity.ok().build();
    }

    // 메뉴 삭제하기
    @DeleteMapping("/{no}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Integer no) throws Exception {
        menuService.removeMenu(no);
        return ResponseEntity.ok().build();
    }

}
