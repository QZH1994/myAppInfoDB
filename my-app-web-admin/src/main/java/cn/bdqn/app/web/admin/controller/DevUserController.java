package cn.bdqn.app.web.admin.controller;

import cn.bdqn.app.web.admin.service.DevUserService;
import cn.bdqn.my.app.domain.entity.DevUser;
import org.springframework.stereotype.Controller;
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
     * @param devCode            开发者账号
     * @param devPassword        开发者密码
     * @param redirectAttributes 重定向时带参数过去
     * @return 页面跳转
     */
    @PostMapping("dologinaaa")
    public String dologinaaa(@RequestParam(value = "devCode", required = true) String devCode,
                             @RequestParam(value = "devPassword") String devPassword, RedirectAttributes redirectAttributes) {
        DevUser devUser = new DevUser();
        devUser.setDevCode(devCode);
        devUser.setDevPassword(devPassword);
        DevUser user = devUserService.selectAll(devUser);
        if (user != null) {
            session.setAttribute("devuserSession", user);
            return "/developer/main";
        }
        redirectAttributes.addFlashAttribute("error", "用户名或密码错误，请确认！");
        return "redirect:devlogin";
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