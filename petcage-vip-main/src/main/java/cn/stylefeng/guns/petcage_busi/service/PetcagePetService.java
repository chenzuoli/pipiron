package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.PetcagePetRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcagePet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/25 09:13
 * description: 宠物服务
 */
@Service
public class PetcagePetService {
    @Autowired
    PetcagePetRepository petcagePetRepository;

    public List<PetcagePet> getPets() {
        return petcagePetRepository.getPets();
    }

    public int editPet(PetcagePet petcagePet) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curr_time = simpleDateFormat.format(new Date(System.currentTimeMillis()));
        return petcagePetRepository.editPet(String.valueOf(petcagePet.getId()),
                petcagePet.getContact(),
                petcagePet.getPet_type(),
                petcagePet.getVariety(),
                petcagePet.getNick_name(),
                petcagePet.getGender(),
                petcagePet.getBirthday(),
                petcagePet.getDescription(),
                curr_time);
    }

    public PetcagePet petDetail(String id) {
        return petcagePetRepository.petDetail(id);
    }

    public int deletePet(String id) {
        return petcagePetRepository.deletePet(id);
    }
}
