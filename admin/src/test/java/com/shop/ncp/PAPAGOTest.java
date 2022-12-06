package com.shop.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PAPAGOTest {

	@Test
	void contextLoads() {
		String clientId = "bdxi87si52";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "JMqFuQGTtJyPXJsbXjM9waZJV4PkIdZtvrabIcPc";//애플리케이션 클라이언트 시크릿값";
	      try {
	            String text = URLEncoder.encode("만나서 반갑습니다.", "UTF-8");
	            String apiURL = "https://x52m8zb28c.apigw.ntruss.com/custom/v1/8223/18b143c9a91a486724bd1c3190b0543f23234a62611c7985c9055b1385794b1a";
	            URL url = new URL(apiURL);
	            HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            con.setRequestMethod("POST");
	            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
	            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
	            // post request
	            String postParams = "source=ko&target=en&text=" + text;
	            con.setDoOutput(true);
	            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	            wr.writeBytes(postParams);
	            wr.flush();
	            wr.close();
	            int responseCode = con.getResponseCode();
	            BufferedReader br;
	            if(responseCode==200) { // 정상 호출
	                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            } else {  // 오류 발생
	                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	            }
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	            while ((inputLine = br.readLine()) != null) {
	                response.append(inputLine);
	            }
	            br.close();
	            System.out.println(response.toString());
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	}	
}
