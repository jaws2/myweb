package com.myweb.service;

import java.util.List;

import com.myweb.domain.ViewUser;

public interface UserService {
	/**
	 * 获取已经注册的所有用户信息
	 * @return
	 * List<ViewUser>
	 */
	public List<ViewUser> getAllRegisteredUser();
}
