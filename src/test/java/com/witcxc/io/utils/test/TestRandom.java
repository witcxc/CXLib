package com.witcxc.io.utils.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> randomResult = new HashMap<Integer,Integer>();
		Random rand  = new Random(47);
		int temp = 0;
		for(int i=0;i<1000000000;i++){
			temp = rand.nextInt(1000);
			if(randomResult.containsKey(temp))
				randomResult.put(temp, randomResult.get(temp)+1);
			else
				randomResult.put(temp, 1);
		}
		System.out.println(randomResult);
		
	}

}
