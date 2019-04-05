package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.AppVersionDao;
import cn.bdqn.app.web.admin.service.AppVersionService;
import cn.bdqn.my.app.domain.entity.AppVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AppVersion)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("appVersionService")
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionDao appVersionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppVersion selectById(Long id) {
        
        try {
            return this.appVersionDao.selectById(id);
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
    public List<AppVersion> selectAllByLimit(int offset, int limit) {
        
        try {
            return this.appVersionDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    @Override
    public AppVersion insert(AppVersion appVersion) {
        this.appVersionDao.insert(appVersion);
        return appVersion;
    }

    /**
     * 修改数据
     *
     * @param appVersion 实例对象
     * @return 实例对象
     */
    @Override
    public AppVersion update(AppVersion appVersion) {
        this.appVersionDao.update(appVersion);
        return this.selectById(appVersion.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appVersionDao.deleteById(id) > 0;
    }
}