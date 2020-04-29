package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 16:57
 * description: 反馈控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/feedback")
    public String index() {
        return "/petcage_busi/feedback/feedback.html";
    }

    @RequestMapping(value = "/feedback_list")
    @ResponseBody
    public ResultDTO feedback() {
        return ResultDTO.ok(feedbackService.feedback());
    }
}
