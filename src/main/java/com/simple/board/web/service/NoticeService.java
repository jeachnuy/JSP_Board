package com.simple.board.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.simple.board.web.entity.Notice;

public class NoticeService {
	public List<Notice> getNoticeList() {
		return getNoticeList("title", "", 1);
	}

	public List<Notice> getNoticeList(int page) {
		return getNoticeList("title", "", page);
	}

	public List<Notice> getNoticeList(String field, String query, int page) {
		List<Notice> list = new ArrayList<>();
		
		String sql = "select a.* from( " 
				+ "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and " + field 
				+ " like ? order by n.REGDATE desc) as a " 
				+ "where rn BETWEEN ? and ?";
		String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String writer_id = rs.getString("writer_id");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");

				Notice notice = new Notice(id, title, writer_id, regdate, hit, content);
				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getNoticeCount() {
		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {
		int count = 0;
		
		String sql = "select count(a.id) count from( " 
				+ "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and " + field
				+ " like ? order by n.REGDATE desc) as a";
		String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();
			count = rs.getInt("count");
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Notice getNotice(int id) {
		Notice notice =null;
		String sql = "select * from NOTICE where id=?";
		String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				int id_ = rs.getInt("id");
				String title = rs.getString("title");
				String writer_id = rs.getString("writer_id");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");

				notice = new Notice(id_, title, writer_id, regdate, hit, content);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getNextNotice(int id) {
		Notice notice =null;
		String sql = "select a.* from( " + "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and n.REGDATE > (select REGDATE from NOTICE where id=?) "
				+ "order by n.REGDATE asc) a";
		String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				int id_ = rs.getInt("id");
				String title = rs.getString("title");
				String writer_id = rs.getString("writer_id");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");

				notice = new Notice(id_, title, writer_id, regdate, hit, content);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {
		Notice notice =null;
		String sql = "select a.* from( " + "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and n.REGDATE < (select REGDATE from NOTICE where id=?) "
				+ "order by n.REGDATE desc) a";
		String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				int id_ = rs.getInt("id");
				String title = rs.getString("title");
				String writer_id = rs.getString("writer_id");
				Date regdate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");

				notice = new Notice(id_, title, writer_id, regdate, hit, content);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
}
