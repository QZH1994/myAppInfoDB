package cn.bdqn.app.web.admin.dao;

import cn.bdqn.my.app.domain.entity.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (DataDictionary)表数据库访问层
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
public interface DataDictionaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DataDictionary selectById(Long id) throws Exception;

    /**
     * 查询app状态 所属平台
     *
     * @param typeCode 条件
     * @return 对象集合
     * @throws Exception 异常
     */
    List<DataDictionary> seleceApp(@Param("typeCode") String typeCode) throws Exception;

    /**
     * 查询总条数
     *
     * @return 实例对象
     */
    DataDictionary selectPageContext() throws Exception;
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DataDictionary> selectAllByLimit(@Param("offset") int offset, @Param("limit") int limit) throws Exception;

    /**
     * 通过实体作为筛选条件进行模糊查询
     *
     * @param dataDictionary 实例对象
     * @return 对象列表
     */
    List<DataDictionary> selectAllFuzzy(DataDictionary dataDictionary) throws Exception;

    /**
     * 通过实体作为筛选条件查询
     *
     * @param dataDictionary 实例对象
     * @return 对象列表
     */
    List<DataDictionary> selectAll(DataDictionary dataDictionary) throws Exception;

    /**
     * 新增数据
     *
     * @param dataDictionary 实例对象
     * @return 影响行数
     */
    int insert(DataDictionary dataDictionary);

    /**
     * 修改数据
     *
     * @param dataDictionary 实例对象
     * @return 影响行数
     */
    int update(DataDictionary dataDictionary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}