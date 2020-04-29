package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.AppInfoRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageAppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 15:59
 * description: 应用信息服务
 */
@Service
public class AppInfoService {
    @Autowired
    AppInfoRepository appInfoRepository;

    public List<PetcageAppInfo> appInfo() {
        return appInfoRepository.appInfo();
    }
}
