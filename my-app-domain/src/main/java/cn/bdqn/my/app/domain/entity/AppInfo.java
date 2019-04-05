package cn.bdqn.my.app.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AppInfo)实体类
 *
 * @author Mr.Bug
 * @since 2019-03-29 15:48:07
 */
@Data
public class AppInfo implements Serializable {
    private static final long serialVersionUID = -18620610830601467L;
    //主键id
    private Long id;
    //软件名称
    private String softwareName;
    //APK名称（唯一）
    private String APKName;
    //支持ROM
    private String supportROM;
    //界面语言
    private String interfaceLanguage;
    //软件大小（单位：M）
    private Double softwareSize;
    //更新日期
    private Date updateDate;
    //开发者id（来源于：dev_user表的开发者id）
    private Long devId;
    //应用简介
    private String appinfo;
    //状态（来源于：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）
    private Long status;
    //上架时间
    private Date onSaleDate;
    //下架时间
    private Date offSaleDate;
    //所属平台（来源于：data_dictionary，1 手机 2 平板 3 通用）
    private Long flatformId;
    //所属三级分类（来源于：data_dictionary）
    private Long categoryLevel3;
    //下载量（单位：次）
    private Long downloads;
    //创建者（来源于dev_user开发者信息表的用户id）
    private Long createdBy;
    //创建时间
    private Date creationDate;
    //更新者（来源于dev_user开发者信息表的用户id）
    private Long modifyBy;
    //最新更新时间
    private Date modifyDate;
    //所属一级分类（来源于：data_dictionary）
    private Long categoryLevel1;
    //所属二级分类（来源于：data_dictionary）
    private Long categoryLevel2;
    //LOGO图片url路径
    private String logoPicPath;
    //LOGO图片的服务器存储路径
    private String logoLocPath;
    //最新的版本id
    private Long versionId;

    private AppCategory appCategory1;
    private AppCategory appCategory2;
    private AppCategory appCategory3;

    private DataDictionary dataDictionary1;
    private DataDictionary dataDictionary2;

    private AppVersion appVersion;

}