package cn.bdqn.app.web.admin.controller;

import cn.bdqn.app.web.admin.service.AppCategoryService;
import cn.bdqn.app.web.admin.service.AppInfoService;
import cn.bdqn.app.web.admin.service.AppVersionService;
import cn.bdqn.app.web.admin.service.DataDictionaryService;
import cn.bdqn.my.app.domain.entity.AppCategory;
import cn.bdqn.my.app.domain.entity.AppInfo;
import cn.bdqn.my.app.domain.entity.DataDictionary;
import cn.bdqn.my.app.domain.entity.InfoList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AppInfo)表控制层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Controller
@RequestMapping("developer")
public class AppInfoController {
    /**
     * 服务对象
     */
    @Resource
    private AppInfoService appInfoService;

    @Resource
    private DataDictionaryService dataDictionaryService;

    @Resource
    private AppCategoryService appCategoryService;

    @Resource
    private AppVersionService appVersionService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AppInfo selectOne(Long id) {
        return this.appInfoService.selectById(id);
    }


    /**
     * 开发者应用管理列表
     *
     * @param model 视图
     * @return 页面跳转
     */
    @RequestMapping("/appinfo/list")
    public String appInfoList(InfoList infoList, Model model) {

        AppInfo appInfo = new AppInfo();
        // 添加 软件名称
        appInfo.setSoftwareName(infoList.getQuerySoftwareName());
        // 添加 app状态 id
        if (infoList.getQueryStatus() != null) {
            appInfo.setStatus(infoList.getQueryStatus().longValue());
            model.addAttribute("queryStatus", infoList.getQueryStatus().longValue());
        }
        // 添加 所属平台 id
        if (infoList.getQueryFlatformId() != null) {
            appInfo.setFlatformId(infoList.getQueryFlatformId().longValue());
            model.addAttribute("queryFlatformId", infoList.getQueryFlatformId().longValue());
        }
        // 一级菜单
        if (infoList.getQueryCategoryLevel1() != null) {
            appInfo.setCategoryLevel1(infoList.getQueryCategoryLevel1().longValue());
            model.addAttribute("queryCategoryLevel1", infoList.getQueryCategoryLevel1().longValue());
        }
        // 二级菜单
        if (infoList.getQueryCategoryLevel2() != null) {
            appInfo.setCategoryLevel2(infoList.getQueryCategoryLevel2().longValue());
            model.addAttribute("queryCategoryLevel2", infoList.getQueryCategoryLevel2().longValue());
        }
        // 三级菜单
        if (infoList.getQueryCategoryLevel3() != null) {
            appInfo.setCategoryLevel3(infoList.getQueryCategoryLevel3().longValue());
            model.addAttribute("queryCategoryLevel3", infoList.getQueryCategoryLevel3().longValue());
        }

        // 分页操作 Lambda表达式
        PageInfo<AppInfo> pageInfo = PageHelper.startPage(infoList.getPageIndex(), 5).doSelectPageInfo(() -> appInfoService.selectAll(appInfo));

        // 查询 APP状态 具体信息
        List<DataDictionary> statusList = dataDictionaryService.seleceApp("APP_STATUS");
        // 查询 所属平台 具体信息
        List<DataDictionary> flatFormList = dataDictionaryService.seleceApp("APP_FLATFORM");

        List<AppCategory> categoryLevel1List = appCategoryService.selectAppCate();

        model.addAttribute("appInfoList", pageInfo);
        model.addAttribute("querySoftwareName", infoList.getQuerySoftwareName());
        model.addAttribute("statusList", statusList);
        model.addAttribute("flatFormList", flatFormList);
        model.addAttribute("categoryLevel1List", categoryLevel1List);

        PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
        return "developer/appinfolist";

    }


    /**
     * ajax 请求 获取二三级菜单
     *
     * @param parentId 二三级菜单id
     * @return 返回JSON数据
     */
    @RequestMapping("/appinfo/getClassification")
    @ResponseBody
    public Object getClassification(Integer parentId) {
        return appCategoryService.selectAppCateById(parentId.longValue());
    }


    /**
     * 删除app全部信息
     *
     * @param appInfoId   appId
     * @param logoLocPath app头像路径
     * @return 是否删除成功
     */
    @RequestMapping("/appinfo/deleteApp")
    @ResponseBody
    public String deleteApp(Integer appInfoId, String logoLocPath) {

        // System.out.println(appInfoId);
        // System.out.println(logoLocPath);

        try {
            appInfoService.deleteAppInfo(appInfoId, logoLocPath);
            return "1";
        } catch (Exception e) {
            // e.printStackTrace();
            return "0";
        }
    }
}