package com.kiosk.cafe.mapper;

import com.kiosk.cafe.dto.User;
import com.kiosk.cafe.dto.UserPointDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> selectUserList(User user) throws Exception;
    public User selectUserInfo(int no) throws Exception;
    public int insertUser(User user) throws Exception;
    public int updateUser(User user) throws Exception;
    public int deleteUser(User user) throws Exception;
    public int updateUserPoint(UserPointDto userPointDto) throws Exception;
}
