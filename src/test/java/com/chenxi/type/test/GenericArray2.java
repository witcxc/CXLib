package com.chenxi.type.test;

public class GenericArray2<T> {

	private T[] array;

	public GenericArray2(int sz) {
		array = (T[]) new Object[sz];
	}

	public void put(int index, T item) {
		array[index] = item;
	}

	public T get(int index) {
		return (T)array[index];
	}

	public T[] rep() {
		return (T[])array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
		gai.put(1, 11);
//		 Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
		System.out.println(gai.get(1));
	}

}
