package membership;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JSFunction;
@WebServlet("/login.do")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		
		
		MemberDTO dto = dao.userLogin(user_id, user_pw);
		
		dao.close();
		
		if (dto.getUser_id().equals(null)) {
			JSFunction.alertBack(resp, "id 또는 비밀번호가 잘못되었습니다.");
		}else {		
			HttpSession session = req.getSession();
			session.setAttribute("user_info", dto);
			
			JSFunction.alertLocation(resp, dto.getUser_name()+"님 환영합니다!", "index.do?Start=1");
		}
	}
}
