package com.gdkyit.controller;

import com.gdkyit.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@RestController
public class ApiController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     *获取该user被允许的所有功能模块
     */
    @GetMapping("/api/users/{userid}/menu")
    public ResponseEntity<?> getUserMenu(@PathVariable Integer userid){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select `user`.username,menu.menuname from `user`,`user-role`,menu where `user`.id=`user-role`.userid and `user-role`.menuid=menu.id and `user`.id=?",userid);
        ResponseMessage responseMessage =new ResponseMessage("200","",list);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    /**
     * 通过访问 GET /api/users/{userid}，可获取该用户的明细信息，包括其所在的角色组和被授权的功能模块菜单
     */
    @GetMapping("/api/users/{userid}")
    public ResponseEntity<?> getUserDetails(@PathVariable Integer userid){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select `user`.username,role.rolename,menu.menuname from  `user`,role,menu,`user-role`,`role-menu` where `user`.id=`user-role`.userid and role.id=`user-role`.id and role.id=`role-menu`.roleid and menu.id=`role-menu`.menuid and `user`.id=?",userid);
        ResponseMessage responseMessage =new ResponseMessage("200","",list);
        return new ResponseEntity<Object>(responseMessage, HttpStatus.OK);
    }

    /**
     * 通过 POST /api/relation/rolemenu 可以更新role-menu的对应关系
     */


    /**
     * 通过 POST /api/relation/roleuserk 可以更新role-user的对应关系
     */


}
