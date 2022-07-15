package board;

import java.sql.Date;

public class CommentDTO {
	private String boardidx;
	private String idx;
	private String writer;
	private String content;
	private Date postdate;
	private String recommanded;
	public String getBoardidx() {
		return boardidx;
	}
	public void setBoardidx(String boardidx) {
		this.boardidx = boardidx;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getRecommanded() {
		return recommanded;
	}
	public void setRecommanded(String recommanded) {
		this.recommanded = recommanded;
	}
}
