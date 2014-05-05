package com.chenxi.type.test;

import static com.witcxc.io.utils.Print.*;

abstract class GenericWithCreate<T> {
	final T element;

	GenericWithCreate() {
		element = create();
	}

	abstract T create();
}

class X {
}

class Creator extends GenericWithCreate<X> {
	X create() {
		return new X();
	}

	void f(){
		print(element.getClass().getSimpleName());
	}
}

public class CreatorGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator  c = new Creator();
		c.f();
	}

}
