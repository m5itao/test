package com.loongsoft.base.user.service.imp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.loongsoft.base.form.User;
import com.loongsoft.base.user.dao.IUserDao;
import com.loongsoft.base.user.service.IUserService;

public class UserServiceImp implements IUserService {

	private IUserDao dao;
	
	private static Log log = LogFactory.getLog(UserServiceImp.class);
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		dao.add(user);
		log.info(user);
	}
	
}
