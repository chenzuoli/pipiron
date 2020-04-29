package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageUserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 17:17
 * description: 用户类型工厂
 */
@Repository
public interface UserTypeRepository extends JpaRepository<PetcageUserType, String> {
    @Query(value = "select * from user_type", nativeQuery = true)
    List<PetcageUserType> userType();
}
