package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.UserTypeRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 17:18
 * description: 用户类型服务
 */
@Service
public class UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    public List<PetcageUserType> userType() {
        return userTypeRepository.userType();
    }
}
