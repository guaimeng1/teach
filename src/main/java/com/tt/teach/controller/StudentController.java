package com.tt.teach.controller;

import com.tt.teach.pojo.Student;
import com.tt.teach.service.StudentService;
import com.tt.teach.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/stu")
public class StudentController extends BaseController{
    @Resource
    private StudentService studentService;
    @RequestMapping("/login")
    public String login() {
        return "/student/login";
    }
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin() {
        String xuehao=getRequest().getParameter("studentNo");
        Integer studentNo=Integer.parseInt(xuehao);
        String loginPwd=getRequest().getParameter("loginPwd");
        Student student=new Student();
        student.setStudentNo(studentNo);
        student.setLoginPwd(loginPwd);
        Student student1=studentService.doLogin(student);
        if (student1!=null){
            getSession().setAttribute("studentName",student1.getStudentName());
             return FORWARD+"/stu/index";
        }
        return REDIRECT+"/stu/login";
    }
    @RequestMapping("/index")
    public String index() {
        String studentName= (String) getSession().getAttribute(SESSION_KEY);
        if (studentName!=null){
          return "student/index";
        }
        return REDIRECT+"/stu/login";

    }

    @RequestMapping("/logout")
    public String logout() {
        getSession().getAttribute(SESSION_KEY);
        return REDIRECT+"/stu/login";
    }
}
