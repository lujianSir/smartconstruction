package com.bwsk.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 图片绝对地址与虚拟地址映射
 */

@Component
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 虚拟路径配置1
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String newrootPath = System.getProperty("user.dir") + "/upload";
        newrootPath = newrootPath.replaceAll("\\\\", "/");
        // System.out.println("file:/" + newrootPath + "/模型描述/");
        registry.addResourceHandler("/image/user/**").addResourceLocations("file:/" + newrootPath + "/user/");

        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
