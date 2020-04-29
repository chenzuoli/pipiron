package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:30
 * description: 设备工厂
 */
@Repository
public interface DeviceRepository extends JpaRepository<PetcageDevice, String> {

    @Query(value = "select * from device", nativeQuery = true)
    List<PetcageDevice> device();
}
