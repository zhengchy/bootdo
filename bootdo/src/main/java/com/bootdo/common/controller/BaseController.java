package com.bootdo.common.controller;

import com.bootdo.system.domain.UserToken;
import org.springframework.stereotype.Controller;
import com.bootdo.common.utils.ShiroUtils;
import com.bootdo.system.domain.UserDO;

import java.util.Date;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}


	protected Date nowDate(){
		return  new Date();
	}

}