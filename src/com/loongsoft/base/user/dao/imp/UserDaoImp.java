package com.loongsoft.base.user.dao.imp;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.loongsoft.base.form.User;
import com.loongsoft.base.user.dao.IUserDao;

public class UserDaoImp extends HibernateDaoSupport implements IUserDao {

	public void add(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(user);
	}

}
