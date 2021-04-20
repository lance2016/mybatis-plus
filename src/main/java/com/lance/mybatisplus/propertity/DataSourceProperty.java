package com.lance.mybatisplus.propertity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mybatisplus  DataSourceProperty
 * @description:
 * @author: flchen
 * @create: 2021-04-13 15:53
 **/
@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperty {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
