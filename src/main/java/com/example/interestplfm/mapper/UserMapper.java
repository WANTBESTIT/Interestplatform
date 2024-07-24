package com.example.interestplfm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.interestplfm.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * @author xhb
 * @since 2024/07/23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
