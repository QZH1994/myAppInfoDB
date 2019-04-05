package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.AppInfoDao;
import cn.bdqn.app.web.admin.dao.AppVersionDao;
import cn.bdqn.app.web.admin.exception.DivException;
import cn.bdqn.app.web.admin.service.AppInfoService;
import cn.bdqn.my.app.domain.entity.AppInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * (AppInfo)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoDao appInfoDao;

    @Resource
    private AppVersionDao appVersionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AppInfo selectById(Long id) {

        try {
            return this.appInfoDao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<AppInfo> selectAllByLimit(int offset, int limit) {

        try {
            return this.appInfoDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param appInfo 实例对象
     * @return 对象列表
     */
    @Override
    public List<AppInfo> selectAll(AppInfo appInfo) {
        try {
            List<AppInfo> infos = appInfoDao.selectAll(appInfo);
            if (infos != null) {
                return infos;
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
     * @param appInfo 实例对象
     * @return 实例对象
     */
    @Override
    public AppInfo insert(AppInfo appInfo) {
        this.appInfoDao.insert(appInfo);
        return appInfo;
    }

    /**
     * 修改数据
     *
     * @param appInfo 实例对象
     * @return 实例对象
     */
    @Override
    public AppInfo update(AppInfo appInfo) {
        this.appInfoDao.update(appInfo);
        return this.selectById(appInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.appInfoDao.deleteById(id) > 0;
    }

    /**
     * 删除app信息
     *
     * @param appInfoId   appId
     * @param logoLocPath app路径
     * @return 删除是否成功
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean deleteAppInfo(Integer appInfoId, String logoLocPath) {
        // 获取app头像绝对路径
        File file = new File(logoLocPath);
        // 执行删除操作
        boolean delete = file.delete();

        // 删除app版本信息
        int appVersion = appVersionDao.deleteById(appInfoId.longValue());
        // 删除app全部信息
        int appInfo = appInfoDao.deleteById(appInfoId.longValue());

        // System.out.println(delete);
        // System.out.println(appVersion);
        // System.out.println(appInfo);

        // 判断是否全部删除成功
        if (appInfo > 0 && appVersion > 0 && delete) {
            return true;
        }
        // 当删除失败时，回滚事务
        throw new DivException("app删除失败！");
    }
}