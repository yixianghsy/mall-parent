package com.e3mall.mansger.service.confg;

import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DubboConfig {
    @Bean
    public MetadataReportConfig metadataReportConfig() {
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://39.104.87.118:2181");
        return metadataReportConfig;
    }
}
