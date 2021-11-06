package com.sza.website.vo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnluckyVo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "值日时间不能为空")
    private String time;

    @NotBlank(message = "值日人员名字不能为空")
    private String name;



}
