package com.witcxc.algo.set;

import java.util.HashSet;
import java.util.Set;

public class GenerateCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final Set<String> a = new HashSet<String>() {
			{
				add("a1");
				add("a2");
			}
		};
		final Set<String> b = new HashSet<String>() {
			{
				add("b1");
				add("b2");
				add("b3");
				add("b4");
			}
		};
		final Set<String> c = new HashSet<String>() {
			{
				add("c1");
				add("c2");
				add("c3");
			}
		};

		Set<Set<String>> all = new HashSet<Set<String>>() {
			{
				add(a);
				add(b);
				add(c);
			}
		};
		int count = 0;
		for (Set<String> tmp : all) {
			for (Set<String> tmp2 : all) {
				if (!tmp2.equals(tmp))
					for (Set<String> tmp3 : all) {
						if (!(tmp3.equals(tmp2) || tmp3.equals(tmp))) {
							for(String tmpa:tmp){
								for(String tmpb:tmp2){
									for(String tmpc:tmp3){
										System.out.println((++count)+".<"+tmpa+", "+tmpb+", "+tmpc+">");
									}
								}
							}
						}
					}
			}
		}
	}

}
