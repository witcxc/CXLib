package com.witcxc.io.utils.test;

import java.util.Arrays;

public class TestUtil {

	static class A {
		int value = 0;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public A() {

		}

		public A(int v) {
			value = v;
		}

		public String toString() {
			return Integer.toString(value);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A[] arrays = new A[10];
		Arrays.fill(arrays, new A());
		System.out.println(Arrays.toString(arrays));
		arrays[1].setValue(2);
		System.out.println(Arrays.toString(arrays));
	}

}
