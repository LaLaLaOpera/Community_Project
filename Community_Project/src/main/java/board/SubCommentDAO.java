package board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.DBConnPool;

public class SubCommentDAO extends DBConnPool{
	public int insertComment(SubCommentDTO dto) {
		int result = 0;
		String query = "Insert into subcomment (boardidx, commentidx, writer, content, mention) values(?,?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getBoardidx());
			psmt.setString(2, dto.getCommentidx());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getContent());
			psmt.setString(5, dto.getMention());
			
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public Map<String,List<SubCommentDTO>> queryComment(String idx) {
		Map<String,List<SubCommentDTO>> subCommentsList = new HashMap<String,List<SubCommentDTO>>();
		
		String query = "Select COUNT(*) from user_comment where boardidx = ?";
		int result = 0;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			System.out.println("코멘트 수를 세다가 오류");
			e.printStackTrace();
		}
		
		for (int i = 1; i<=result;i++) {
			List<SubCommentDTO> newList = new Vector<SubCommentDTO>();
			query = "Select * from subcomment where commentidx = ? AND boardidx = ?";
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1,String.valueOf(i));
				psmt.setString(2,idx);
				rs = psmt.executeQuery();
				
				while(rs.next()){
					SubCommentDTO dto = new SubCommentDTO();
					dto.setBoardidx(idx);
					dto.setCommentidx(String.valueOf(i));
					dto.setContent(rs.getString("content"));
					dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
					dto.setMention(rs.getString("mention"));
					dto.setPostdate(rs.getDate("postdate"));
					dto.setRecommanded(rs.getString("recommanded"));
					dto.setWriter(rs.getString("writer"));
					
					newList.add(dto);	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			subCommentsList.put(String.valueOf(i), newList);
		}
		return subCommentsList;
	}
}
