package com.shop.ncp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.frame.WUtil;

@SpringBootTest
class WUtilTest {

	@Test
	void contextLoads() throws Exception {
		org.json.JSONObject obj = (JSONObject) WUtil.getData("109");
		System.out.println(obj.toString());
	}
}




