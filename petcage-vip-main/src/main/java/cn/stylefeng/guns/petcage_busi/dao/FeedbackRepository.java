package cn.stylefeng.guns.petcage_busi.dao;

import cn.stylefeng.guns.petcage_busi.entity.PetcageFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:55
 * description: 反馈工厂
 */
@Repository
public interface FeedbackRepository extends JpaRepository<PetcageFeedback, String> {

    @Query(value = "select * from feedback", nativeQuery = true)
    List<PetcageFeedback> feedback();
}
