package com.bawei.swagger;

import org.springframework.stereotype.Component;


@Component
public class SwaggerInfo {
    private String groupName = "controller";
    private String basePackage;
    private String antPath;
    private String title = "HTTP API";
    private String description = "管理端接口";
    private String license = "Apache License Version 2.0";

    public String getGroupName() {
        return groupName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getAntPath() {
        return antPath;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLicense() {
        return license;
    }
}
