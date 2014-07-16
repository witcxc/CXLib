package com.witcxc.io.utils.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestFileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Set<String> setAll = new HashSet<String>();
		long s = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\Users\\chenxi\\Desktop\\a\\xaa"));
		String data = br.readLine();// 一次读入一行，直到读入null为文件结束
		long count = 0;
		while (data != null) {
			count++;
			data = br.readLine(); // 接着读下一行
			setAll.add(data);
		}
		br.close();
		System.out.println("count =" + count + " uniq size=" + setAll.size()
				+ " use time:" + (System.currentTimeMillis() - s));
		FileWriter fw = new FileWriter("D:\\pp.txt");// 创建FileWriter对象，用来写入字符流
		BufferedWriter bw = new BufferedWriter(fw);
		count = 0;
		for (String tmp : setAll) {
			// System.out.println(tmp);
			if (tmp == null) {
				System.out.println("null");
				continue;
			}
			bw.write(tmp);
			bw.newLine();
			count++;
		}
		bw.flush();
		bw.close();
		System.out.println("write count=" + count);
	}

}
