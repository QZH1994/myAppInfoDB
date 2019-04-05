package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.DevUserDao;
import cn.bdqn.app.web.admin.service.DevUserService;
import cn.bdqn.my.app.domain.entity.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DevUser)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {
    @Resource
    private DevUserDao devUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DevUser selectById(Long id) {
        
        try {
            return this.devUserDao.selectById(id);
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
    public List<DevUser> selectAllByLimit(int offset, int limit) {
        
        try {
            return this.devUserDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询单个用户
     *
     * @param devUser 实例对象
     * @return 对象
     */
    @Override
    public DevUser selectAll(DevUser devUser) {
        try {
            List<DevUser> users = devUserDao.selectAll(devUser);
            if (users != null) {
                return users.get(0);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public List<DevUser> selectAllUser(DevUser devUser) {
        try {
            List<DevUser> users = devUserDao.selectAll(devUser);
            if (users != null) {
                return users;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    @Override
    public DevUser insert(DevUser devUser) {
        this.devUserDao.insert(devUser);
        return devUser;
    }

    /**
     * 修改数据
     *
     * @param devUser 实例对象
     * @return 实例对象
     */
    @Override
    public DevUser update(DevUser devUser) {
        this.devUserDao.update(devUser);
        return this.selectById(devUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.devUserDao.deleteById(id) > 0;
    }
}