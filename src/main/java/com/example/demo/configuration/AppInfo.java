package com.example.demo.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "info.app")
public class AppInfo {
    private String name;
    private String description;
    private String version;

    public AppInfo() {
    }

    public AppInfo(String name, String description, String version) {
        this.name = name;
        this.description = description;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public String getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
