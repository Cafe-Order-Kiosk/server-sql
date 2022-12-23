package com.kiosk.cafe.service;

import com.kiosk.cafe.dto.User;
import com.kiosk.cafe.dto.UserPointDto;
import com.kiosk.cafe.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getUserList(User user) throws Exception {
        return userMapper.selectUserList(user);
    }

    @Override
    public User getUserInfo(int no) throws Exception {
        return userMapper.selectUserInfo(no);
    }

    @Override
    public int registUser(User user) throws Exception {
        return userMapper.insertUser(user);
    }

    @Override
    public int modifyUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }

    @Override
    public int removeUser(User user) throws Exception {
        return userMapper.deleteUser(user);
    }

    @Override
    public int modifyUserPoint(UserPointDto userPointDto) throws Exception {
        User curUser = userMapper.selectUserInfo(userPointDto.getNo());
        int curUserPoint = curUser.getPoint();
        UserPointDto modifyUserPointDto = new UserPointDto(userPointDto.getNo(), curUserPoint - userPointDto.getPoint());
        return userMapper.updateUserPoint(modifyUserPointDto);
    }
}
