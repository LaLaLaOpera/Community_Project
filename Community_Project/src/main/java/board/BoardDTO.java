package board;

import java.sql.Date;

public class BoardDTO {
	private String idx;
	private String title;
	private String content;
	private String thumnail;
	private Date postdate;
	private String writer;
	private String viewcount;
	private String recommandcount;
	private String board_cat;
	private String sub_cat;
	private String h_recommanded;
	private String k_recommanded;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getViewcount() {
		return viewcount;
	}
	public void setViewcount(String viewcount) {
		this.viewcount = viewcount;
	}
	public String getRecommandcount() {
		return recommandcount;
	}
	public void setRecommandcount(String recommandcount) {
		this.recommandcount = recommandcount;
	}
	public String getBoard_cat() {
		return board_cat;
	}
	public void setBoard_cat(String board_cat) {
		this.board_cat = board_cat;
	}
	public String getSub_cat() {
		return sub_cat;
	}
	public void setSub_cat(String sub_cat) {
		this.sub_cat = sub_cat;
	}
	public String getH_recommanded() {
		return h_recommanded;
	}
	public void setH_recommanded(String h_recommanded) {
		this.h_recommanded = h_recommanded;
	}
	public String getK_recommanded() {
		return k_recommanded;
	}
	public void setK_recommanded(String k_recommanded) {
		this.k_recommanded = k_recommanded;
	}
}
