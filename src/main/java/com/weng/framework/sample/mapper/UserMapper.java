package com.weng.framework.sample.mapper;

import com.weng.framework.dao.mybatis.mapper.BaseMapper;
import com.weng.framework.sample.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * 用户基础信息表 Mapper 接口
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


}
