/**
 *=========================================================
 * project:amw
 * package:com.lkh.amw.service.impl
 * class:UserServiceImpl.java
 *=========================================================
 * @author:lkh
 * @since:JDK1.7
 * @version:1.0
 *=========================================================
 * create time:2016年8月18日-下午8:54:16
 */
package com.lkh.amw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lkh.amw.IDao.UserMapper;
import com.lkh.amw.pojo.User;
import com.lkh.amw.service.UserService;

/**
 * @author lkh
 * @createTime 2016年8月18日 下午8:54:16
 */
@Service("userServiceImpl")  
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userDao;

	/* (non-Javadoc)
	 * @see com.lkh.amw.service.UserService#selectLogin(java.lang.String)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public User selectLogin(String username) {
		return this.userDao.selectLogin(username);
	}

	/* get User by Id
	 * @see com.lkh.amw.service.UserService#getUserById(int)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public User getUserById(int id) {
		return this.userDao.selectId(id);
	}

	/* (non-Javadoc)
	 * @see com.lkh.amw.service.UserService#selectByPrimaryKey(int)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public User selectByPrimaryKey(int i) {
		return this.userDao.selectByPrimaryKey(i);
	}

	/* (non-Javadoc)
	 * @see com.lkh.amw.service.UserService#getUserByusername(java.lang.String)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public User getUserByusername(String username) {
		return this.userDao.selectLogin(username);
	}

	/* (non-Javadoc)
	 * @see com.lkh.amw.service.UserService#inster(com.lkh.amw.pojo.User)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public int createUser(User user){
		try{
			return this.userDao.insertSelective(user);
		}catch(DataIntegrityViolationException e){
			System.out.println("=================="+e.getMessage());
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.lkh.amw.service.UserService#getLoginUser(com.lkh.amw.pojo.User)
	 * @author lkh
	 * @createTime 2016年8月18日 下午8:54:16
	 */
	@Override
	public Boolean getLoginUser(User userLogin) {
		if (userLogin.getUserName().equals("")
				|| (userLogin.getPassWord().equals(""))) {
			return false;
		} else {
			User user = new User();
			if (this.userDao.selectLogin(userLogin.getUserName()) != null) {
				user = userDao.selectLogin(userLogin.getUserName());
				if (user.toString().isEmpty()) {
					return false;
				} else {
					if (user.getPassWord().equals(userLogin.getPassWord())) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
	}

}
