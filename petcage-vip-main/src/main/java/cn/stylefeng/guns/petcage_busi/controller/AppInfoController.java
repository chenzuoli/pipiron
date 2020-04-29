package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 16:00
 * description: 应用信息控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class AppInfoController {
    @Autowired
    AppInfoService appInfoService;

    @RequestMapping(value = "/app_info")
    public String appInfo() {
        return "/petcage_busi/app_info/app_info.html";
    }

    @RequestMapping(value = "/app_info_list")
    @ResponseBody
    public ResultDTO appInfoList() {
        return ResultDTO.ok(appInfoService.appInfo());
    }

}
