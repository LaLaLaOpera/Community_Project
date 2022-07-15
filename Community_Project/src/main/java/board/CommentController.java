package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.JSFunction;

@WebServlet("/commentProcess.do")
public class CommentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String writer = req.getParameter("writer");
		String boardidx = req.getParameter("contentidx");
		String content = req.getParameter("content");
		
		CommentDTO dto = new CommentDTO();
		dto.setBoardidx(boardidx);
		dto.setWriter(writer);
		dto.setContent(content);
		CommentDAO dao = new CommentDAO();
		
		String idx = "1";
		try {
			idx = String.valueOf(Integer.parseInt(dao.maxIdx(boardidx))+1);
		}catch(Exception e) {
			System.out.println("게시물의 첫댓글");
		}
		
		dto.setIdx(idx);
		
		int result = dao.insertComment(dto);
		
		dao.close();
		
		if(result == 1) {
			JSFunction.alertBack(resp, "댓글 등록이 완료되었습니다.");
		}else {
			JSFunction.alertBack(resp, "댓글 등록에 실패했습니다.");
		}
	}
}
