package com.witcxc.io.utils.test;

import java.util.Date;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date());
		System.out.println(new Date(System.currentTimeMillis()+10000));
		System.out.println(new Date((System.currentTimeMillis()/10000)*10000));
	}

}
