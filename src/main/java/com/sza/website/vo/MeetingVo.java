package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MeetingVo {

    /**
     * 会议id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会议名称
     */
    private String name;

    /**
     * 会议时间
     */
    @NotBlank(message = "会议时间不能为空")
    private String time;

    /**
     * 会议地址
     */
    @NotBlank(message = "会议位置不能为空")
    private String location;

    /**
     * 参会人员
     */
    private String participants;

}
