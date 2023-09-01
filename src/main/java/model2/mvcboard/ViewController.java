package model2.mvcboard;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 내용보기의 매핑은 web.xml이 아닌 어노테이션을 통해 설정한다.
 */
@WebServlet("/mvcboard/view.do")
public class ViewController extends HttpServlet {
	
	/*
	 서블릿의 수병주기 메서드 중 전송방식에 상관없이 요청을 처리하고 싶을때는 service()메서드를 오버라이딩 하면된다.
	 해당 메서드의 역할은 요청을 분석한 후 doGet() 혹은 doPost()를 호출하는 것이다.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 게시물 불러오기
		MVCBoardDAO dao = new MVCBoardDAO();
		// 파라미터로 전달 된 일련번호를 받는다.
		String idx = req.getParameter("idx");
		// 조회수 1 증가
		dao.updateVisitCount(idx); 
		// 게시물을 인출한다.
		MVCBoardDTO dto = dao.selectView(idx);
		dao.close();
		
		/*
		 내용의 경우 Enter를 통해 줄바꿈을 하게 되므로 웹브라우저 출력시 <br>로 변경해야 한다.
		 */
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		// 첨부파일 확장자 추출 및 이미지 타입 확인
		String ext = null, fileName = dto.getSfile();
		if(fileName!=null) {
			ext = fileName.substring(fileName.lastIndexOf(".")+1);
		}
		String[] mimeStr = {"png", "jpg", "gif"};
		List<String> mimeList = Arrays.asList(mimeStr);
		boolean isImage = false;
		if(mimeList.contains(ext)) {
			isImage = true;
		}
		
		// 게시물(dto)을 request영역에 저장한 후 뷰로 포워드한다.
		req.setAttribute("dto", dto);
		req.setAttribute("isImage", isImage);
		req.getRequestDispatcher("/14MVCBoard/View.jsp").forward(req, resp);
	}
}
