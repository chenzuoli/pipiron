package cn.stylefeng.guns.petcage_busi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by user chenzuoli on 2020/3/22 16:14
 * description: 设备表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "device", schema = "petcage")
public class PetcageDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // 自增主键
    private String device_id; // 设备id
    private String device_name; // 设备名称
    private String longitude; // 设备径度
    private String latitude; // 设备纬度
    private String kwh; // 设备电量余额
    private String create_time; //
    private String update_time; //
}
