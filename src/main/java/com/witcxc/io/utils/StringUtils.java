package com.witcxc.io.utils;

import java.util.Set;
import java.util.TreeSet;

public class StringUtils {

	public static Set<Character> charInString(String s) {
		Set<Character> cs = new TreeSet<Character>();
		for (char c : s.toCharArray()) {
			cs.add(c);
		}
		return cs;
	}

}
