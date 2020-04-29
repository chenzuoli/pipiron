package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 17:19
 * description: 用户类型控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class UserTypeController {
    @Autowired
    UserTypeService userTypeService;

    @RequestMapping(value = "/user_type")
    public String index() {
        return "/petcage_busi/user_type/user_type.html";
    }

    @RequestMapping(value = "/user_type_list")
    @ResponseBody
    public ResultDTO userType() {
        return ResultDTO.ok(userTypeService.userType());
    }
}
