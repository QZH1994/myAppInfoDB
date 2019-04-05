package cn.bdqn.app.web.admin.service.impl;

import cn.bdqn.app.web.admin.dao.DataDictionaryDao;
import cn.bdqn.app.web.admin.service.DataDictionaryService;
import cn.bdqn.my.app.domain.entity.DataDictionary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DataDictionary)表服务实现类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Resource
    private DataDictionaryDao dataDictionaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DataDictionary selectById(Long id) {
        
        try {
            return this.dataDictionaryDao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询app状态 所属平台
     *
     * @param typeCode 查询条件
     * @return 对象集合
     */
    @Override
    public List<DataDictionary> seleceApp(String typeCode) {

        try {
            List<DataDictionary> list = dataDictionaryDao.seleceApp(typeCode);
            if (list != null) {
                return list;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
    public List<DataDictionary> selectAllByLimit(int offset, int limit) {
        
        try {
            return this.dataDictionaryDao.selectAllByLimit(offset, limit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public DataDictionary insert(DataDictionary dataDictionary) {
        this.dataDictionaryDao.insert(dataDictionary);
        return dataDictionary;
    }

    /**
     * 修改数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    @Override
    public DataDictionary update(DataDictionary dataDictionary) {
        this.dataDictionaryDao.update(dataDictionary);
        return this.selectById(dataDictionary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.dataDictionaryDao.deleteById(id) > 0;
    }
}