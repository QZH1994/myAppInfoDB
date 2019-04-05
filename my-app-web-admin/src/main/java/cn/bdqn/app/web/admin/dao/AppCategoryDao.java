package cn.bdqn.app.web.admin.dao;


import cn.bdqn.my.app.domain.entity.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AppCategory)表数据库访问层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface AppCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppCategory selectById(Long id) throws Exception;

    /**
     * 查询总条数
     *
     * @return 实例对象
     */
    AppCategory selectPageContext() throws Exception;

    /**
     * 根据父id查询分类名称
     *
     * @return 分类名称集合
     * @throws Exception 异常
     */
    List<AppCategory> selectAppCate() throws Exception;


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AppCategory> selectAllByLimit(@Param("offset") int offset, @Param("limit") int limit) throws Exception;

    /**
     * 通过实体作为筛选条件进行模糊查询
     *
     * @param appCategory 实例对象
     * @return 对象列表
     */
    List<AppCategory> selectAllFuzzy(AppCategory appCategory) throws Exception;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param appCategory 实例对象
     * @return 对象列表
     */
    List<AppCategory> selectAll(AppCategory appCategory) throws Exception;

    /**
     * 新增数据
     *
     * @param appCategory 实例对象
     * @return 影响行数
     */
    int insert(AppCategory appCategory);

    /**
     * 修改数据
     *
     * @param appCategory 实例对象
     * @return 影响行数
     */
    int update(AppCategory appCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}