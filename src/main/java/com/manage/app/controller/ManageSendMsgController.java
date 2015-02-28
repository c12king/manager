package com.manage.app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.community.app.module.bean.AppVerify;
//import com.community.app.module.vo.AppVerifyQuery;
//import com.community.framework.utils.MessageChannelClient;
//import com.community.framework.utils.StringUtil;
import com.manage.app.bean.ManageSendMsg;
import com.manage.app.common.MessageChannelClient;
import com.manage.app.common.WSRetConfig;
import com.manage.app.service.ManageSendMsgService;
import com.manage.app.vo.ManageSendMsgQuery;
import com.utis.Page;


@Controller
@RequestMapping("/manage/manageSendMsg")
public class ManageSendMsgController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageSendMsgController.class);
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	
	private final String LIST_ACTION = "redirect:/manage/manageSendMsg/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg管理页时发生错误：/manage/manageSendMsg/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	
	
	/*
	 
	 
	 
		int cpage=Integer.parseInt(request.getParameter("page"));
		int size=Integer.parseInt(request.getParameter("rows"));
		String like=request.getParameter("name");
		String id=request.getParameter("id");
		if(id==""){
			id=null;
		}
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Page pageData = manageFunctionService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageFunction manageFunction = (ManageFunction) pageData.getList().get(i);
				result.append("{")
			    .append("\"functionId\":\"").append(manageFunction.getFunctionId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(manageFunction.getMenuId()).append("\"").append(",")
			    .append("\"menuName\":\"").append(manageFunction.getMenuName()).append("\"").append(",")
			    .append("\"functionName\":\"").append(manageFunction.getFunctionName()).append("\"").append(",")
			    .append("\"functionDesc\":\"").append(manageFunction.getFunctionDesc()).append("\"").append(",")
			    .append("\"functionCode\":\"").append(manageFunction.getFunctionCode()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageFunction.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageFunction.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageFunction.getEditor()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(pageData.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
		}catch(Exception e){
			GSLogger.error("显示manageFunction列表时发生错误", e);
			e.printStackTrace();
		}
	
	 * 
	 */
	@RequestMapping(value="list")
	public void list(HttpServletRequest request, HttpServletResponse response) {
		int cpage = 1;
		if (StringUtils.isNotBlank(request.getParameter("page")))
		    cpage=Integer.parseInt(request.getParameter("page"));
		if (StringUtils.isNotBlank(request.getParameter("pageNo")))
			cpage=Integer.parseInt(request.getParameter("pageNo"));
		int size = 10;
		if (StringUtils.isNotBlank(request.getParameter("rows")))
			size=Integer.parseInt(request.getParameter("rows"));
		if (StringUtils.isNotBlank(request.getParameter("pageSize")))  
			size = Integer.parseInt(request.getParameter("pageSize"));
		
		String id = null;
		if (StringUtils.isNotBlank(request.getParameter("state")))
			id = request.getParameter("state");
		String like = null;
		if (StringUtils.isNotBlank(request.getParameter("sendTel")))
			like = request.getParameter("sendTel");
		
		Page page = new Page(cpage,size,like,id);
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			//Page pageData 
			Page pageData = manageSendMsgService.findAllPage(page);
			result.append("{\"total\":").append(pageData.getTotalRow()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<pageData.getList().size();i++) {
				ManageSendMsg manageSendMsg = (ManageSendMsg) pageData.getList().get(i);
				
				String recvCode = manageSendMsg.getRecvCode();
				if (StringUtils.isNotBlank(recvCode) && recvCode.contains("-"))
					recvCode = WSRetConfig.getProperty("WS_RET_CODE"+recvCode);
				else
					recvCode = "成功";
				
				result.append("{")
			    .append("\"sendId\":\"").append(manageSendMsg.getSendId()).append("\"").append(",")
			    .append("\"sendTel\":\"").append(manageSendMsg.getSendTel()).append("\"").append(",")
			    .append("\"sendContent\":\"").append(manageSendMsg.getSendContent()).append("\"").append(",")
			    .append("\"recvCode\":\"").append( recvCode ).append("\"").append(",")
			    .append("\"sendTime\":\"").append(manageSendMsg.getSendTime()).append("\"").append(",")
			    .append("\"sendType\":\"").append( manageSendMsg.getSendType() == 0 ? "快递" : "注册"  ).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(pageData.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示manageSendMsg列表时发生错误：/manage/manageSendMsg/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageSendMsgQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg新增页时发生错误：/manage/manageSendMsg/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageSendMsg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageSendMsgQuery query) {
		ManageSendMsg manageSendMsg = new ManageSendMsg();
		String json = "";
		try{
		    manageSendMsg.setSendTel(query.getSendTel());
		    manageSendMsg.setSendContent(query.getSendContent());
		    manageSendMsg.setRecvCode(query.getRecvCode());
		    manageSendMsg.setSendTime(query.getSendTime());
		    manageSendMsg.setSendType(query.getSendType());
			manageSendMsgService.save(manageSendMsg);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageSendMsg信息时发生错误：/manage/manageSendMsg/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(ManageSendMsgQuery query) {	
		ManageSendMsg manageSendMsg=new ManageSendMsg();
		
		try{
			manageSendMsg = manageSendMsgService.findById(query.getSendId());
		}catch(Exception e){
			GSLogger.error("进入manageSendMsg修改页时发生错误：/manage/manageSendMsg/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageSendMsg/modify");
		mav.addObject("manageSendMsg", manageSendMsg);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageSendMsgQuery query) {
		ManageSendMsg manageSendMsg = null;
		String json = "";
		try{
		    manageSendMsg = manageSendMsgService.findById(query.getSendId());
		    manageSendMsg.setSendTel(query.getSendTel());
		    manageSendMsg.setSendContent(query.getSendContent());
		    manageSendMsg.setRecvCode(query.getRecvCode());
		    manageSendMsg.setSendTime(query.getSendTime());
		    manageSendMsg.setSendType(query.getSendType());
			manageSendMsgService.update(manageSendMsg);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageSendMsg信息时发生错误：/manage/manageSendMsg/update", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						manageSendMsgService.delete(new Integer(ids[i]));
					}
				}else{
					manageSendMsgService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageSendMsg时发生错误：/manage/manageSendMsg/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(value="resend")
	public void resend(HttpServletRequest request, HttpServletResponse response)
	{
		String json = "";
	    try{
	    	String id =  request.getParameter("telId") ;
	    	if( StringUtils.isBlank(id) )
	    		return;
	    	ManageSendMsg sMsg = manageSendMsgService.findById(Integer.parseInt(id));
			String returnMessage = returnMessageRrid(sMsg.getSendTel(), sMsg.getSendContent());
			if(!returnMessage.contains("-")) {
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"发送成功\"";
				json += "}";
			}else
			{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\""+WSRetConfig.getProperty("WS_RET_CODE"+returnMessage)+"\"";
				json += "}";
			}
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"发送异常\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public static String returnMessageRrid(String telphone, String messageContent) throws UnsupportedEncodingException{
		String sn="SDK-BBX-010-21023";
		String pwd="b3d1-37_";
		MessageChannelClient client=new MessageChannelClient(sn,pwd);
		//获取信息
		// String result = client.mdgetSninfo();
		// System.out.print(result);
		//短信发送		
		StringBuilder sb = new StringBuilder();
		sb.append(messageContent);
		//sb.append("您正在申请注册OK家注册用户,验证码").append(messageContent).append(",2分钟内有效。【OK家】");
		String content=URLEncoder.encode(sb.toString(), "utf8");
		String result_mt = client.mdsmssend(telphone, content, "", "", "", "");
		// System.out.print(result_mt);
		return result_mt;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String messageContent = "【罗马嘉园西区驿站】尊贵的主人，我是您的快件。现已到达社区服务驿站，请您快来社区服务驿站接我吧！驿站电话:58627223取件签收码：382634请妥善保管；为了让尊贵的主人享受更便捷的服务，驿站专属手机社区服务平台“OK家”已经发布了，猛戳后边链接，也把他接回家吧：http://www.bqsqcm.com/community/download/index.html?id=11【OK家】";
		String xx = returnMessageRrid("18610583510",messageContent);
		
		System.out.println(xx);
	}
}
