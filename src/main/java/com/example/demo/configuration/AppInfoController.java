package com.example.demo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("api/v1/info")
public class AppInfoController {


    private final AppInfo appInfo;

    private final CompanyInfo companyInfo;
    @Autowired
    public AppInfoController(AppInfo appInfo, CompanyInfo companyInfo) {
        this.appInfo = appInfo;
        this.companyInfo = companyInfo;
    }

    @GetMapping
   List<AppInfo> getAppInfo(){

        List<AppInfo> appInfoList = new ArrayList<>();
//        app info
        AppInfo appInfo1 = new AppInfo(appInfo.getName(), appInfo.getDescription(),appInfo.getVersion());
//        company info
        AppInfo companyInfo1 = new AppInfo(companyInfo.getName(), companyInfo.getDescription(),companyInfo.getAddress());
        appInfoList.add(appInfo1);
        appInfoList.add(companyInfo1);
        return appInfoList;
    }
}
