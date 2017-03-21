package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.MySqlSessionFactory;
import com.entity.BoardDTO;

public class BoardService {

	String namespace = "com.acorn.BoardMapper.";
//	replyUI
	// replyUpdate
	// 3.湲��옄�꽭�엳蹂닿린
	public void replyUpdate(BoardDTO dto) {
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			session.insert(namespace + "replyUpdate", dto);
			session.commit();
		} finally {
			session.close();
		}

	}
	public BoardDTO replyUI(int num) {
		//replyUpdate(dto);
		SqlSession session = MySqlSessionFactory.openSession();
		BoardDTO dto = null;
		try {
			dto = session.selectOne(namespace + "replyUI", num);
		} finally {
			session.close();
		}
		return dto;
	}
	public BoardDTO boardRetrieve(int num) {
		SqlSession session = MySqlSessionFactory.openSession();
		BoardDTO dto = null;
		try {
			dto = session.selectOne(namespace + "boardRetrieve", num);
		} finally {
			session.close();
		}
		return dto;
	}// end boardRetrieve

	// 2.湲��벐湲�
	public void boardWrite(BoardDTO dto) {
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			session.insert(namespace + "boardWrite", dto);
			session.commit();
		} finally {
			session.close();
		}

	}// end boardWrite
	public void reply(BoardDTO dto) {
		replyUpdate(dto);
		SqlSession session = MySqlSessionFactory.openSession();
		try {
			session.insert(namespace + "reply", dto);
			session.commit();
		} finally {
			session.close();
		}

	}// end boardWrite

	// 1.紐⑸줉蹂닿린
	public List<BoardDTO> boardList() {
		SqlSession session = MySqlSessionFactory.openSession();
		List<BoardDTO> list = null;
		try {
			list = session.selectList(namespace + "boardList");
		} finally {
			session.close();
		}
		return list;
	}// end
	
}
