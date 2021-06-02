package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//해당 Action이 수행 한 후에 어떤 jsp파일로 가야할지 파일 이름을 반환
public interface CRUDAction {

	public String conn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
