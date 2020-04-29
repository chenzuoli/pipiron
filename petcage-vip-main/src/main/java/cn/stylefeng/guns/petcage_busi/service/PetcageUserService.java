package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.PetcageUserRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/24 18:58
 * description: 用户服务类
 */
@Service
public class PetcageUserService {
    @Autowired
    PetcageUserRepository petcageUserRepository;

    public List<PetcageUser> getUsers() {
        return petcageUserRepository.getUsers();
    }
}
