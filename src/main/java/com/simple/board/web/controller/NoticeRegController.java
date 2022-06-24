package com.simple.board.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.board.web.entity.Notice;
import com.simple.board.web.service.NoticeService;

@WebServlet("/notice/reg")
public class NoticeRegController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer_id = request.getParameter("writer_id");
		String content = request.getParameter("content");
		
		Notice notice =new Notice();
		notice.setTitle(title);
		notice.setWriter_id(writer_id);
		notice.setContent(content);
		
		NoticeService service =new NoticeService();
		int result =service.insertNotice(notice);
		
		response.sendRedirect("list");
	}
}
