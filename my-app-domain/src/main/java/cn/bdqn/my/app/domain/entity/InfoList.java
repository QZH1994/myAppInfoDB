package cn.bdqn.my.app.domain.entity;

import lombok.Data;

/**
 * @author Mr.Bug
 * @version 1.0
 * @date 2019/4/3 16:51
 * @since 1.8
 */
@Data
public class InfoList {

    // 当前页 默认值1
    private Integer pageIndex = 1;
    // 软件名称
    private String querySoftwareName;
    // app状态 id
    private Integer queryStatus;
    // 所属平台 id
    private Integer queryFlatformId;
    // 一级菜单
    private Integer queryCategoryLevel1;
    // 二级菜单
    private Integer queryCategoryLevel2;
    // 三级菜单
    private Integer queryCategoryLevel3;

}
