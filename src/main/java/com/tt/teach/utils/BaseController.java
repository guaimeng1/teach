package com.tt.teach.utils;


import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * #作者：zhangshuai
 * #时间：2018/12/19 11:24
 * #描述：控制器的工具类
*/
public class BaseController {
    //1.日志打印管理
     private static final Logger logger= LoggerFactory.getLogger(BaseController.class);
    //2.常用变量提取出来，放到base变成静态常量，方便使用
    protected static final String SESSION_KEY="studentName";
    protected static final String FORWARD="redirect:";
    protected static final String REDIRECT="redirect:";
    //3.常用request、response、session
    public HttpServletRequest getRequest() {
        HttpServletRequest request= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    public HttpServletResponse getResponse() {
        HttpServletResponse response= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }
    public HttpSession getSession() {
        HttpSession session= getRequest().getSession();
        return session;
    }

}
