package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.DeviceRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:31
 * description: 设备服务
 */
@Service
public class DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    public List<PetcageDevice> device() {
        return deviceRepository.device();
    }
}
