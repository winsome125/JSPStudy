package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 web.xml에 매핑을 하는대신 @WebServlet 어노테이션을 사용하여 요청명에 대한 매핑을 한다.
 편한 방식이지만 차후 유지보수를 위해서는 요청명과 서블릿 클래스의 관계를 명확히 해둔 상태에서 사용해야한다.
 */
@WebServlet("/12Servlet/AnnoMapping.do")
public class AnnoMapping extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 리퀘스트 영역에 속성을 저장한 후 JSP로 포워드한다.
		req.setAttribute("massage", "@WebServlet으로 매핑");
		req.getRequestDispatcher("/12Servlet/AnnoMapping.jsp").forward(req, resp);
	}
}
