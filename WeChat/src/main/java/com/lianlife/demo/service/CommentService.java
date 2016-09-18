package com.lianlife.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lianlife.demo.dao.CommentDao;
import com.lianlife.demo.model.Comment;
import com.lianlife.demo.model.CommentDomain;

@Service
public class CommentService {
	
	@Autowired
	CommentDao commentDao;
	
	public void addComment(CommentDomain commentDomain) throws UnsupportedEncodingException{		
		commentDao.addComment(commentDomain);
	}
	
	public List<Comment> getCommentList(String msgId) throws UnsupportedEncodingException{
		List<Comment> commentList = commentDao.getCommentList(msgId);
		return commentList;
	}

}
