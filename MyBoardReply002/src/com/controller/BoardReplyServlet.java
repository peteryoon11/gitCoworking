package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.BoardDTO;
import com.service.BoardService;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardReplyServlet")
public class BoardReplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num=request.getParameter("num");
		String reproot=request.getParameter("reproot");
		String repstep=request.getParameter("repstep");
		String repindent=request.getParameter("repindent");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		
		BoardDTO dto=new BoardDTO();
		dto.setNum(Integer.parseInt(num));
		dto.setReproot(Integer.parseInt(reproot));
		dto.setRepstep(Integer.parseInt(repstep));
		dto.setRepindent(Integer.parseInt(repindent));
		dto.setTitle(title);
		dto.setAuthor(author);
		dto.setContent(content);
		BoardService service=new BoardService();
		service.reply(dto);
		/*
		BoardDTO dto= service.replyUI(Integer.parseInt(num));
		*/
		
		//request.setAttribute("replyUI", dto);
	
		
		RequestDispatcher dis=request.getRequestDispatcher("BoardListServlet");
		dis.forward(request, response);
	
		//response.sendRedirect("write.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
