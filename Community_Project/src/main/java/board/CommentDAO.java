package board;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class CommentDAO extends DBConnPool{
	public int insertComment(CommentDTO dto) {
		int result = 0;
		String query = "Insert into user_comment (boardidx, idx, writer, content) values(?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getBoardidx());
			psmt.setString(2, dto.getIdx());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<CommentDTO> queryComment(String idx){
		List<CommentDTO> commentList = new Vector<CommentDTO>();
		String query = "Select * from user_comment where boardidx = ?";
		try {
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, idx);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				dto.setBoardidx(idx);
				dto.setIdx(rs.getString("idx"));
				dto.setContent(rs.getString("content"));
				dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setRecommanded(rs.getString("recommanded"));
				dto.setWriter(rs.getString("writer"));
				
				commentList.add(dto);
			}
		}catch(Exception e) {
			
		}
		return commentList;
	}
	
	public String maxIdx(String idx) {
		String maxIdx = "1";
	
		String query = "SELECT MAX(idx) FROM USER_COMMENT WHERE BOARDIDX = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				maxIdx = rs.getString(1);
			}
		}catch(Exception e) {
			System.out.println("댓글 최대값을 찾는중 오류 발생");
			e.printStackTrace();
		}
		return maxIdx;
	}
}
