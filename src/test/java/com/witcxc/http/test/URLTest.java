package com.witcxc.http.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLTest {

	public static boolean isUrl(String url) {

		// try {
		// URL urll = new URL(url);
		// System.out.println("url 正确");
		// } catch (MalformedURLException e) {
		// System.out.println("url 不可用");
		// }

		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		Pattern patt = Pattern.compile(regex);

		Matcher matcher = patt.matcher(url);
		boolean isMatch = matcher.matches();
		if (!isMatch) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String url = "http://i.sohu.com/home.htm\"><script>alert(0)</script>";
		// url = "http://www.www.com";
		System.out.println(isUrl(url));
		url = "http://passport.sohu.com/openlogin/callback/feixin";
		System.out.println(URLEncoder.encode(url, "utf-8"));
	}

}
