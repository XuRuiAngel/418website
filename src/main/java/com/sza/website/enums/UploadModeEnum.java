package com.sza.website.enums;

import com.sza.website.strategy.UploadStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName UploadModeEnum.java
 * @Description TODO
 * @createTime 2021_11_08 19:07:00
 */
@Getter
@AllArgsConstructor
public enum UploadModeEnum {

    /**
     * 本地
     */
    LOCAL("local", "localUploadStrategyImpl");

    /**
     * 模式
     */
    private final String mode;

    /**
     * 策略
     */
    private final String strategy;

    /**
     * 获取策略
     *
     * @param mode 模式
     * @return 上传策略
     */
    public static String getStrategy(String mode) {
        for (UploadModeEnum value : UploadModeEnum.values()) {
            if (value.getMode().equals(mode)) {
                return value.getStrategy();
            }
        }
        return null;
    }

}
