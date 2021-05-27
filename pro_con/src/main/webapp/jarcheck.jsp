<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*, java.text.*"%>
<%
    String reqName = null;
	String jersey = "org.glassfish.jersey.server.ServerProperties";
	String mybatis = "org.apache.ibatis.executor.BaseExecutor";
	String gson = "com.google.gson.Gson";
	String jaxrs = "javax.ws.rs.core.Application";
	String httpclient = "org.apache.http.client.HttpClient";
	
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat format2 = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
			
	Date time = new Date();
			
	String time1 = format1.format(time);
	String time2 = format2.format(time);

%>
<html>
전자서명 중계모듈 사전점검 페이지
<br><hr align=center><br>
라이브러리 점검 - <%= time1 %>
<br>
<br/>
[Check]...<br/>
<br/>
1) Jersey 프레임워크 : <%= Test(jersey) %><br/>
2) mybatis 프레임워크 : <%= Test(mybatis) %><br/>
3) GSON 프레임워크 : <%= Test(gson) %><br/>
4) JAX-RS 프레임워크 : <%= Test(jaxrs) %><br/>
5) httpClient : <%= Test(httpclient) %><br/>
<br>
<%!
   String Test(String reqName) {
	java.net.URL classUrl = null;
	StringBuilder sb = new StringBuilder();
	
 	reqName = reqName.replace('.', '/').trim();
	reqName = "/" + reqName + ".class";
        classUrl = this.getClass().getResource(reqName);
        if (classUrl == null) {
            sb.append(reqName + " not found");
        } else {
            sb.append("<b>" + reqName + "</b>: [" + classUrl.getFile() + "]\n" );
        }
        sb.append("<br>");
	return sb.toString();

    }
%>
