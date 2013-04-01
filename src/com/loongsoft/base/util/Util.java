package com.loongsoft.base.util;

import java.util.UUID;

public class Util{
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	

	public void testOne() {
		System.out.println(Util.getUUID());
	}
	
}
