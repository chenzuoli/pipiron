package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.PetcageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/24 18:53
 * description: 用户控制器
 */
@Controller
@RequestMapping("/petcage")
public class PetcageUserController {
    @Autowired
    PetcageUserService petcageUserService;

    @RequestMapping(value = "/user")
    public String index() {
        return "/petcage_busi/user/user.html";
    }

    @RequestMapping(value = "/user_list")
    @ResponseBody
    public ResultDTO getUsers() {
        return ResultDTO.ok(petcageUserService.getUsers());
    }
}
