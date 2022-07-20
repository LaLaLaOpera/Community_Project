package membership;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.JSFunction;

@WebServlet("/signUp.do")
public class SignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user_id = req.getParameter("user_id");
		String password = req.getParameter("password");
		String user_email = req.getParameter("user_email");
		String user_name = req.getParameter("user_name");
		
		MemberDTO dto = new MemberDTO();
		
		dto.setUser_id(user_id);
		dto.setUser_pw(password);
		dto.setUser_email(user_email);
		dto.setUser_name(user_name);
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.RegisterUser(dto);
		dao.close();
		if (result == 1) {
			JSFunction.alertLocation(resp, "회원가입이 완료되었습니다. 로그인해주세요", "index.do?Start=1");
		}else {

			JSFunction.alertBack(resp, "회원가입에 실패했습니다.");
		}
	}
	
}
