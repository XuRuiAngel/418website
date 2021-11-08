package com.sza.website.strategy.context;

import static com.sza.website.enums.UploadModeEnum.getStrategy;
import com.sza.website.strategy.impl.AbstractUploadStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author hzw
 * @version 1.0.0
 * @ClassName UploadStrategyContext.java
 * @Description 上传策略上下文
 * @createTime 2021_11_08 18:15:00
 */
@Service
public class UploadStrategyContext {

    /**
     * 上传模式
     */
    @Value("${upload.mode}")
    private String uploadMode;

    /**
     * 所有实现UploadStrategy接口的bean对象组成的map，key值为类名(首字母小写)
     */
    @Autowired
    private Map<String, AbstractUploadStrategyImpl> uploadStrategyMap;

    public String executeUploadStrategy(MultipartFile file, String path) {

        System.out.println(file);
        return uploadStrategyMap.get(getStrategy(uploadMode)).uploadFile(file, path);

    }

}
