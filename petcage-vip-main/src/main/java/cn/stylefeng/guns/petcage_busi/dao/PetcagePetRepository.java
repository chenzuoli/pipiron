package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcagePet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/25 09:08
 * description: 宠物工厂
 */
@Repository
public interface PetcagePetRepository extends JpaRepository<PetcagePet, String> {

    @Query(value = "select * from user_pet", nativeQuery = true)
    List<PetcagePet> getPets();

    @Query(value = "select * from user_pet where id = ?1", nativeQuery = true)
    PetcagePet petDetail(String id);

    @Transactional
    @Modifying
    @Query(value = "update user_pet set contact = ?2, pet_type = ?3, variety = ?4, nick_name = ?5, gender = ?6, birthday = ?7, description = ?8, update_time = ?9 where id = ?1", nativeQuery = true)
    int editPet(String id, String contact, String pet_type, String variety, String nick_name, String gender, String birthday, String description, String update_time);

    @Transactional
    @Modifying
    @Query(value = "delete from user_pet where id = ?1", nativeQuery = true)
    int deletePet(String id);

}
