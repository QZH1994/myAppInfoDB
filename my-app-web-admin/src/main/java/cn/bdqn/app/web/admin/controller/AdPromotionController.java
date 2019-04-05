package cn.bdqn.app.web.admin.controller;

import cn.bdqn.app.web.admin.service.AdPromotionService;
import cn.bdqn.my.app.domain.entity.AdPromotion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (AdPromotion)表控制层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@RestController
@RequestMapping("adPromotion")
public class AdPromotionController {
    /**
     * 服务对象
     */
    @Resource
    private AdPromotionService adPromotionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AdPromotion selectOne(Long id) {
        return this.adPromotionService.selectById(id);
    }

}