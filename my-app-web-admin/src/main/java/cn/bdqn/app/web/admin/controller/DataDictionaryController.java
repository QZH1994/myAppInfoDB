package cn.bdqn.app.web.admin.controller;

import cn.bdqn.app.web.admin.service.DataDictionaryService;
import cn.bdqn.my.app.domain.entity.DataDictionary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (DataDictionary)表控制层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@RestController
@RequestMapping("dataDictionary")
public class DataDictionaryController {
    /**
     * 服务对象
     */
    @Resource
    private DataDictionaryService dataDictionaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DataDictionary selectOne(Long id) {
        return this.dataDictionaryService.selectById(id);
    }

}