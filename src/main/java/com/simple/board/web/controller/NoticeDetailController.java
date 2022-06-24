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
import com.simple.board.web.service.NoticeService;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final int id = Integer.parseInt(request.getParameter("id"));
		
		final NoticeService service = new NoticeService();
		final Notice notice =service.getNotice(id);
		request.setAttribute("notice", notice);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	}
}
