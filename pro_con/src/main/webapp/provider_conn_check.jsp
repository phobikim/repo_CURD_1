<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*, java.text.*"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%
	String kakao = "https://k-pki.kakao.com/api/v1/sign/request";
	String pass = "https://pub-api.passauth.co.kr/certification/notice/common";
	String payco = "https://ca.payco.com/mois/v1/signs/sign.request";
	String samsungpass = "https://ses.signgate.com/ses/sign/v1/request";
	String kb = "https://openapi.kbstar.com:8443/caq/kbsign/api/sign_request";
	
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	Date time = new Date();
	String time1 = format1.format(time);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
인증사업자(운영) request url 연결 여부 테스트 - <%=time1 %>
<br><hr align=center><br>
<br>
<br/>
[Check]...<br/>
<br/>
1) 카카오 : <%= Test(kakao) %><br/>
2) PASS : <%= Test(pass) %><br/>
3) 페이코 : <%= Test(payco) %><br/>
4) 삼성PASS : <%= Test(samsungpass) %><br/>
5) KB : <%= Test(kb) %><br/>

<%!
	String Test(String url) {
		URL provicer_url = null;
		int response_code = -1;
		StringBuffer buffer = new StringBuffer();
		String result = null;
		try{
			provicer_url = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)provicer_url.openConnection();
			
			//3초 기다린 후 응답 없으면 커넥션 종료
			connection.setConnectTimeout(3000);
			//connection.setReadTimeout(3000);
			connection.setRequestMethod("POST");
			connection.connect();
			
			response_code = connection.getResponseCode();
			result = response_code+"";
		}catch (Exception e){
			e.printStackTrace();
			if(response_code == -1){
				result = e.getMessage();
			}
		}finally{
			System.out.println("call url : " + provicer_url + "("+ response_code+")");
		}
		return result;
	}
%>


</body>
</html>