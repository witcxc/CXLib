package com.chenxi.type.test;

import static com.witcxc.io.utils.Print.*;

class ClassAsFactory<T> {
	T x;

	public ClassAsFactory(Class<T> kind) {
		try {
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

class Employee {
	// public Employee(int i) {
	//
	// }
}

public class InstantiatieGenericType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassAsFactory<Employee> cf = new ClassAsFactory<Employee>(
				Employee.class);
		print("create employ succeeded!");
		try {
			ClassAsFactory<Integer> cfi = new ClassAsFactory<Integer>(
					Integer.class);
		} catch (Exception e) {
			print("create integer failed" + e);
		}
		Integer i = new Integer(1);
		print(i);
	}

}
