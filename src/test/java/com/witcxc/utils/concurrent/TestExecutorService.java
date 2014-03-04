package com.witcxc.utils.concurrent;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutorService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for (final int i:Arrays.asList(1,2,3)) {
			executor.submit(new Runnable() {
				public void run() {
//					while(true)
					System.out.println(i);
				}
			});
		}
	}

}
