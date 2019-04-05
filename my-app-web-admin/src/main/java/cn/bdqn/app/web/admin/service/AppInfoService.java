package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.AppInfo;

import java.util.List;

/**
 * (AppInfo)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface AppInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AppInfo selectById(Long id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AppInfo> selectAllByLimit(int offset, int limit);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param appInfo 实例对象
     * @return 对象列表
     */
    List<AppInfo> selectAll(AppInfo appInfo);

    /**
     * 新增数据
     *
     * @param appInfo 实例对象
     * @return 实例对象
     */
    AppInfo insert(AppInfo appInfo);

    /**
     * 修改数据
     *
     * @param appInfo 实例对象
     * @return 实例对象
     */
    AppInfo update(AppInfo appInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 删除App
     *
     * @param appInfoId appId
     * @param logoLocPath app路径
     * @return 是否删除成功
     */
    boolean deleteAppInfo(Integer appInfoId, String logoLocPath);

}