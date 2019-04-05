package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.AppCategory;

import java.util.List;

/**
 * (AppCategory)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface AppCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppCategory selectById(Long id);

    /**
     * 根据父id查询分类名称
     *
     * @return 分类名称集合
     */
    List<AppCategory> selectAppCate();

    List<AppCategory> selectAppCateById(Long parentId);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AppCategory> selectAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    AppCategory insert(AppCategory appCategory);

    /**
     * 修改数据
     *
     * @param appCategory 实例对象
     * @return 实例对象
     */
    AppCategory update(AppCategory appCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}