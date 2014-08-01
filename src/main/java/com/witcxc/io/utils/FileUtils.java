package com.witcxc.io.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

	public static String read(String fileNmae) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileNmae));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		return sb.toString();
	}

	public static void write(String fileName, String content, boolean append)
			throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append));
		if (content != null) {
			bw.write(content);
		}
		bw.flush();
		bw.close();
	}
}
