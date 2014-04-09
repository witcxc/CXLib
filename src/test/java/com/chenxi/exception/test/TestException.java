package com.chenxi.exception.test;

import java.io.FileNotFoundException;

public class TestException {

	static void f(){
		System.out.println("in f()");
		try {
			throw new FileNotFoundException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f();
	}

}
