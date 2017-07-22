package com.zhijia.zcms;

public class Child extends Father{
	public Child() {
		// TODO Auto-generated constructor stub
		add(2);
	}

	@Override
	void add(int v) {
		// TODO Auto-generated method stub
		i += v*2;
	}
}
