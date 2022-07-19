package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import common.JSFunction;

@WebServlet("/subProcess.do")
public class SubCommentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String writer = req.getParameter("writer");
		String contentidx = req.getParameter("contentidx");
		String content = req.getParameter("content");
		String commentidx = req.getParameter("commentidx");
		SubCommentDTO dto = new SubCommentDTO();
		try {
			dto.setMention(req.getParameter("mention"));
		}catch(Exception e) {}
		dto.setBoardidx(contentidx);
		dto.setWriter(writer);
		dto.setContent(content);
		dto.setCommentidx(commentidx);
		SubCommentDAO dao = new SubCommentDAO();
				
		int result = dao.insertComment(dto);
		dao.close();
		if(result == 1) {
			JSFunction.alertBack(resp, "댓글 등록이 완료되었습니다.");
		}else {
			JSFunction.alertBack(resp, "댓글 등록에 실패했습니다.");
		}
	}
	
}
