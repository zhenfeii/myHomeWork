package com.gdkyit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@Service
public class UserImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> get(){
        return jdbcTemplate.queryForList("SELECT * FROM user");
    }

    public void add(Object username){
        jdbcTemplate.update("INSERT INTO user(username) VALUE (?)",username);
    }

    public void delete(Object id){
        jdbcTemplate.update("DELETE user WHERE id=?",id);
    }

    public void alert(Object id,Object username){
        jdbcTemplate.update("UPDATE user SET username=? WHERE id=?",username,id);
    }
}
