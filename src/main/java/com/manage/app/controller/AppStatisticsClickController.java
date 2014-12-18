package com.manage.app.controller;



import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manage.app.common.ResultBean;
import com.manage.app.service.StatisService;




@Controller
@RequestMapping("/app/appStatisticsClick")
public class AppStatisticsClickController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppStatisticsClickController.class);
	
	private final String LIST_ACTION = "redirect:/app/appStatisticsClick/list.do";
	@Autowired
	private StatisService statisService;
	
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appStatisticsClick管理页时发生错误：/app/appStatisticsClick/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("manage/appStatisticsClick/enter");
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
			List list1 = new ArrayList();
			String sql = "";
			String sql1 = "";
			if(scope != null && 
					startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				Integer scopeValue = new Integer(scope);
				if(scopeValue == 0) {//app
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";

				}else if(scopeValue == 1) {//快递
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('1','2','3','4','96','95','94','93','92') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('1','2','3','4','96','95','94','93','92') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 2) {//二手统计
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('5' ,'6','7','8', '9','10','11','61') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('5' ,'6','7','8', '9','10','11','61') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 3) {//邻里求助
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('16' ,'17','18','19', '20','21','62') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('16' ,'17','18','19', '20','21','62') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 4) {//中医养生
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in  ('82' ,'83','84','85', '86') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in  ('82' ,'83','84','85', '86') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 5) {//健康饮食
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('87' ,'88','89','90', '91') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('87' ,'88','89','90', '91') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 6) {//北青社区报
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('22') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('22') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 7) {//社区活动
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('23' ,'24','25','26', '27','28') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('23' ,'24','25','26', '27','28') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 8) {//驿站服务
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('29') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('29') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 9) {//驿站女孩
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('30','31') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('30','31') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 10) {//驿站公告
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('32' ,'33','34','35', '36') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('32' ,'33','34','35', '36') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 11) {//物业通知
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('37' ,'38','39','40', '41') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('37' ,'38','39','40', '41') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 12) {//物业手册
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('42') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('42') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 13) {//小区周边
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('43') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('43') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 14){//社区黄页
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('44') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('44') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 15){//首页
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('0') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('0') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else if(scopeValue == 16){//新闻
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where type in ('12' ,'13','14','15') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where type in ('12' ,'13','14','15') and  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}else {
					sql = "select COUNT(DISTINCT userId) as timeField from app_statistics_click  where  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
					sql1 = "select COUNT(*) as timeField from app_statistics_click  where  timestamp(createTime) between '" + startDate + "' and '" + endDate + "'";
				}
				list = statisService.statisBySql(sql);
				list1 = statisService.statisBySql(sql1);
			}
			result.append("{\"total\":").append(list.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<list.size();i++) {
				ResultBean obj = (ResultBean) list.get(i);
				ResultBean obj1 = (ResultBean) list1.get(i);
				result.append("{")
			    .append("\"timeField\":\"").append(obj.getTimeField()).append("\"").append(",")
			    .append("\"timeValue\":\"").append(obj1.getTimeField()).append("\"")
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
	 * 进入快递-总访问人数
	 * @return
	 */
	@RequestMapping(value="expressCount")
	public ModelAndView expressCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/express/expressCount");
		return mav;
	}
	
	/**
	 * 快递-总访问人数
	 * @return
	 */
	@RequestMapping(value="expressCountList")
	public void expressCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('1','2','3','4','96','95','94','93','92') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：expressCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入快递-总浏览量
	 * @return
	 */
	@RequestMapping(value="expressVisits")
	public ModelAndView expressVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/express/expressVisits");
		return mav;
	}
	
	/**
	 * 快递-总浏览量
	 * @return
	 */
	@RequestMapping(value="expressVisitsList")
	public void expressVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('1','2','3','4','96','95','94','93','92') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：expressCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入快递-平均访问页数
	 * @return
	 */
	@RequestMapping(value="expressAvePages")
	public ModelAndView expressAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController expressAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/express/expressAvePages");
		return mav;
	}
	
	/**
	 * 快递-平均访问页数
	 * @return
	 */
	@RequestMapping(value="expressAvePagesList")
	public void expressAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('1','2','3','4','96','95','94','93','92') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：expressAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入跳蚤市场-总访问人数
	 * @return
	 */
	@RequestMapping(value="marketCount")
	public ModelAndView marketSend(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/market/marketCount");
		return mav;
	}
	
	/**
	 * 跳蚤市场-总访问人数
	 * @return
	 */
	@RequestMapping(value="marketCountList")
	public void marketCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('5' ,'6','7','8', '9','10','11','61') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：marketCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入跳蚤市场-总浏览量
	 * @return
	 */
	@RequestMapping(value="marketVisits")
	public ModelAndView marketVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/market/marketVisits");
		return mav;
	}
	
	/**
	 * 跳蚤市场-总浏览量
	 * @return
	 */
	@RequestMapping(value="marketVisitsList")
	public void marketVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('5' ,'6','7','8', '9','10','11','61') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：marketCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入跳蚤市场-平均访问页数
	 * @return
	 */
	@RequestMapping(value="marketAvePages")
	public ModelAndView marketAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController marketAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/market/marketAvePages");
		return mav;
	}
	
	/**
	 * 跳蚤市场-平均访问页数
	 * @return
	 */
	@RequestMapping(value="marketAvePagesList")
	public void marketAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('5' ,'6','7','8', '9','10','11','61') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：marketAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入邻里求助-总访问人数
	 * @return
	 */
	@RequestMapping(value="helpCount")
	public ModelAndView helpSend(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/help/helpCount");
		return mav;
	}
	
	/**
	 * 邻里求助-总访问人数
	 * @return
	 */
	@RequestMapping(value="helpCountList")
	public void helpCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('16' ,'17','18','19', '20','21','62') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：helpCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入邻里求助-总浏览量
	 * @return
	 */
	@RequestMapping(value="helpVisits")
	public ModelAndView helpVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/help/helpVisits");
		return mav;
	}
	
	/**
	 * 邻里求助-总浏览量
	 * @return
	 */
	@RequestMapping(value="helpVisitsList")
	public void helpVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('16' ,'17','18','19', '20','21','62') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：helpCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入邻里求助-平均访问页数
	 * @return
	 */
	@RequestMapping(value="helpAvePages")
	public ModelAndView helpAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController helpAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/help/helpAvePages");
		return mav;
	}
	
	/**
	 * 邻里求助-平均访问页数
	 * @return
	 */
	@RequestMapping(value="helpAvePagesList")
	public void helpAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('16' ,'17','18','19', '20','21','62') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：helpAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入中医养生-总访问人数
	 * @return
	 */
	@RequestMapping(value="chinCount")
	public ModelAndView chinCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/chin/chinCount");
		return mav;
	}
	
	/**
	 * 中医养生-总访问人数
	 * @return
	 */
	@RequestMapping(value="chinCountList")
	public void chinCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：chinCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入中医养生-总浏览量
	 * @return
	 */
	@RequestMapping(value="chinVisits")
	public ModelAndView chinVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/chin/chinVisits");
		return mav;
	}
	
	/**
	 * 中医养生-总浏览量
	 * @return
	 */
	@RequestMapping(value="chinVisitsList")
	public void chinVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：chinCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入中医养生-平均访问页数
	 * @return
	 */
	@RequestMapping(value="chinAvePages")
	public ModelAndView chinAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController chinAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/chin/chinAvePages");
		return mav;
	}
	
	/**
	 * 中医养生-平均访问页数
	 * @return
	 */
	@RequestMapping(value="chinAvePagesList")
	public void chinAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：chinAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区报-总访问人数
	 * @return
	 */
	@RequestMapping(value="newsCount")
	public ModelAndView newsCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/news/newsCount");
		return mav;
	}
	
	/**
	 * 社区报-总访问人数
	 * @return
	 */
	@RequestMapping(value="newsCountList")
	public void newsCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('22') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：newsCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区报-总浏览量
	 * @return
	 */
	@RequestMapping(value="newsVisits")
	public ModelAndView newsVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/news/newsVisits");
		return mav;
	}
	
	/**
	 * 社区报-总浏览量
	 * @return
	 */
	@RequestMapping(value="newsVisitsList")
	public void newsVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('22') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：newsCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区报-平均访问页数
	 * @return
	 */
	@RequestMapping(value="newsAvePages")
	public ModelAndView newsAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newsAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/news/newsAvePages");
		return mav;
	}
	
	/**
	 * 社区报-平均访问页数
	 * @return
	 */
	@RequestMapping(value="newsAvePagesList")
	public void newsAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('22') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：newsAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区活动-总访问人数
	 * @return
	 */
	@RequestMapping(value="activityCount")
	public ModelAndView activityCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/activity/activityCount");
		return mav;
	}
	
	/**
	 * 社区活动-总访问人数
	 * @return
	 */
	@RequestMapping(value="activityCountList")
	public void activityCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('23' ,'24','25','26', '27','28') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：activityCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区活动-总浏览量
	 * @return
	 */
	@RequestMapping(value="activityVisits")
	public ModelAndView activityVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/activity/activityVisits");
		return mav;
	}
	
	/**
	 * 社区活动-总浏览量
	 * @return
	 */
	@RequestMapping(value="activityVisitsList")
	public void activityVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('23' ,'24','25','26', '27','28') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：activityCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区活动-平均访问页数
	 * @return
	 */
	@RequestMapping(value="activityAvePages")
	public ModelAndView activityAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController activityAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/activity/activityAvePages");
		return mav;
	}
	
	/**
	 * 社区活动-平均访问页数
	 * @return
	 */
	@RequestMapping(value="activityAvePagesList")
	public void activityAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('23' ,'24','25','26', '27','28') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：activityAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站服务-总访问人数
	 * @return
	 */
	@RequestMapping(value="serviceCount")
	public ModelAndView serviceCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/service/serviceCount");
		return mav;
	}
	
	/**
	 * 驿站服务-总访问人数
	 * @return
	 */
	@RequestMapping(value="serviceCountList")
	public void serviceCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('29') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：serviceCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站服务-总浏览量
	 * @return
	 */
	@RequestMapping(value="serviceVisits")
	public ModelAndView serviceVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/service/serviceVisits");
		return mav;
	}
	
	/**
	 * 驿站服务-总浏览量
	 * @return
	 */
	@RequestMapping(value="serviceVisitsList")
	public void serviceVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('29') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：serviceCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站服务-平均访问页数
	 * @return
	 */
	@RequestMapping(value="serviceAvePages")
	public ModelAndView serviceAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController serviceAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/service/serviceAvePages");
		return mav;
	}
	
	/**
	 * 驿站服务-平均访问页数
	 * @return
	 */
	@RequestMapping(value="serviceAvePagesList")
	public void serviceAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('29') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：serviceAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站女孩-总访问人数
	 * @return
	 */
	@RequestMapping(value="girlCount")
	public ModelAndView girlCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/girl/girlCount");
		return mav;
	}
	
	/**
	 * 驿站女孩-总访问人数
	 * @return
	 */
	@RequestMapping(value="girlCountList")
	public void girlCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('30','31') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：girlCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站女孩-总浏览量
	 * @return
	 */
	@RequestMapping(value="girlVisits")
	public ModelAndView girlVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/girl/girlVisits");
		return mav;
	}
	
	/**
	 * 驿站女孩-总浏览量
	 * @return
	 */
	@RequestMapping(value="girlVisitsList")
	public void girlVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('30','31') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：girlCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站女孩-平均访问页数
	 * @return
	 */
	@RequestMapping(value="girlAvePages")
	public ModelAndView girlAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController girlAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/girl/girlAvePages");
		return mav;
	}
	
	/**
	 * 驿站女孩-平均访问页数
	 * @return
	 */
	@RequestMapping(value="girlAvePagesList")
	public void girlAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('30','31') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：girlAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站公告-总访问人数
	 * @return
	 */
	@RequestMapping(value="stationAnnoCount")
	public ModelAndView stationAnnoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/stationAnno/stationAnnoCount");
		return mav;
	}
	
	/**
	 * 驿站公告-总访问人数
	 * @return
	 */
	@RequestMapping(value="stationAnnoCountList")
	public void stationAnnoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('32' ,'33','34','35', '36') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：stationAnnoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站公告-总浏览量
	 * @return
	 */
	@RequestMapping(value="stationAnnoVisits")
	public ModelAndView stationAnnoVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/stationAnno/stationAnnoVisits");
		return mav;
	}
	
	/**
	 * 驿站公告-总浏览量
	 * @return
	 */
	@RequestMapping(value="stationAnnoVisitsList")
	public void stationAnnoVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('32' ,'33','34','35', '36') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：stationAnnoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入驿站公告-平均访问页数
	 * @return
	 */
	@RequestMapping(value="stationAnnoAvePages")
	public ModelAndView stationAnnoAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController stationAnnoAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/stationAnno/stationAnnoAvePages");
		return mav;
	}
	
	/**
	 * 驿站公告-平均访问页数
	 * @return
	 */
	@RequestMapping(value="stationAnnoAvePagesList")
	public void stationAnnoAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('32' ,'33','34','35', '36') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：stationAnnoAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业通知-总访问人数
	 * @return
	 */
	@RequestMapping(value="propAnnoCount")
	public ModelAndView propAnnoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/propAnno/propAnnoCount");
		return mav;
	}
	
	/**
	 * 物业通知-总访问人数
	 * @return
	 */
	@RequestMapping(value="propAnnoCountList")
	public void propAnnoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('37' ,'38','39','40', '41') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：propAnnoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业通知-总浏览量
	 * @return
	 */
	@RequestMapping(value="propAnnoVisits")
	public ModelAndView propAnnoVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/propAnno/propAnnoVisits");
		return mav;
	}
	
	/**
	 * 物业通知-总浏览量
	 * @return
	 */
	@RequestMapping(value="propAnnoVisitsList")
	public void propAnnoVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('37' ,'38','39','40', '41') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：propAnnoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业通知-平均访问页数
	 * @return
	 */
	@RequestMapping(value="propAnnoAvePages")
	public ModelAndView propAnnoAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController propAnnoAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/propAnno/propAnnoAvePages");
		return mav;
	}
	
	/**
	 * 物业通知-平均访问页数
	 * @return
	 */
	@RequestMapping(value="propAnnoAvePagesList")
	public void propAnnoAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('37' ,'38','39','40', '41') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：propAnnoAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业手册-总访问人数
	 * @return
	 */
	@RequestMapping(value="bookCount")
	public ModelAndView bookCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/book/bookCount");
		return mav;
	}
	
	/**
	 * 物业手册-总访问人数
	 * @return
	 */
	@RequestMapping(value="bookCountList")
	public void bookCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('42') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：bookCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业手册-总浏览量
	 * @return
	 */
	@RequestMapping(value="bookVisits")
	public ModelAndView bookVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/book/bookVisits");
		return mav;
	}
	
	/**
	 * 物业手册-总浏览量
	 * @return
	 */
	@RequestMapping(value="bookVisitsList")
	public void bookVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('42') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：bookCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入物业手册-平均访问页数
	 * @return
	 */
	@RequestMapping(value="bookAvePages")
	public ModelAndView bookAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController bookAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/book/bookAvePages");
		return mav;
	}
	
	/**
	 * 物业手册-平均访问页数
	 * @return
	 */
	@RequestMapping(value="bookAvePagesList")
	public void bookAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('42') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：bookAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入小区周边-总访问人数
	 * @return
	 */
	@RequestMapping(value="aroundCount")
	public ModelAndView aroundCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/around/aroundCount");
		return mav;
	}
	
	/**
	 * 小区周边-总访问人数
	 * @return
	 */
	@RequestMapping(value="aroundCountList")
	public void aroundCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('43') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：aroundCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入小区周边-总浏览量
	 * @return
	 */
	@RequestMapping(value="aroundVisits")
	public ModelAndView aroundVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/around/aroundVisits");
		return mav;
	}
	
	/**
	 * 小区周边-总浏览量
	 * @return
	 */
	@RequestMapping(value="aroundVisitsList")
	public void aroundVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('43') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：aroundCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入小区周边-平均访问页数
	 * @return
	 */
	@RequestMapping(value="aroundAvePages")
	public ModelAndView aroundAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController aroundAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/around/aroundAvePages");
		return mav;
	}
	
	/**
	 * 小区周边-平均访问页数
	 * @return
	 */
	@RequestMapping(value="aroundAvePagesList")
	public void aroundAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('43') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：aroundAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区黄页-总访问人数
	 * @return
	 */
	@RequestMapping(value="yellowCount")
	public ModelAndView yellowCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/yellow/yellowCount");
		return mav;
	}
	
	/**
	 * 社区黄页-总访问人数
	 * @return
	 */
	@RequestMapping(value="yellowCountList")
	public void yellowCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('44') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：yellowCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区黄页-总浏览量
	 * @return
	 */
	@RequestMapping(value="yellowVisits")
	public ModelAndView yellowVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/yellow/yellowVisits");
		return mav;
	}
	
	/**
	 * 社区黄页-总浏览量
	 * @return
	 */
	@RequestMapping(value="yellowVisitsList")
	public void yellowVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('44') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：yellowCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入社区黄页-平均访问页数
	 * @return
	 */
	@RequestMapping(value="yellowAvePages")
	public ModelAndView yellowAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController yellowAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/yellow/yellowAvePages");
		return mav;
	}
	
	/**
	 * 社区黄页-平均访问页数
	 * @return
	 */
	@RequestMapping(value="yellowAvePagesList")
	public void yellowAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('44') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：yellowAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入首页-总访问人数
	 * @return
	 */
	@RequestMapping(value="indexCount")
	public ModelAndView indexCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/index/indexCount");
		return mav;
	}
	
	/**
	 * 首页-总访问人数
	 * @return
	 */
	@RequestMapping(value="indexCountList")
	public void indexCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('0') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：indexCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入首页-总浏览量
	 * @return
	 */
	@RequestMapping(value="indexVisits")
	public ModelAndView indexVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/index/indexVisits");
		return mav;
	}
	
	/**
	 * 首页-总浏览量
	 * @return
	 */
	@RequestMapping(value="indexVisitsList")
	public void indexVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('0') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：indexCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入首页-平均访问页数
	 * @return
	 */
	@RequestMapping(value="indexAvePages")
	public ModelAndView indexAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController indexAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/index/indexAvePages");
		return mav;
	}
	
	/**
	 * 首页-平均访问页数
	 * @return
	 */
	@RequestMapping(value="indexAvePagesList")
	public void indexAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('0') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：indexAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	

	/**
	 * 进入app-总访问人数
	 * @return
	 */
	@RequestMapping(value="appCount")
	public ModelAndView appCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/app/appCount");
		return mav;
	}
	
	/**
	 * app-总访问人数
	 * @return
	 */
	@RequestMapping(value="appCountList")
	public void appCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：appCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入app-总浏览量
	 * @return
	 */
	@RequestMapping(value="appVisits")
	public ModelAndView appVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/app/appVisits");
		return mav;
	}
	
	/**
	 * app-总浏览量
	 * @return
	 */
	@RequestMapping(value="appVisitsList")
	public void appVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：appCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入app-平均访问页数
	 * @return
	 */
	@RequestMapping(value="appAvePages")
	public ModelAndView appAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController appAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/app/appAvePages");
		return mav;
	}
	
	/**
	 * app-平均访问页数
	 * @return
	 */
	@RequestMapping(value="appAvePagesList")
	public void appAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：appAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 进入新闻-总访问人数
	 * @return
	 */
	@RequestMapping(value="infoCount")
	public ModelAndView infoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/infoCount");
		return mav;
	}
	
	/**
	 * 新闻-总访问人数
	 * @return
	 */
	@RequestMapping(value="infoCountList")
	public void infoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-总浏览量
	 * @return
	 */
	@RequestMapping(value="infoVisits")
	public ModelAndView infoVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/infoVisits");
		return mav;
	}
	
	/**
	 * 新闻-总浏览量
	 * @return
	 */
	@RequestMapping(value="infoVisitsList")
	public void infoVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-平均访问页数
	 * @return
	 */
	@RequestMapping(value="infoAvePages")
	public ModelAndView infoAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController appAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/infoAvePages");
		return mav;
	}
	
	/**
	 * 新闻-平均访问页数
	 * @return
	 */
	@RequestMapping(value="infoAvePagesList")
	public void infoAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：appAvePagesList", e);
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 进入新闻-被访问新闻总篇数
	 * @return
	 */
	@RequestMapping(value="personCountPerPage")
	public ModelAndView personCountPerPage(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController personCountPerPage 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/personCountPerPage");
		return mav;
	}
	
	/**
	 * 新闻-被访问新闻总篇数
	 * @return
	 */
	@RequestMapping(value="personCountPerPageList")
	public void personCountPerPageList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.id)), 0) as timeValue from app_statistics_click c where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-新发新闻总篇数
	 * @return
	 */
	@RequestMapping(value="newPubInfoCount")
	public ModelAndView newPubInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newPubInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/newPubInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-新发新闻总篇数
	 * @return
	 */
	@RequestMapping(value="newPubInfoCountList")
	public void newPubInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
				sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报新增新闻篇数
	 * @return
	 */
	@RequestMapping(value="newComPubInfoCount")
	public ModelAndView newComPubInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newComPubInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/newComPubInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-社区报新增新闻篇数
	 * @return
	 */
	@RequestMapping(value="newComPubInfoCountList")
	public void newComPubInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where n.publisherId != 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="comVisitedInfoCount")
	public ModelAndView comVisitedInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController comVisitedInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/comVisitedInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="comVisitedInfoCountList")
	public void comVisitedInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.id)) as timeValue from app_statistics_click c left join business_news n on n.newsId = c.id and n.publisherId != 0 where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报篇均浏览人数
	 * @return
	 */
	@RequestMapping(value="comInfoAvePages")
	public ModelAndView comInfoAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController comInfoAvePages 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/comInfoAvePages");
		return mav;
	}
	
	/**
	 * 新闻-社区报篇均浏览人数
	 * @return
	 */
	@RequestMapping(value="comInfoAvePagesList")
	public void comInfoAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.id)), 0) as timeValue from app_statistics_click c left join business_news n on n.newsId = c.id and n.publisherId != 0 where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报新增新闻篇数
	 * @return
	 */
	@RequestMapping(value="newOpePubInfoCount")
	public ModelAndView newOpePubInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController newOpePubInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/newOpePubInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-社区报新增新闻篇数
	 * @return
	 */
	@RequestMapping(value="newOpePubInfoCountList")
	public void newOpePubInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(n.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from business_news n where n.publisherId != 0 and date(n.createTime) between '" + startDate + "' and '" + endDate + "' group by date(n.createTime) order by n.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="opeVisitedInfoCount")
	public ModelAndView opeVisitedInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController opeVisitedInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/opeVisitedInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="opeVisitedInfoCountList")
	public void opeVisitedInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.id)) as timeValue from app_statistics_click c left join business_news n on n.newsId = c.id and n.publisherId = 0 where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报篇均浏览人数
	 * @return
	 */
	@RequestMapping(value="opeInfoAvePages")
	public ModelAndView opeInfoAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController opeInfoAvePages 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/opeInfoAvePages");
		return mav;
	}
	
	/**
	 * 新闻-社区报篇均浏览人数
	 * @return
	 */
	@RequestMapping(value="opeInfoAvePagesList")
	public void opeInfoAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.id)), 0) as timeValue from app_statistics_click c left join business_news n on n.newsId = c.id and n.publisherId = 0 where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="visitedInfoCount")
	public ModelAndView visitedInfoCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController visitedInfoCount 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/info/visitedInfoCount");
		return mav;
	}
	
	/**
	 * 新闻-社区报新闻被访问新闻篇数
	 * @return
	 */
	@RequestMapping(value="visitedInfoCountList")
	public void visitedInfoCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.id)) as timeValue from app_statistics_click c where c.type in ('12' ,'13','14','15') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：infoCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入健康饮食-总访问人数
	 * @return
	 */
	@RequestMapping(value="dietCount")
	public ModelAndView dietCount(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/diet/dietCount");
		return mav;
	}
	
	/**
	 * 健康饮食-总访问人数
	 * @return
	 */
	@RequestMapping(value="dietCountList")
	public void dietCountList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(DISTINCT(c.userId)) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：dietCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入健康饮食-总浏览量
	 * @return
	 */
	@RequestMapping(value="dietVisits")
	public ModelAndView dietVisits(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController repair 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/diet/dietVisits");
		return mav;
	}
	
	/**
	 * 健康饮食-总浏览量
	 * @return
	 */
	@RequestMapping(value="dietVisitsList")
	public void dietVisitsList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, count(1) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：dietCountList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入健康饮食-平均访问页数
	 * @return
	 */
	@RequestMapping(value="dietAvePages")
	public ModelAndView dietAvePages(HttpServletRequest request) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入StatisPropertyController dietAvePagesList 管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/app/diet/dietAvePages");
		return mav;
	}
	
	/**
	 * 健康饮食-平均访问页数
	 * @return
	 */
	@RequestMapping(value="dietAvePagesList")
	public void dietAvePagesList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		try{
			List list = new ArrayList();
			String sql = "";
			if(startDate != null && 
					!"".equals(startDate) && 
					endDate != null && 
					!"".equals(endDate)) {
					sql = "select date_format(c.createTime, '%Y-%m-%d') as timeField, round(count(1)/count(DISTINCT(c.userId)), 0) as timeValue from app_statistics_click c where c.type in ('82' ,'83','84','85', '86') and date(c.createTime) between '" + startDate + "' and '" + endDate + "' group by date(c.createTime) order by c.createTime asc";
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
			GSLogger.error("显示modelChannel列表时发生错误：dietAvePagesList", e);
			e.printStackTrace();
		}
	}
	
}
