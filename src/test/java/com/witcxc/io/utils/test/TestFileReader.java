package com.witcxc.io.utils.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestFileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String,Integer> mp = new HashMap<String,Integer>();
		BufferedReader br = new BufferedReader(new FileReader("/home/witcxc/tmp/result.txt")); 
		String data = br.readLine();//一次读入一行，直到读入null为文件结束
		long count = 0;
		while( data!=null){  
			  count++;
		      data = br.readLine(); //接着读下一行  
		      mp.put(data, 1);
		}
		br.close();
		System.out.println("count ="+count+" uniq size="+mp.size());
		FileWriter fw = new FileWriter("/home/witcxc/tmp/txt.txt");//创建FileWriter对象，用来写入字符流
        BufferedWriter bw = new BufferedWriter(fw);
        count = 0;
		for(String tmp:mp.keySet()){
//			System.out.println(tmp);
			if(tmp==null)
			{
				System.out.println("null");
				continue;
			}
			bw.write(tmp);
			bw.newLine();
			count++;
		}
		bw.flush();
		bw.close();
		System.out.println("write count="+count);
	}

}
