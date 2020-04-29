package cn.stylefeng.guns.petcage_busi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by user chenzuoli on 2020/4/8 11:18
 * description: 宠物类型、品种维表
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "dim_pet", schema = "petcage")
public class PetcageDimPet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String pet_type;
    private String variety;
    private String size;
    private String country;
    private String create_time;
    private String update_time;
}
