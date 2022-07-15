package board;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/view.do")
public class PostViewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		
		BoardDAO Contentdao = new BoardDAO();
		
		BoardDTO Contentdto = Contentdao.ContentRetrun(idx);
		
		CommentDAO Commentdao = new CommentDAO();
		
		List<CommentDTO> commentList = Commentdao.queryComment(idx);
		
		SubCommentDAO subCommentdao = new SubCommentDAO();
		
		
		Map<String, List<SubCommentDTO>> subCommentMap = subCommentdao.queryComment(idx);
		
		//로그인 구현후 삭제해주자
		HttpSession session = req.getSession();
		session.setAttribute("user_id", "임의값");
		
		Contentdao.close();
		subCommentdao.close();
		
		req.setAttribute("Contentdto", Contentdto);
		
		req.setAttribute("commentList", commentList);
		
		req.setAttribute("subCommentMap", subCommentMap);
		
		
		req.getRequestDispatcher("/Pages/view.jsp").forward(req, resp);
	}
}
