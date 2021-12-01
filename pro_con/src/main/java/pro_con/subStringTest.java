package pro_con;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subStringTest {

	public static void main(String[] args) {
		String full_name = "/C:/dev/workspace/oacx/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/oa-cx-server/WEB-INF/lib/validation-api-1.1.0.Final.jar";
		String staticPath=null;
		String file_name = null;
		
		int idx1 = full_name.indexOf("lib/")+4;
		staticPath = full_name.substring(0,idx1);
		file_name = full_name.substring(idx1);
		
		System.out.println("파일경로: "+staticPath);
		System.out.println("파일이름: "+file_name);
		System.out.println("===========================================");
		String R_staticPath=null;
		String R_file_name = null;
		try{
			//필요 로드 라이브러리
			//Set<String> R_jar = new HashSet<String>();
			//Set<String> R_cls = new HashSet<String>();
			List<String> R_jar = new ArrayList<String>();
			List<String> R_cls = new ArrayList<String>();
			
		    //파일 객체 생성
		    File file = new File("D:\\test\\classpath.txt");
		    //입력 스트림 생성
		    FileReader filereader = new FileReader(file);
		    //입력 버퍼 생성 -> 문자 압축을 위해 (cpu 부하방지)
		    BufferedReader buf = new BufferedReader(filereader);
		    String line = "";
		    while ((line = buf.readLine()) != null){
		    	//경로 나누기
		    	if(line.endsWith(".jar")) {
		    		int idx = line.indexOf("lib/")+4;
		    		R_staticPath = line.substring(0,idx);
		    		R_file_name = line.substring(idx);
		    		R_jar.add(R_file_name);
				}else{
					int idx = line.indexOf("WEB-INF/")+8;
		    		R_staticPath = line.substring(0,idx);
		    		R_file_name = line.substring(idx);
					R_cls.add(R_file_name);
				}
		    }
		    
		    for (int jjj=0; jjj<R_jar.size(); jjj++) {
		    	System.out.println("jar파일: " + R_jar.get(jjj));
		    }
		    for (int ccc=0; ccc<R_cls.size(); ccc++) {
		    	System.out.println("cls파일: " + R_cls.get(ccc));
		    }
		    System.out.println("파일경로: "+R_staticPath);
		    buf.close();
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage()+"파일을 읽을 수 없음.");
		}catch(IOException e){
		    System.out.println(e);
		}
	}
}
