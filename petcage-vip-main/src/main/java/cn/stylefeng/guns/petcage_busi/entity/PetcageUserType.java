package cn.stylefeng.guns.petcage_busi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by user chenzuoli on 2020/4/26 17:11
 * description: 用户类型字典表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user_type", schema = "petcage")
public class PetcageUserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String code; // 用户类型
    private String name; // 用户类型名称
    private String create_time; //
    private String update_time; //
}
