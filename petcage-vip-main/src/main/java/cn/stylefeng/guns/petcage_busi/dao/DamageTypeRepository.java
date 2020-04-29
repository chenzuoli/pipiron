package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageDamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:13
 * description: 故障类型工厂
 */
@Repository
public interface DamageTypeRepository extends JpaRepository<PetcageDamageType, String> {

    @Query(value = "select * from damage_type", nativeQuery = true)
    List<PetcageDamageType> damageType();
}
