package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.FeedbackRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 16:56
 * description: 反馈服务
 */
@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    public List<PetcageFeedback> feedback() {
        return feedbackRepository.feedback();
    }
}
