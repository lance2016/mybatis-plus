package com.lance.mybatisplus.propertity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

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
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperty {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
