package cn.bdqn.app.web.admin.service;


import cn.bdqn.my.app.domain.entity.DataDictionary;

import java.util.List;

/**
 * (DataDictionary)表服务接口
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface DataDictionaryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataDictionary selectById(Long id);

    /**
     * 查询app状态 所属平台
     *
     * @param typeCode 条件
     * @return 对象集合
     */
    List<DataDictionary> seleceApp(String typeCode);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataDictionary> selectAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    DataDictionary insert(DataDictionary dataDictionary);

    /**
     * 修改数据
     *
     * @param dataDictionary 实例对象
     * @return 实例对象
     */
    DataDictionary update(DataDictionary dataDictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}