package com.chenxi.type.test;

public class GenericArray<T> {

	private T[] array;

	public GenericArray(int sz) {
		array = (T[]) new Object[sz];
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return array[index];
	}

	public T[] rep() {
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
		Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
	}

}
