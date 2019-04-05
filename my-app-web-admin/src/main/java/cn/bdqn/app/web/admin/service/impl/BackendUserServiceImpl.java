package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.BackendUserDao;
import cn.bdqn.app.web.admin.service.BackendUserService;
import cn.bdqn.my.app.domain.entity.BackendUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BackendUser)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("backendUserService")
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    private BackendUserDao backendUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BackendUser selectById(Long id) {
        
        try {
            return this.backendUserDao.selectById(id);
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
    public List<BackendUser> selectAllByLimit(int offset, int limit) {
        
        try {
            return this.backendUserDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    @Override
    public BackendUser insert(BackendUser backendUser) {
        this.backendUserDao.insert(backendUser);
        return backendUser;
    }

    /**
     * 修改数据
     *
     * @param backendUser 实例对象
     * @return 实例对象
     */
    @Override
    public BackendUser update(BackendUser backendUser) {
        this.backendUserDao.update(backendUser);
        return this.selectById(backendUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.backendUserDao.deleteById(id) > 0;
    }
}