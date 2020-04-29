package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 16:16
 * description: 故障类型控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class DamageTypeController {

    @Autowired
    DamageTypeService damageTypeService;

    @RequestMapping(value = "/damage_type")
    public String damageType() {
        return "/petcage_busi/damage_type/damage_type.html";
    }

    @RequestMapping(value = "/damage_type_list")
    @ResponseBody
    public ResultDTO damageTypeList() {
        return ResultDTO.ok(damageTypeService.damageType());
    }
}
