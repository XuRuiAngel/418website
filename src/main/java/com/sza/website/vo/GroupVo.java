package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName GroupVO.java
 * @Description TODO
 * @createTime 2021_11_06 14:32:00
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupVo {

    /**
     * 课题组id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课题组名称
     */
    private String groupName;

    /**
     * 课题组简介
     */
    private String description;

}
