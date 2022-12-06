package com.shop.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KaKaoTests {
	
	@Test
	void contextLoads() throws Exception {
		String address = "https://dapi.kakao.com/v2/local/search/keyword.JSON";
		
        String param = "query=" + "이마트"
        		+ "&category_group_code=" + "MT1"
                + "&x=" + "37.5606326"
                + "&y=" + "126.9433486"
                + "&radius=" + "1000";
		
		
//		String address = "https://dapi.kakao.com/v2/local/search/category.JSON";
//		
//        String param = //"query=" + "대형마트"
//                "category_group_code=" + "AC5"
//                + "&x=" + "37.5606326"
//                + "&y=" + "126.9433486"
//                + "&radius=" + "1000";
                
        String apiKey = "b5767e54165aa53157861e380d8aaa6b";	//발급받은 restapi key
		
		
		
		URL url = new URL(address);  			//접속할 url 설정
		HttpURLConnection conn;					//httpURLConnection 객체
		conn = (HttpURLConnection) url.openConnection();	//접속할 url과 네트워크 커넥션을 연다.
		conn.setRequestMethod("POST");             
		conn.setDoOutput(true);
        conn.setUseCaches(false);
		conn.setRequestProperty("Authorization", "KakaoAK " + apiKey);	//Property 설정

		OutputStreamWriter ds = new OutputStreamWriter(conn.getOutputStream());
		ds.write(param);
		ds.flush();
		ds.close();
		
		
		int responseCode = conn.getResponseCode();		//responseCode를 받아옴.
	
		InputStream inputStream = conn.getInputStream();	//데이터를 받아오기 위한 inputStream
		BufferedReader br;		//inputStream으로 들어오는 데이터를 읽기 위한 reader
		String json = null;
		Charset charset = Charset.forName("UTF-8");
		if(responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(inputStream,charset));
			json = br.readLine();
			br.close();
		}
		else {
			System.out.println(" ERROR !!! ");
		}
	
		inputStream.close();
		conn.disconnect();
		System.out.println(json);
	
		}

}
