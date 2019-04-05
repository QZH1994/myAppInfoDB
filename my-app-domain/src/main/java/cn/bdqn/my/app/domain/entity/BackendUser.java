package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (BackendUser)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class BackendUser implements Serializable {
    private static final long serialVersionUID = -26651789728838059L;
    //主键id
    private Long id;
    //用户编码
    private String userCode;
    //用户名称
    private String userName;
    //用户角色类型（来源于数据字典表，分为：超管、财务、市场、运营、销售）
    private Long userType;
    //创建者（来源于backend_user用户表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（来源于backend_user用户表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;
    //用户密码
    private String userPassword;

}