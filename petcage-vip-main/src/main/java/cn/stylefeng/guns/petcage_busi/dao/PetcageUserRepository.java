package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/24 18:54
 * description: 用户工厂
 */
@Repository
public interface PetcageUserRepository extends JpaRepository<PetcageUser, String> {

    @Query(value = "select * from user", nativeQuery = true)
    List<PetcageUser> getUsers();
}
