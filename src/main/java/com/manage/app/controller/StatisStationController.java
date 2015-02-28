package com.manage.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.common.ResultBean;
import com.manage.app.service.StatisService;

/**
 * 驿站统计
 * @author zyp-2_000
 *
 */
@Controller
@RequestMapping("/statis/station")
public class StatisStationController {
	private static Logger GSLogger = LoggerFactory.getLogger(StatisStationController.class);
	
	@Autowired
	private StatisService statisService;
	
	/**
	 * 进入驿站发件数量
	 * @return
	 */
	@RequestMapping(value="expressSend")
	public ModelAndView expressSend(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressSend");
		return mav;
	}
	
	/**
	 * 驿站发件数据
	 * @return
	 */
	@RequestMapping(value="expressSendList")
	public void expressSendList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站上门取件数量
	 * @return
	 */
	@RequestMapping(value="expressGet")
	public ModelAndView expressGet(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressGet");
		return mav;
	}
	
	/**
	 * 驿站上门取件数据
	 * @return
	 */
	@RequestMapping(value="expressGetList")
	public void expressGetList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 1 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站签收数量数量
	 * @return
	 */
	@RequestMapping(value="expressSign")
	public ModelAndView expressSign(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressSign");
		return mav;
	}
	
	/**
	 * 驿站签收数量数据
	 * @return
	 */
	@RequestMapping(value="expressSignList")
	public void expressSignList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.signTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and e.isSigned = 1 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date(e.signTime) order by e.signTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.signTime),weekday(e.signTime)),' - ',subdate(date(e.signTime),weekday(e.signTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and e.isSigned = 1 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.signTime, '%Y-%v') order by e.signTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.signTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 6 and e.isSigned = 1 and date(e.signTime) between '" + startDate + "' and '" + endDate + "' group by month(e.signTime) order by e.signTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入已上门送件数量
	 * @return
	 */
	@RequestMapping(value="expressDelivery")
	public ModelAndView expressDelivery(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressDelivery");
		return mav;
	}
	
	/**
	 * 驿站已上门送件数量数据
	 * @return
	 */
	@RequestMapping(value="expressDeliveryList")
	public void expressDeliveryList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.modifyTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_exp e where e.expState = 5 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date(e.modifyTime) order by e.modifyTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.modifyTime),weekday(e.modifyTime)),' - ',subdate(date(e.modifyTime),weekday(e.modifyTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_exp e where e.expState = 5 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by date_format(e.modifyTime, '%Y-%v') order by e.modifyTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.modifyTime, '%Y-%m') as timeField, count(1) as timeValue from business_exp e where e.expState = 5 and date(e.modifyTime) between '" + startDate + "' and '" + endDate + "' group by month(e.modifyTime) order by e.modifyTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站建议数量
	 * @return
	 */
	@RequestMapping(value="advise")
	public ModelAndView advise(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController advise 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/advise");
		return mav;
	}
	
	/**
	 * 驿站建议数量数据
	 * @return
	 */
	@RequestMapping(value="adviseList")
	public void adviseList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(f.fbTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 3 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date(f.fbTime) order by f.fbTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(f.fbTime),weekday(f.fbTime)),' - ',subdate(date(f.fbTime),weekday(f.fbTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_feedback f where f.fbType = 3 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by date_format(f.fbTime, '%Y-%v') order by f.fbTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(f.fbTime, '%Y-%m') as timeField, count(1) as timeValue from business_feedback f where f.fbType = 3 and date(f.fbTime) between '" + startDate + "' and '" + endDate + "' group by month(f.fbTime) order by f.fbTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入公告浏览量
	 * @return
	 */
	@RequestMapping(value="annoVisits")
	public ModelAndView annoVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController advise 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/annoVisits");
		return mav;
	}
	
	/**
	 * 驿站公告浏览量数据
	 * @return
	 */
	@RequestMapping(value="annoVisitsList")
	public void annoVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.visits) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.visits) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.visits) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	

	/**
	 * 进入公告评论量
	 * @return
	 */
	@RequestMapping(value="annoComments")
	public ModelAndView annoComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController advise 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/annoComments");
		return mav;
	}
	
	/**
	 * 驿站公告评论量数据
	 * @return
	 */
	@RequestMapping(value="annoCommentsList")
	public void annoCommentsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.comments) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.comments) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.comments) as timeValue from business_anno a where a.annoType = 4 and date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入活动参与量
	 * @return
	 */
	@RequestMapping(value="actParticipates")
	public ModelAndView actParticipates(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController actParticipates 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/actParticipates");
		return mav;
	}
	
	/**
	 * 驿站活动参与量数据
	 * @return
	 */
	@RequestMapping(value="actParticipatesList")
	public void actParticipatesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(p.joinTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date(p.joinTime) order by p.joinTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(p.joinTime),weekday(p.joinTime)),' - ',subdate(date(p.joinTime),weekday(p.joinTime))+INTERVAL 6 DAY) as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by date_format(p.joinTime, '%Y-%v') order by p.joinTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(p.joinTime, '%Y-%m') as timeField, count(1) as timeValue from business_activity_participate p where date(p.joinTime) between '" + startDate + "' and '" + endDate + "' group by month(p.joinTime) order by p.joinTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入活动浏览量
	 * @return
	 */
	@RequestMapping(value="actVisits")
	public ModelAndView actVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController advise 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/actVisits");
		return mav;
	}
	
	/**
	 * 驿站活动浏览量数据
	 * @return
	 */
	@RequestMapping(value="actVisitsList")
	public void actVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.visits) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.visits) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.visits) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入活动点赞量
	 * @return
	 */
	@RequestMapping(value="actSupports")
	public ModelAndView actSupports(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController actSupports 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/actSupports");
		return mav;
	}
	
	/**
	 * 驿站活动点赞量数据
	 * @return
	 */
	@RequestMapping(value="actSupportsList")
	public void actSupportsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.supports) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.supports) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.supports) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入活动点赞量
	 * @return
	 */
	@RequestMapping(value="actComments")
	public ModelAndView actComments(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController actComments 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/actComments");
		return mav;
	}
	
	/**
	 * 驿站活动点赞量数据
	 * @return
	 */
	@RequestMapping(value="actCommentsList")
	public void actCommentsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(a.createTime, '%Y-%m-%d') as timeField, sum(a.comments) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date(a.createTime) order by a.createTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(a.createTime),weekday(a.createTime)),' - ',subdate(date(a.createTime),weekday(a.createTime))+INTERVAL 6 DAY) as timeField, sum(a.comments) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by date_format(a.createTime, '%Y-%v') order by a.createTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(a.createTime, '%Y-%m') as timeField, sum(a.comments) as timeValue from business_activity a where date(a.createTime) between '" + startDate + "' and '" + endDate + "' group by month(a.createTime) order by a.createTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入已发快递投诉占比
	 * @return
	 */
	@RequestMapping(value="expressSendComplaintCompare")
	public ModelAndView expressSendComplaintCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressSendComplaintCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressSendComplaintCompare");
		return mav;
	}
	
	/**
	 * 已发快递投诉占比
	 * @return
	 */
	@RequestMapping(value="expressSendComplaintCompareList")
	public void expressSendComplaintCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 2 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入已收快递投诉占比
	 * @return
	 */
	@RequestMapping(value="expressGetComplaintCompare")
	public ModelAndView expressGetComplaintCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressGetComplaintCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/expressGetComplaintCompare");
		return mav;
	}
	
	/**
	 * 已收快递投诉占比
	 * @return
	 */
	@RequestMapping(value="expressGetComplaintCompareList")
	public void expressGetComplaintCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 6 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 6 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where e.expState = 6 and date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入快递服务投诉占比
	 * @return
	 */
	@RequestMapping(value="epxressComplaintCompare")
	public ModelAndView epxressComplaintCompare(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController epxressComplaintCompare 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/statis/station/epxressComplaintCompare");
		return mav;
	}
	
	/**
	 * 快递服务投诉占比
	 * @return
	 */
	@RequestMapping(value="epxressComplaintCompareList")
	public void epxressComplaintCompareList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String scope = request.getParameter("scope");
		try{
			List list = new ArrayList();
			String sql = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//日
					sql = "select date_format(e.sendTime, '%Y-%m-%d') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date(e.sendTime) order by e.sendTime desc";
				}else if(scopeValue == 1) {//周
					sql = "select CONCAT(subdate(date(e.sendTime),weekday(e.sendTime)),' - ',subdate(date(e.sendTime),weekday(e.sendTime))+INTERVAL 6 DAY) as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by date_format(e.sendTime, '%Y-%v') order by e.sendTime desc";
				}else if(scopeValue == 2) {//月
					sql = "select date_format(e.sendTime, '%Y-%m') as timeField, round(count(f.feedbackId)/count(e.expId),2)*100 as timeValue " +
							"from business_exp e " +
							"left join business_feedback f on e.expId = f.expId and f.fbType = 4 " +
							"where date(e.sendTime) between '" + startDate + "' and '" + endDate + "' " +
									"group by month(e.sendTime) order by e.sendTime desc";
				}
				list = statisService.statisBySql(sql);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj.getTimeValue()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(list.size() > 0) {
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
			GSLogger.error("显示modelChannel列表时发生错误：/statis/station/expressSendList", e);
			e.printStackTrace();
		}
	}
	
}
