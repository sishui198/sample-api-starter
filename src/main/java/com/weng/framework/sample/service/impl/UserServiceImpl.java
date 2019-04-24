package com.weng.framework.sample.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weng.framework.common.exception.GlobalServiceException;
import com.weng.framework.common.exception.ResultCodeEnum;
import com.weng.framework.common.model.vo.PageRequestVO;
import com.weng.framework.core.model.ResponseData;
import com.weng.framework.dao.mybatis.model.page.PageModel;
import com.weng.framework.dao.mybatis.service.BaseServiceImpl;
import com.weng.framework.sample.entity.User;
import com.weng.framework.sample.mapper.UserMapper;
import com.weng.framework.sample.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Arrays;


/**
 * 用户基础信息表 服务实现类
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */ 
@Slf4j
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements IUserService {
	@Autowired
	private UserMapper userMapper;
	

	/**
	 * 分页查询用户基础信息表
	 * @param pageReq
	 * @return
	 */
	@Override
	public IPage<User> list(PageRequestVO pageReq) {
		QueryWrapper<User> qw = new QueryWrapper<User>();
		IPage<User> page = new PageModel<User>(pageReq.getPageNo(),pageReq.getPageSize());
		return userMapper.selectPage(page,qw);
	}



	@Override
	public User getById(Serializable id) {
		return super.getById(id);
	}

	/**
	 * 新增单个用户基础信息表
	 * @param user
	 * @return
	 */
	@Override
	public User add(User user) throws GlobalServiceException {
		
		userMapper.insert(user);
		return user;
	}

	/**
	 * 更新单个用户基础信息表
	 * @param user
	 * @return
	 * @throws GlobalServiceException
	 */
	@Override
	public int update(User user) throws GlobalServiceException {

		return userMapper.updateById(user);

	}


	@Override
	public ResponseData removeByIds(String ids) {
		String[] userIds = ids.split(",");
		boolean flag = this.removeByIds(Arrays.asList(userIds));
		if (flag) {
			return ResponseData.success();
		} else {
			throw new GlobalServiceException(ResultCodeEnum.DATABASE_OPERATE_EXCEPTION.getCode(), "删除用户基础信息表：" + Arrays.asList(userIds).toString() + ResultCodeEnum.DATABASE_OPERATE_EXCEPTION.getMessage());
		}
	}

}
