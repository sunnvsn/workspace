package com.lianlife.demo.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lianlife.demo.model.Comment;
import com.lianlife.demo.model.CommentDomain;
import com.lianlife.demo.model.Dynamic;
import com.lianlife.demo.model.DynamicDomain;
import com.lianlife.demo.model.HttpUtil;
import com.lianlife.demo.model.velocity.VelocityServiceImpl;
import com.lianlife.demo.service.CommentService;
import com.lianlife.demo.service.DynamicService;

@Controller
public class WeChatController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	DynamicService dynamicService;
	
	//访问登陆页面
	@RequestMapping("/login")
	public String login(ModelMap map) {
		return "login";
	}
	
	//登陆验证
	@RequestMapping("/loginToIndex")
	public void loginToIndex(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		
		response.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		//从页面获取用户名和密码
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		String uN = "admin";
		String ps = "123";
		
		HashMap returnData=new HashMap();
		
		if(uN.equals(userName)&&ps.equals(password)){
			//验证通过
			request.getSession(true).setAttribute("userName", "admin");
			returnData.put("status", true);
			HttpUtil.returnHttpJson(response, returnData);			
		}else{
			//验证失败
			returnData.put("status", false);
			HttpUtil.returnHttpJson(response, returnData);
		}
	}
	
	//访问首页
	@RequestMapping("/index")
	public void index(HttpServletRequest request,HttpServletResponse response) throws IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");		
		
		String userName=(String) request.getSession(true).getAttribute("userName");
		
		if(userName.equals(null) || userName.equals("")){
			//没有登陆则跳转到登陆页面
			response.sendRedirect("http://localhost:8088/WeChat/login");
		}else{
			//已登陆则获取首页中动态和评论信息
			List<Dynamic> dynamicList = dynamicService.getDynamicList();
			for(int i=0;i<dynamicList.size();i++){
				List<Comment> commentList = commentService.getCommentList(dynamicList.get(i).getMessageId());
				dynamicList.get(i).setCommentList(commentList);
			}
			
			JSONArray jsonArray = JSONArray.fromObject(dynamicList);
			
			Map map = new HashMap();
			map.put("list", jsonArray);
			String indexHtml = null;
			//用Velocity  java模板引擎生成页面
			VelocityServiceImpl velocityServiceImpl = new VelocityServiceImpl();
			indexHtml = velocityServiceImpl.mergeTemplateIntoString("List.vm", map);
			try {
				response.getWriter().print(indexHtml);
			} catch (IOException e) {
				e.printStackTrace();
			}		
		}
	}	
	
	//添加评论
	@RequestMapping("/addComment")
	public void addComment(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		String commentId=UUID.randomUUID().toString().replaceAll("-", "");
		
		CommentDomain commentDomain = new CommentDomain();
		commentDomain.setCommentId(commentId);
		commentDomain.setMessageId(request.getParameter("messageId"));
		commentDomain.setCommentUserId(request.getParameter("userId"));
		commentDomain.setComment(request.getParameter("comment").getBytes("UTF-8"));
		commentService.addComment(commentDomain);
		
		HashMap returnData=new HashMap();
		returnData.put("status", true);
		returnData.put("commentId", commentId);
		HttpUtil.returnHttpJson(response, returnData);
	}
	
	//添加动态
	@RequestMapping("/addMessage")
	public void addMessage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		String msgId=UUID.randomUUID().toString().replaceAll("-", "");
		
		DynamicDomain dynamicDomain = new DynamicDomain();
		dynamicDomain.setMessageId(msgId);
		dynamicDomain.setUserId(request.getParameter("userId"));		
		dynamicDomain.setMessageContent(request.getParameter("message").getBytes("UTF-8"));
	    dynamicService.addDynamic(dynamicDomain);
		
		HashMap returnData=new HashMap();
		returnData.put("status", true);
		returnData.put("messageId", msgId);
		HttpUtil.returnHttpJson(response, returnData);
	}
	
}
