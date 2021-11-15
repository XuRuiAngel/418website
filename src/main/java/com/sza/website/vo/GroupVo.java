package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName GroupVO.java
 * @Description 课题组前端连接类
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
    @NotBlank(message = "课题组名称不能为空")
    private String groupName;

    /**
     * 课题组简介
     */
    @NotBlank(message = "课题组简介不能为空")
    private String description;

}
