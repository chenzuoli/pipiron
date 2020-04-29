package cn.stylefeng.guns.petcage_busi.controller;

import cn.stylefeng.guns.petcage_busi.dto.ResultDTO;
import cn.stylefeng.guns.petcage_busi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by user chenzuoli on 2020/4/26 17:07
 * description: 订单控制器
 */
@Controller
@RequestMapping(value = "/petcage")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order")
    public String index() {
        return "/petcage_busi/order/order.html";
    }

    @RequestMapping(value = "/order_list")
    @ResponseBody
    public ResultDTO petcageOrder() {
        return ResultDTO.ok(orderService.petcageOrder());
    }

}
