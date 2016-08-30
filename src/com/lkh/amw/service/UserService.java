/**
 *=========================================================
 * project:amw
 * package:com.lkh.amw.service
 * class:UserService.java
 *=========================================================
 * @author:lkh
 * @since:JDK1.7
 * @version:1.0
 *=========================================================
 * create time:2016年8月18日-下午9:05:35
 */
package com.lkh.amw.service;

import com.lkh.amw.pojo.User;

/**
 * @author lkh
 * @createTime 2016年8月18日 下午9:05:35
 */
public interface UserService {
	/**
	 * select Login by user name
	 * @param username
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:05:50
	 */
	public User selectLogin(String username);
	/**
	 * Get user by Id
	 * @param i
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:06:07
	 */
	public User getUserById(int i);
	/**
	 * selected By Primary Key
	 * @param i
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:06:24
	 */
	public User selectByPrimaryKey(int i);
	/**
	 * Get User by user name
	 * @param username
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:06:44
	 */
	public User getUserByusername(String username);
	/**
	 * insert User to DB
	 * @param user
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:06:57
	 */
	public int createUser(User user);
	/**
	 * get Login User
	 * @param user
	 * @return
	 * @author lkh
	 * @createTime 2016年8月18日 下午9:07:15
	 */
	public Boolean getLoginUser(User user);
}
