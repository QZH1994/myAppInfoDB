package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (DevUser)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class DevUser implements Serializable {
    private static final long serialVersionUID = 821535885109075261L;
    //主键id
    private Long id;
    //开发者帐号
    private String devCode;
    //开发者名称
    private String devName;
    //开发者密码
    private String devPassword;
    //开发者电子邮箱
    private String devEmail;
    //开发者简介
    private String devInfo;
    //创建者（来源于backend_user用户表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（来源于backend_user用户表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;
    // 验证码
    private String verification;

}