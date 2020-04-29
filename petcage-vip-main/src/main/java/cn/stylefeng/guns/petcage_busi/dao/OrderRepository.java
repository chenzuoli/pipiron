package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 17:05
 * description: 订单工厂
 */
@Repository
public interface OrderRepository extends JpaRepository<PetcageOrder, String> {

    @Query(value = "select * from petcage_order", nativeQuery = true)
    List<PetcageOrder> petcageOrder();
}
