package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.DamageTypeRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageDamageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:15
 * description: 故障类型服务类
 */
@Service
public class DamageTypeService {

    @Autowired
    DamageTypeRepository damageTypeRepository;

    public List<PetcageDamageType> damageType() {
        return damageTypeRepository.damageType();
    }
}
