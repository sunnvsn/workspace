package com.lianlife.demo.dao;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lianlife.demo.model.Comment;
import com.lianlife.demo.model.CommentDomain;

@Repository
public class CommentDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addComment(CommentDomain commentDomain) throws UnsupportedEncodingException{		
		sqlSessionTemplate.insert("addComment", commentDomain);
	}
	
	public List<Comment> getCommentList(String msgId) throws UnsupportedEncodingException{
		
		List<CommentDomain> commentDomainList= sqlSessionTemplate.selectList("getCommentList",msgId);
		List<Comment> commentList = new ArrayList();
		
		for(int i=0;i<commentDomainList.size();i++){
			CommentDomain commentDomain = commentDomainList.get(i);
			Comment comment = new Comment();
			comment.setCommentUser(commentDomain.getUserName());
			comment.setComment(new String(commentDomain.getComment(),"UTF-8"));
			commentList.add(comment);
		}
		return commentList;
	}

}
