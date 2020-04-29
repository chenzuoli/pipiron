package cn.stylefeng.guns.sys.modular.system.service;

import cn.stylefeng.guns.sys.modular.system.entity.Menu;
import cn.stylefeng.guns.sys.modular.system.entity.Relation;
import cn.stylefeng.guns.sys.modular.system.mapper.RelationMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class RelationService extends ServiceImpl<RelationMapper, Relation> {
    @Autowired
    UserService userService;

    public void addRelation(Menu menu) {
        Relation relation = new Relation();
        relation.setMenuId(menu.getMenuId());
        Map<String, Object> userInfo = userService.getUserInfo(menu.getCreateUser());
        System.out.println(">>>>>>user info: " + userInfo);
        long role_id = Long.parseLong(userInfo.get("roleId").toString());
        relation.setRoleId(role_id);
        this.save(relation);
        System.out.println(">>>>>>saved relation: " + relation);
    }

}
