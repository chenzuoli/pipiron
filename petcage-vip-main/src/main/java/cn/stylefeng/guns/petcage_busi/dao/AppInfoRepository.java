package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageAppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 15:57
 * description: 应用信息工厂
 */
@Repository
public interface AppInfoRepository extends JpaRepository<PetcageAppInfo, String> {

    @Query(value = "select * from app_info", nativeQuery = true)
    List<PetcageAppInfo> appInfo();
}
