package cn.bdqn.app.web.admin.dao;


import cn.bdqn.my.app.domain.entity.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (AppInfo)表数据库访问层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface AppInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppInfo selectById(Long id) throws Exception;

    /**
     * 查询总条数
     *
     * @return 实例对象
     */
    AppInfo selectPageContext() throws Exception;
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AppInfo> selectAllByLimit(@Param("offset") int offset, @Param("limit") int limit) throws Exception;

    /**
     * 通过实体作为筛选条件进行模糊查询
     *
     * @param appInfo 实例对象
     * @return 对象列表
     */
    List<AppInfo> selectAllFuzzy(AppInfo appInfo) throws Exception;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param appInfo 实例对象
     * @return 对象列表
     */
    List<AppInfo> selectAll(AppInfo appInfo) throws Exception;

    /**
     * 新增数据
     *
     * @param appInfo 实例对象
     * @return 影响行数
     */
    int insert(AppInfo appInfo);

    /**
     * 修改数据
     *
     * @param appInfo 实例对象
     * @return 影响行数
     */
    int update(AppInfo appInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}