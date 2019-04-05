package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (DataDictionary)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class DataDictionary implements Serializable {
    private static final long serialVersionUID = 550695810627977421L;
    //主键ID
    private Long id;
    //类型编码
    private String typeCode;
    //类型名称
    private String typeName;
    //类型值ID
    private Long valueId;
    //类型值Name
    private String valueName;
    //创建者（来源于backend_user用户表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（来源于backend_user用户表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;

}