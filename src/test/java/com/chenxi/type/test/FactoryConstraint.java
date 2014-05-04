package com.chenxi.type.test;
import static com.witcxc.io.utils.Print.*;
interface FactoryI<T>{
	T create();
}
class Foo2<T>{
	private T x;
	public <F extends FactoryI<T>> Foo2(F factory){
		x  = factory.create();
	}
	public String toString(){
			return x.toString();
	}
}
class IntegerFactory implements FactoryI<Integer>{
	public Integer create(){
		return new Integer(0);
	}
}
class Widget{
	public static class Factory implements FactoryI<Widget>{
		public Widget create(){
			return new Widget();
		}
	}
//	public String toString(){
//		return "Widget";
//	}
}
public class FactoryConstraint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo2<Integer> fi = new Foo2(new IntegerFactory());
		Foo2<Widget> fw = new Foo2(new Widget.Factory());
		print(fi);
		print(fw);
	}

}
