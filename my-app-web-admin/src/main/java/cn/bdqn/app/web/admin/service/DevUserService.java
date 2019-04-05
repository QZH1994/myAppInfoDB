package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.DevUser;

import java.util.List;

/**
 * (DevUser)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface DevUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DevUser selectById(Long id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DevUser> selectAllByLimit(int offset, int limit);

    /**
     * 查询单个用户
     *
     * @param devUser 实例对象
     * @return 对象
     */
    DevUser selectAll(DevUser devUser);

    List<DevUser> selectAllUser(DevUser devUser);

    /**
     * 新增数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    DevUser insert(DevUser devUser);

    /**
     * 修改数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    DevUser update(DevUser devUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}