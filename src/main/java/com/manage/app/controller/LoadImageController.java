package com.manage.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.utis.ImageUtil;






@Controller
@RequestMapping("/manage/loadImage")
public class LoadImageController {
	
	
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
		}
		ModelAndView mav = new ModelAndView("/business/businessUser/enter");
		return mav;
	}
	/** 
     * <b>商品上传指定的图片</b> 
     *  
     * @param request 
     * @param response 
     * @param command 
     * @return 
     * @throws Exception 
     */  
	@RequestMapping(value="uploadFile")
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response,LoadImageController command) throws Exception {  
        PrintWriter writer = null;  
        try {  
            response.setContentType("application/json; charset=GBK");  
            writer = response.getWriter();   
  
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;  
            String source = request.getSession().getServletContext().getRealPath("/");  
            // 获得第1张图片（根据前台的name名称得到上传的文件）  
            MultipartFile imgFile1 = multipartRequest.getFile("itemPic");  
            // 判断是否是重复上传图片（如果重复将删除旧图片）  
            String sourceImg = request.getParameter("path");  
            if (imgFile1.getContentType().split("/")[0].equals("image")) {  
                if (null != sourceImg && !"".equals(sourceImg)) {  
                    System.out.println("旧图片路径:" + sourceImg);  
                    File f = new File(source + sourceImg);  
                    if (f.isFile()) {  
                        f.delete();  
                        System.out.println(" 删除成功");  
                    } else  
                        System.out.println(" 删除失败!");  
                }  
                String path = null;  
                if (imgFile1 != null && imgFile1.getSize() > 0) {  
                    path = storeFile(request.getSession(), imgFile1);  
                }  
                writer.print("{\"message\":\"success\",\"path\":\"" + path.replace("\\", "\\\\") + "\"}");  
            } else  
                writer.print("{\"message\":\"error\"}");  
        } catch (Exception e) {  
            // TODO: handle exception  
            writer.print("{\"message\":\"no\"}");  
        }  
        writer.flush();  
        writer.close();  
        return null;   
    }  
  
	
    public String storeFile(HttpSession session, MultipartFile file) throws Exception {  
        // TODO Auto-generated method stub  
        String fileType = file.getContentType().split("/")[1];  
        String path = session.getServletContext().getRealPath("/");  
        String separator = File.separator;  
        String uuid = UUID.randomUUID().toString();  
        FileOutputStream fos = null;  
        String fileName = null;  
        try {  
            InputStream fis = file.getInputStream();  
            // 转换文件为png格式，并保存在同名目录下  
            File files = new File(path + "\\dishpic");  
            // 判断文件夹是否存在,如果不存在则创建文件夹  
            if (!files.exists()) {  
                files.mkdir();  
            }  
            if (file.getContentType().split("/")[0].equals("image")) {  
                if (path.endsWith(separator))  
                    fileName = path + "dishpic" + separator + uuid + ".png";  
                else  
                    fileName = path + separator + "dishpic" + separator + uuid + ".png";  
                fos = new FileOutputStream(fileName);  
                ImageUtil.convertFormat(fis, fos, fileType, "png", 0, 0);  
                fos.flush();  
                fos.close();  
            }  
        } catch (Exception ex) {  
            System.out.println("文件取出失败，错误信息: " + ex.getMessage());  
            if (fos != null)  
                fos.close();  
            throw ex;  
        }  
        return "dishpic" + separator + uuid + ".png";  
    }  
      
	
}
