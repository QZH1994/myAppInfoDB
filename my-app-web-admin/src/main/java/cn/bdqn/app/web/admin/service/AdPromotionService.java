package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.AdPromotion;

import java.util.List;

/**
 * (AdPromotion)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface AdPromotionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AdPromotion selectById(Long id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AdPromotion> selectAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param adPromotion 实例对象
     * @return 实例对象
     */
    AdPromotion insert(AdPromotion adPromotion);

    /**
     * 修改数据
     *
     * @param adPromotion 实例对象
     * @return 实例对象
     */
    AdPromotion update(AdPromotion adPromotion);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}