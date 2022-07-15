package board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/index.do")
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String start = req.getParameter("Start");
		
		BoardDAO dao = new BoardDAO();
		
		List<BoardDTO> boardLists =  dao.listboard(start);
		
		dao.close();
		
		req.setAttribute("boardLists", boardLists);
		
		req.getRequestDispatcher("./Pages/index.jsp").forward(req, resp);
	}
}
