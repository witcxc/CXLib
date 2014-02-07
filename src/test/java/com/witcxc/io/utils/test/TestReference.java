package com.witcxc.io.utils.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestReference {

	static class Person{
		String name;
		int age;
		byte sex;
		public Person(String name,int age,byte sex){
			this.age = age;
			this.sex = sex;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public byte getSex() {
			return sex;
		}
		public void setSex(byte sex) {
			this.sex = sex;
		}
		public String toString(){
			return "name="+name+",age="+age+",sex="+sex;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person1 = new Person("cx1",10,(byte)1);
		Person person2 = new Person("cx2",10,(byte)1);
		Person person3 = new Person("cx3",10,(byte)1);
		List<Person> listPerson = Arrays.asList(person1,person2,person3);
		System.out.println(listPerson);
		person1.setName("Witcxc");
		System.out.println(listPerson);
		
	}

}
