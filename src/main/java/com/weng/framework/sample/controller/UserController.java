package com.weng.framework.sample.controller;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.weng.framework.common.model.vo.PageRequestVO;
import com.weng.framework.sample.entity.User;
import com.weng.framework.sample.model.req.UserReq;
import com.weng.framework.sample.service.IUserService;
import com.weng.framework.web.base.BaseController;
import com.weng.framework.web.model.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;


/**
 * 用户基础信息表 前端控制器
 *
 * @author wengzhonghui
 * @date 2019-03-11 07:18:17
 *
 */  
@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "用户基础信息表api", tags = {"用户基础信息表操作接口"})
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * 功能描述:单个获取用户基础信息表
     */
    @ApiOperation(value = "获取用户基础信息表", notes = "")
    @GetMapping(value = "/get")
    public ResponseData getById(String id){
        User user = userService.getById(id);
        return success(user);
    }


    /**
     * 条件 分页查询用户基础信息表
     */
    @ApiOperation(value = "分页获取用户基础信息表", notes = "")
    @GetMapping(value = "/list")
    public ResponseData list(PageRequestVO pageReq){
		IPage<User> iPage = userService.list(pageReq);
        return success(iPage);
    }


    /**
	 * 新增用户基础信息表
	 */
	@ApiOperation(value = "新增用户基础信息表", notes = "")
	@PostMapping(value = "/add")
	public ResponseData add(@Valid @RequestBody UserReq userReq){
		User user = Convert.convert(User.class, userReq);
		userService.add(user);
		return success();
	}

	/**
	 * 更新用户基础信息表
	 */
	@ApiOperation(value = "更新用户基础信息表", notes = "")
	@PostMapping(value = "/update")
	public ResponseData update(@Valid @RequestBody UserReq userReq){
		User user = Convert.convert(User.class, userReq);
		int flag = userService.update(user);
		return success(flag);
	}


	/**
	 * 删除用户基础信息表
	 */
	@ApiOperation(value = "删除用户基础信息表", notes = "可以删除多个，中间以,号分隔")
	@GetMapping(value = "/delete")
	public ResponseData delete(String ids){
		boolean flag = userService.removeByIds(Arrays.asList(ids.split(",")));
		if(flag){
			return success(ids);
		}else{
			return failed("删除失败");
		}
	}
}
