package cn.bdqn.app.web.admin.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mr.Bug
 * @version 1.0
 * @date 2019/3/29 9:51
 * @since 1.8
 */
public class Base {
    public HttpSession session;
    public HttpServletRequest request;
    public HttpServletResponse response;

    @ModelAttribute
    public void initServletAPI(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        this.session = session;
        this.request = request;
        this.response = response;
    }

    /**
     * 使用'@InitBinder'解决SpringMVC日期类型无法绑定的问题
     * 自动格式化日期  String -> Date
     *
     * @param dataBinder  自定义编辑器
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));

    }
}
