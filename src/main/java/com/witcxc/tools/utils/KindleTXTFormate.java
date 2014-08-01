package com.witcxc.tools.utils;

import java.io.IOException;

import com.witcxc.io.utils.FileUtils;
import com.witcxc.io.utils.StringUtils;

public class KindleTXTFormate {
	/**
	 * [\n , , , ", #, %, &, ', (, ), *, +, ,, -, ., /, 0, 1, 2, 3, 4, 5, 6, 7,
	 * 8, 9, :, ;, <, =, >, ?, @, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O,
	 * P, Q, R, S, T, U, V, W, X, Y, Z, [, ], ^, _, a, b, c, d, e, f, g, h, i,
	 * j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, {, |, }] ²ð½âºó \n
	 * 
	 * ,"#%&'()*+-./0123456789:;<=>?@[]^_abcdefghijklmnopqrstuvwxyz{|}]I
	 * 
	 * ABCDEFGHJKLMNOPQRSTUVWXYZ
	 */
	public static String singleChars = ",\"#%&'()*+-./0123456789:;<=>?@[]^_abcdefghijklmnopqrstuvwxyz{|}]I";
	public static String doubleChars = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
	public static String newLine = "\n\r\n";
	public static int lineLength = 57;
	public static String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	public static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String alphabet = lowerCase + upperCase;

	public static int calWordLength(String word) {
		if (word.trim().length() != word.length())
			return -1;
		int len = 0;
		for (Character c : word.toCharArray()) {
			if (lowerCase.contains(c.toString()))
				len++;
			else if (upperCase.contains(c.toString())) {
				len += 2;
			}
		}
		return len;
	}

	public static boolean notOver(int index, String content) {
		String w;
		while ((w = getElement(index, content)) != null) {
			index += w.length();
			if (alphabet.contains(((Character) w.charAt(0)).toString())) {
				if (w.charAt(0) >= 'a' && w.charAt(0) <= 'z')
					return true;
				else
					return false;
			}

		}
		return false;
	}

	public static String getElement(int index, String content) {
		if (index >= content.length())
			return null;
		StringBuilder sb = new StringBuilder();
		Character c = content.charAt(index);
		if (alphabet.contains(c.toString())) {
			sb.append(c);
			int i = index;
			while (++i < content.length()
					&& alphabet.contains((c = content.charAt(i)).toString())) {
				sb.append(c);
			}

		} else {
			return c.toString();
		}
		return sb.toString();
	}

	public static String convertToKindleWithWord(String content) {
		StringBuilder sb = new StringBuilder();
		int index = 0, lineIndex = 0;
		while (index < content.length()) {
			String el = getElement(index, content);
			index += el.length();
			int elLength = calWordLength(el);
			if (elLength == -1) {
				elLength = el.length();
			}
			if (newLine.contains(el)) {
				if (notOver(index, content)) {
					if (lineIndex + elLength > lineLength) {
						sb.append("\n");
						lineIndex = 0;
					} else {
						sb.append(" ");
						lineIndex++;
					}
				} else {
					lineIndex = 0;
					sb.append("\n");
				}

				continue;
			}
			if (lineIndex + elLength > lineLength) {

				sb.append("\n" + el);
				lineIndex = 0;
			} else {
				lineIndex += elLength;
				sb.append(el);
			}
		}
		return sb.toString();
	}

	public static String convertToKindle(String content) {
		StringBuilder sb = new StringBuilder();
		int newLineIndex = 0;
		for (int i = 0; i < content.length(); i++) {
			Character c = content.charAt(i);
			if (!newLine.contains(c.toString())) {
				if (++newLineIndex >= lineLength) {
					sb.append("\n" + c);
					newLineIndex = 0;
				} else {
					sb.append(c);
					if (doubleChars.contains(c.toString()))
						newLineIndex++;
				}
			} else {
				int j = i;

				while (++j < content.length()) {
					if (alphabet.contains(((Character) content.charAt(j))
							.toString()))
						break;
				}
				if (j < content.length()
						&& upperCase.contains(((Character) content.charAt(j))
								.toString())) {
					sb.append("\n");
					newLineIndex = 0;
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String content = FileUtils
				.read("C:\\Users\\chenxi\\Desktop\\rfc6749.txt");
		String formateContent = convertToKindleWithWord(content);
		System.out.println(formateContent);
		// System.out.println(StringUtils.charInString(content));
		// System.out.println(content);
		// FileUtils.write("C:\\Users\\chenxi\\Desktop\\txt.txt", content,
		// true);
	}

}
