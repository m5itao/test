package com.loongsoft.base.user.action;

import com.loongsoft.base.form.User;
import com.loongsoft.base.user.service.IUserService;
import com.loongsoft.base.util.Util;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 增加用户
 * @author F
 *
 */
public class AddUserAction extends ActionSupport {
	
	private IUserService service;

	private String name;
	
	private String age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setId(Util.getUUID());
		user.setName(name);
		user.setAge(age);
		service.add(user);
		
		return this.SUCCESS;
	}
	
	
}
