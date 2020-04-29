package cn.stylefeng.guns.petcage_busi.service;

import cn.stylefeng.guns.petcage_busi.dao.OrderRepository;
import cn.stylefeng.guns.petcage_busi.entity.PetcageOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user chenzuoli on 2020/4/26 17:06
 * description: 订单服务
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<PetcageOrder> petcageOrder() {
        return orderRepository.petcageOrder();
    }
}
