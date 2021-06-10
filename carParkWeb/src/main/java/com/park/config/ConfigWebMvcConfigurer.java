package com.park.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 描述
 *
 * @author Administrator
 * @version 1.0
 * @date 2021/3/20 17:05
 */
@Configuration
public class ConfigWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/upload/**","/ueditor/**").addResourceLocations("file:D:/my/upload/","file:D:/my/ueditor/");
    }
}
