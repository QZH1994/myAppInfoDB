package cn.bdqn.app.web.admin.service.impl;


import cn.bdqn.app.web.admin.dao.AdPromotionDao;
import cn.bdqn.app.web.admin.service.AdPromotionService;
import cn.bdqn.my.app.domain.entity.AdPromotion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AdPromotion)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("adPromotionService")
public class AdPromotionServiceImpl implements AdPromotionService {
    @Resource
    private AdPromotionDao adPromotionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AdPromotion selectById(Long id) {
        
        try {
            return this.adPromotionDao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AdPromotion> selectAllByLimit(int offset, int limit) {
        
        try {
            return this.adPromotionDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param adPromotion 实例对象
     * @return 实例对象
     */
    @Override
    public AdPromotion insert(AdPromotion adPromotion) {
        this.adPromotionDao.insert(adPromotion);
        return adPromotion;
    }

    /**
     * 修改数据
     *
     * @param adPromotion 实例对象
     * @return 实例对象
     */
    @Override
    public AdPromotion update(AdPromotion adPromotion) {
        this.adPromotionDao.update(adPromotion);
        return this.selectById(adPromotion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.adPromotionDao.deleteById(id) > 0;
    }
}