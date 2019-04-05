package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AppCategory)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class AppCategory implements Serializable {
    private static final long serialVersionUID = -63200630962866931L;
    //主键ID
    private Long id;
    //分类编码
    private String categoryCode;
    //分类名称
    private String categoryName;
    //父级节点id
    private Long parentId;
    //创建者（来源于backend_user用户表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationTime;
    //更新者（来源于backend_user用户表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;

}