<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"   pageEncoding="EUC-KR"%>



<%!

	public String call_oacx(String url){
		URL oacx_url = null;
		int res_code = -1;
		StringBuffer buffer = new StringBuffer();
		try{
			oacx_url = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)oacx_url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.connect();
			
			res_code = connection.getResponseCode();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while( (line = reader.readLine()) != null){
				buffer.append(line);
			}
			reader.close();
			
			
		}catch (Exception e){
			e.printStackTrace();			
		}finally{
			System.out.println("call url : "+ oacx_url +  " ("+ res_code +")) ");				
		}
		return buffer.toString();
	}
	
%>
<%
	out.write(call_oacx("https://k-pki.kakao.com/api/v1/sign/request"));
%>