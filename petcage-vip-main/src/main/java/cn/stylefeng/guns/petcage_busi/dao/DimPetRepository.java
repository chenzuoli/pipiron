package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageDimPet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/25 12:31
 * description: 宠物类型品种工厂
 */
@Repository
public interface DimPetRepository extends JpaRepository<PetcageDimPet, String> {

    @Query(value = "select pet_type from dim_pet group by pet_type", nativeQuery = true)
    List<String> petType();

    @Query(value = "select * from dim_pet", nativeQuery = true)
    List<PetcageDimPet> dimPet();
}
