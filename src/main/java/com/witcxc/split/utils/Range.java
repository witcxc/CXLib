package com.witcxc.split.utils;

public class Range {

	public static int[] range(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}

	public static int[] range(int start, int end) {
		int[] result = new int[end - start];
		for (int i = 0; i < end - start; i++) {
			result[i] = i + start;
		}
		return result;
	}

	public static int[] range(int start, int end, int step) {
		int sz = (end - start) / step;
		int[] result = new int[sz];
		for (int i = 0; i < sz; i++)
			result[i] = start + i * step;
		return result;
	}
}