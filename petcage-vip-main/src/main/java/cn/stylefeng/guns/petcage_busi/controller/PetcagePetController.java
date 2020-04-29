package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.entity.PetcagePet;
import cn.stylefeng.guns.petcage_busi.service.PetcagePetService;
import cn.stylefeng.roses.kernel.model.response.SuccessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/25 09:07
 * description: 宠物控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class PetcagePetController {
    @Autowired
    PetcagePetService petcagePetService;

    @RequestMapping(value = "/pet")
    public String index() {
        return "/petcage_busi/pet/pet.html";
    }

    @RequestMapping(value = "/pet_list")
    @ResponseBody
    public ResultDTO getPets() {
        return ResultDTO.ok(petcagePetService.getPets());
    }

    @RequestMapping(value = "/pet_edit")
    public String edit() {
        return "/petcage_busi/pet/pet_edit.html";
    }

    @RequestMapping(value = "/pet_detail")
    @ResponseBody
    public SuccessResponseData editPet(@RequestParam("id") String id) {
        return new SuccessResponseData(petcagePetService.petDetail(id));
    }

    @RequestMapping(value = "/pet/edit")
    @ResponseBody
    public ResultDTO editPet(PetcagePet pet) {
        System.out.println(">>>>>>>edit pet info: " + pet);
        int result = petcagePetService.editPet(pet);
        if (result > 0) {
            return ResultDTO.ok(result);
        } else {
            return ResultDTO.fail("更新失败");
        }
    }

    @RequestMapping(value = "/pet/delete")
    @ResponseBody
    public ResultDTO deletePet(@RequestParam("id") String id) {
        int result = petcagePetService.deletePet(id);
        if (result > 0) {
            return ResultDTO.ok(result);
        } else {
            return ResultDTO.fail("删除失败");
        }
    }
}
