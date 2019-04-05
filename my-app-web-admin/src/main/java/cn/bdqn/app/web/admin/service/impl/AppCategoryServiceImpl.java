package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.AppCategoryDao;
import cn.bdqn.app.web.admin.service.AppCategoryService;
import cn.bdqn.my.app.domain.entity.AppCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AppCategory)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {
    @Resource
    private AppCategoryDao appCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppCategory selectById(Long id) {

        try {
            return this.appCategoryDao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据父id查询分类名称
     *
     * @return 分类名称集合
     */
    @Override
    public List<AppCategory> selectAppCate() {
        try {
                return appCategoryDao.selectAppCate();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AppCategory> selectAppCateById(Long parentId) {
        try {
            AppCategory appCategory = new AppCategory();
            if (parentId != null) {
                appCategory.setParentId(parentId);
            }

            return appCategoryDao.selectAllFuzzy(appCategory);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AppCategory> selectAllByLimit(int offset, int limit) {

        try {
            return this.appCategoryDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    @Override
    public AppCategory insert(AppCategory appCategory) {
        this.appCategoryDao.insert(appCategory);
        return appCategory;
    }

    /**
     * 修改数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    @Override
    public AppCategory update(AppCategory appCategory) {
        this.appCategoryDao.update(appCategory);
        return this.selectById(appCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appCategoryDao.deleteById(id) > 0;
    }
}