package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 16:33
 * description: 设备控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/device")
    public String index() {
        return "/petcage_busi/device/device.html";
    }

    @RequestMapping(value = "/device_list")
    @ResponseBody
    public ResultDTO device() {
        return ResultDTO.ok(deviceService.device());
    }
}
