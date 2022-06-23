package com.simple.board.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.board.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		String url = "jdbc:mysql://localhost:3306/devdb";
		String sql = "select * from NOTICE where ID=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "devuser", "devpass");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		rs.next();

		String title = rs.getString("title");
		String writer_id = rs.getString("writer_id");
		Date regdate = rs.getDate("regdate");
		int hit = rs.getInt("hit");
		String content = rs.getString("content");
		
		Notice notice =new Notice(id, title, writer_id, regdate, hit, content);
		
		request.setAttribute("notice", notice);
		
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

		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	}
}
