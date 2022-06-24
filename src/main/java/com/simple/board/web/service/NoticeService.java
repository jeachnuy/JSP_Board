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

	public List<Notice> getNoticeList(final int page) {
		return getNoticeList("title", "", page);
	}

	public List<Notice> getNoticeList(final String field, final String query, final int page) {
		List<Notice> list = new ArrayList<>();
		
		final String sql = "select a.* from( " 
				+ "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and " + field 
				+ " like ? order by n.REGDATE desc) as a " 
				+ "where rn BETWEEN ? and ?";
		final String url = "jdbc:mysql://localhost:3306/devdb";

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

				final Notice notice = new Notice(id, title, writer_id, regdate, hit, content);
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

	public int getNoticeCount(final String field, final String query) {
		int count = 0;
		
		final String sql = "select count(a.id) count from( " 
				+ "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and " + field
				+ " like ? order by n.REGDATE desc) as a";
		final String url = "jdbc:mysql://localhost:3306/devdb";

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

	public Notice getNotice(final int id) {
		Notice notice =null;
		final String sql = "select * from NOTICE where id=?";
		final String url = "jdbc:mysql://localhost:3306/devdb";

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

	public Notice getNextNotice(final int id) {
		Notice notice =null;
		final String sql = "select a.* from( " + "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and n.REGDATE > (select REGDATE from NOTICE where id=?) "
				+ "order by n.REGDATE asc) a";
		final String url = "jdbc:mysql://localhost:3306/devdb";

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

	public Notice getPrevNotice(final int id) {
		Notice notice =null;
		final String sql = "select a.* from( " + "select @rownum:=@rownum+1 rn, n.* from NOTICE n "
				+ "where(@rownum:=0)=0 and n.REGDATE < (select REGDATE from NOTICE where id=?) "
				+ "order by n.REGDATE desc) a";
		final String url = "jdbc:mysql://localhost:3306/devdb";

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
	
	public int insertNotice(Notice notice) {
		int result =0;
		final String sql = "insert into NOTICE(title, writer_id, content) "
				+ "values(?, ?, ?)";
		final String url = "jdbc:mysql://localhost:3306/devdb";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "devuser", "devpass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getWriter_id());
			st.setString(3, notice.getContent());
			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
