package com.jwxt.service.Verification;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author me@nitmali.com
 * @date 2018/6/7 15:23
 */
@ConfigurationProperties(prefix = "verification")
@Service
@Data
public class VerificationConfig {

    private String cachingPath = "caching-path";

    private String errorCachingPath = "error-caching-path";

    private String targetTrainFilePath = "src/main/resources/static/verification/targetTrain.png";

    private String targetPath = "src/main/resources/static/verification/caching";
}
