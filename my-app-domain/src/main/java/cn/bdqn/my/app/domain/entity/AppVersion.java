package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AppVersion)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class AppVersion implements Serializable {
    private static final long serialVersionUID = -99417614662316187L;
    //主键id
    private Long id;
    //appId（来源于：app_info表的主键id）
    private Long appId;
    //版本号
    private String versionNo;
    //版本介绍
    private String versionInfo;
    //发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
    private Long publishStatus;
    //下载链接
    private String downloadLink;
    //版本大小（单位：M）
    private Double versionSize;
    //创建者（来源于dev_user开发者信息表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（来源于dev_user开发者信息表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;
    //apk文件的服务器存储路径
    private String apkLocPath;
    //上传的apk文件名称
    private String apkFileName;

}