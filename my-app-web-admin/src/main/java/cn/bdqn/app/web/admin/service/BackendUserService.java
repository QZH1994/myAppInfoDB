package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.BackendUser;

import java.util.List;

/**
 * (BackendUser)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface BackendUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BackendUser selectById(Long id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BackendUser> selectAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    BackendUser insert(BackendUser backendUser);

    /**
     * 修改数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    BackendUser update(BackendUser backendUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}