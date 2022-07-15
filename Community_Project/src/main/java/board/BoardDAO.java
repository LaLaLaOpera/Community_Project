package board;

import java.util.List;
import java.util.Vector;

import common.DBConnPool;

public class BoardDAO extends DBConnPool{
	public BoardDAO() {
		super();
	}
	
	public List<BoardDTO> listboard(String startPage){
		List<BoardDTO> boardList = new Vector<BoardDTO>();
		String query = "SELECT * FROM ( SELECT tb.*, ROWNUM rNum FROM ( SELECT * FROM user_board ) tb ) WHERE rNum BETWEEN ? AND ?";
		
		try{
			psmt = con.prepareStatement(query);
			psmt.setString(1, startPage);
			startPage = String.valueOf(Integer.parseInt(startPage)+4);
			psmt.setString(2, startPage);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setThumnail(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setWriter(rs.getString(6));
				dto.setViewcount(rs.getString(7));
				dto.setRecommandcount(rs.getString(8));
				dto.setBoard_cat(rs.getString(9));
				dto.setSub_cat(rs.getString(10));
				dto.setH_recommanded(rs.getString(11));
				dto.setK_recommanded(rs.getString(12));
				boardList.add(dto);
			}
			
		}catch(Exception e) {
			System.out.println("게시물을 조회하던중 오류 발생");
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public List<BoardDTO> listboard(String board_cat, String startPage){
		List<BoardDTO> boardList = new Vector<BoardDTO>();
		String query = "SELECT * FROM user_board";
		
		
		return boardList;
	}
	
	public BoardDTO ContentRetrun(String idx) {
		BoardDTO dto = new BoardDTO();

		String query = "Select * from user_board where idx = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setIdx(idx);
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setThumnail(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setWriter(rs.getString(6));
				dto.setViewcount(rs.getString(7));
				dto.setRecommandcount(rs.getString(8));
				dto.setBoard_cat(rs.getString(9));
				dto.setSub_cat(rs.getString(10));
				dto.setH_recommanded(rs.getString(11));
				dto.setK_recommanded(rs.getString(12));
			}
			else {
				System.out.println("찾는 계시물이 없음");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
