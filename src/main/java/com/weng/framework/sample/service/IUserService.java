package com.weng.framework.sample.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weng.framework.common.exception.GlobalServiceException;
import com.weng.framework.common.model.vo.PageRequestVO;
import com.weng.framework.core.model.ResponseData;
import com.weng.framework.sample.entity.User;


/**
 * 用户基础信息表 服务接口
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */  
public interface IUserService extends IService<User> {
    
	/**
	 * 新建单个
	 */
	public User add(User code) throws GlobalServiceException;

	/**
	 * 自定义更新条件
	 */
	public int update(User code) throws GlobalServiceException;

	public ResponseData removeByIds(String ids);

	/**
	 *  列表查询base
	 *  <p>
	 *      自定义列表查询：需实现定制化业务，组合查询，多分页查询等
	 */
	IPage<User> list(PageRequestVO pageReq);

}
