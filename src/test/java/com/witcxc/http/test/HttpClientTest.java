package com.witcxc.http.test;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.witcxc.tools.utils.MD5Util;

public class HttpClientTest {

	public static void testGet() throws ClientProtocolException, IOException {

		HttpClient hc = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		CloseableHttpResponse response1 = (CloseableHttpResponse) hc
				.execute(httpGet);
		try {
			System.out.println(response1.getStatusLine());
			HttpEntity entity1 = response1.getEntity();
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity1);
		} finally {
			((Closeable) response1).close();
		}
	}

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		// TODO Auto-generated method stub

		String userid = "90C518FAE7BA3F3F9ABE3F220FB16984@qq.sohu.com";
		String appid = "";
		String appkey = "";
		String ct = Long.toString(System.currentTimeMillis() / 1000);
		String code = MD5Util.md5(userid + appid + appkey + ct);
		String openid = "90C518FAE7BA3F3F9ABE3F220FB16984@qq.sohu.com";
		String use = "";
		HttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(
				"http://internal.passport.sohu.com/openlogin/api/token/expiresin");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("userid", userid));
		nvps.add(new BasicNameValuePair("appid", "secret"));
		nvps.add(new BasicNameValuePair("ct", ct));
		nvps.add(new BasicNameValuePair("code", "secret"));
		nvps.add(new BasicNameValuePair("openid", openid));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = (CloseableHttpResponse) httpclient
				.execute(httpPost);

		try {
			System.out.println(response2.getStatusLine());
			HttpEntity entity2 = response2.getEntity();
			System.out.println(EntityUtils.toString(entity2));
			// do something useful with the response body
			// and ensure it is fully consumed
			EntityUtils.consume(entity2);
		} finally {
			response2.close();
		}
	}

}
