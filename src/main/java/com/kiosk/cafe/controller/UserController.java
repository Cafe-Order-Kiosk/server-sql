package com.kiosk.cafe.controller;

import com.kiosk.cafe.dto.User;
import com.kiosk.cafe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

//    @GetMapping("/list")
//    public ResponseEntity<?> getUserList(@RequestBody User user) throws Exception {
//        logger.debug("/user/list @RequestBody user: {}", user);
//        List<User> userList = userService.getUserList(user);
//        Map<String, Object> resultMap = new HashMap<>();
//
//        if(userList != null) {
//            resultMap.put("userList", userList);
//
//
//        }
//
//
//        return
//    }

    @PostMapping("/regist")
    public ResponseEntity<?> registUser(@RequestBody User user) throws Exception {
        logger.debug("/user/regist @RequestBody user: {}", user);

        Map<String, Object> resultMap = new HashMap<>();
        int result = userService.registUser(user);
        logger.debug("regist result => {} ", result );
        switch (result) {
            case -1:
                resultMap.put("message", "중복된 아이디 입니다.");
                return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.FORBIDDEN);
            case 1:
                resultMap.put("message", SUCCESS);
                return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.ACCEPTED);
            default:
                resultMap.put("message", FAIL);
                return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modifySelf(@RequestBody User user) throws Exception {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;

        int result = userService.modifyUser(user);
        if (result != 0) {
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        resultMap.put("message", "회원수정실패");
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> quitMember(@RequestBody User user) throws Exception {
        logger.debug("quitMember user : {}", user);
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;

        int result = userService.removeUser(
                User.builder()
                        .no(user.getNo())
                        .build()
        );
        if (result != 0) {
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
            return new ResponseEntity<Map<String, Object>>(resultMap, status);
        }
        resultMap.put("message", "회원 탈퇴 실패");
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }
}
