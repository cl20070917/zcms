package com.zhijia.zcms;

public class Father {
	int i;
	
	public Father() {
		// TODO Auto-generated constructor stub
		add(1);
		System.out.println(i);
	}
	void add(int v){
		i+=v;
		System.out.println(i);
	}
}
