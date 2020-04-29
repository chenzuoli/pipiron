package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.DimPetRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageDimPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/25 12:36
 * description: 宠物类型、品种服务
 */
@Service
public class DimPetService {
    @Autowired
    DimPetRepository dimPetRepository;

    public List<String> petType() {
        return dimPetRepository.petType();
    }

    public List<PetcageDimPet> dimPet() {
        return dimPetRepository.dimPet();
    }
}
