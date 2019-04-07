package cn.bdqn.app.web.admin.controller;

import cn.bdqn.app.web.admin.service.DevUserService;
import cn.bdqn.my.app.domain.entity.DevUser;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * (DevUser)表控制层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Controller
public class DevUserController extends Base {
    /**
     * 服务对象
     */
    @Resource
    private DevUserService devUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DevUser selectOne(Long id) {
        return this.devUserService.selectById(id);
    }

    /**
     * 初始化主页
     *
     * @return 跳转至主页
     */
    @RequestMapping(value = {"", "/index"}, method = RequestMethod.GET)
    public String login() {
        return "index";
    }


    /**
     * 跳转至开发者登陆界面
     *
     * @return 目标页面
     */
    @GetMapping("/devlogin")
    public String devLogin() {
        return "devlogin";
    }


    /**
     * 用户登陆验证
     *
     * @param redirectAttributes 重定向时带参数过去
     * @return 页面跳转
     */
    @PostMapping("dologinaaa")
    public String dologinaaa(DevUser devUser,RedirectAttributes redirectAttributes) {

        // 验证码验证
        if (!checkVerification(devUser.getVerification())) {
            redirectAttributes.addFlashAttribute("error", "验证码输入错误，请重新输入！");
            return "redirect:devlogin";
        }

        DevUser user = devUserService.selectAll(devUser);
        // 判断用户输入的账户存不存在
        if (user != null) {

            // 判断用户输入的密码对不对
            String digest = DigestUtils.md5DigestAsHex(devUser.getDevPassword().getBytes());
            // 密码正确
            if (digest.equals(user.getDevPassword())) {
                session.setAttribute("devuserSession", user);
                return "/developer/main";
            }
            // 密码错误
            redirectAttributes.addFlashAttribute("error", "密码输入错误，请确认！");
            return "redirect:devlogin";
        }
        // 用户名不存在
        redirectAttributes.addFlashAttribute("error", "用户名输入错误或不存在，请确认！");
        return "redirect:devlogin";
    }

    private boolean checkVerification(String verification) {
        String fication = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        return StringUtils.equals(fication, verification);
    }

    /**
     * 注销登陆
     *
     * @return 页面跳转
     */
    @GetMapping("dev/logout")
    public String logout() {
        session.invalidate();
        return "index";
    }

}