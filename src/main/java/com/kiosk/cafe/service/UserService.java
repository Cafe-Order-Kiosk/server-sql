package com.kiosk.cafe.service;

import com.kiosk.cafe.dto.User;
import com.kiosk.cafe.dto.UserPointDto;

import java.util.List;

public interface UserService {
    public List<User> getUserList(User user) throws Exception;
    public User getUserInfo(int no) throws Exception;
    public int registUser(User user) throws Exception;
    public int modifyUser(User user) throws Exception;
    public int removeUser(User user) throws Exception;
    public int modifyUserPoint(UserPointDto userPointDto) throws Exception;
}
