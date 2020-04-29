package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.DimPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/25 12:38
 * description: 宠物类型、品种控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class DimPetController {
    @Autowired
    DimPetService dimPetService;

    @RequestMapping(value = "/dim_pet")
    public String index() {
        return "/petcage_busi/dim_pet/dim_pet.html";
    }

    @RequestMapping(value = "/pet/type_tree")
    @ResponseBody
    public ResultDTO petType() {
        List<String> types = dimPetService.petType();
        HashMap<String, String> tree = new HashMap<>();
        for (int i = 0; i < types.size(); i++) {
            tree.put(String.valueOf(i), types.get(i));
        }
        return ResultDTO.ok(tree);
    }

    @RequestMapping(value = "/dim_pet_list")
    @ResponseBody
    public ResultDTO dimPet() {
        return ResultDTO.ok(dimPetService.dimPet());
    }


}
