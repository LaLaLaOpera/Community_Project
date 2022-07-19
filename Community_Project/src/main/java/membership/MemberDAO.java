package membership;

import common.DBConnPool;

public class MemberDAO extends DBConnPool{
	public int RegisterUser(MemberDTO dto) {
		int result = 0;
		
		String query = "Insert into membership values"
				+ " (?, NEXT_USER_SEQ.NEXTVAL, ?, '0', ?, ?, 'adventurer', '0', '1', '0')";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getUser_id());
			psmt.setString(2, dto.getUser_pw());
			psmt.setString(3, dto.getUser_email());
			psmt.setString(4, dto.getUser_name());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("유저를 등록하던 중 오류 발생");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public MemberDTO userLogin(String user_id, String user_pw) {
		MemberDTO dto = new MemberDTO();
		
		String query = "select * from membership where user_id = ? and user_pw = ?";
		
		try {
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, user_id);
			psmt.setString(2, user_pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setUser_id(user_id);
				dto.setUser_pw(user_pw);
				dto.setAuth_level(rs.getString("auth_level"));
				dto.setChar_job(rs.getString("char_job"));
				dto.setFun_point(rs.getInt("fun_point"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_exp(rs.getInt("user_exp"));
				dto.setUser_level(rs.getString("user_level"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_num(rs.getString("user_num"));
			}
			
		}catch(Exception e) {
			System.out.println("로그인 중 오류 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
}
