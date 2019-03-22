package com.weng.framework.sample.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.weng.framework.dao.mybatis.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户基础信息表实体Bean
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	@TableId(value = "id")
	private String id;

	/**
     * 登录账号
     */
	@TableField(value="account")
	private String account;
	
	/**
     * 密码（md5）
     */
	@TableField(value="pwd")
	private String pwd;
	
	/**
     * 真实姓名
     */
	@TableField(value="truename")
	private String truename;
	
	/**
     * 手机号码
     */
	@TableField(value="mobile")
	private String mobile;
	
	/**
     * 电子邮箱
     */
	@TableField(value="email")
	private String email;
	
	/**
     * 身份证号
     */
	@TableField(value="id_card")
	private String idCard;
	

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
