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
public class MenuImpl {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> get(){
        return jdbcTemplate.queryForList("select * from menu");
    }

    public void add(Object menuname){
        jdbcTemplate.update("insert INTO menu(menuname)VALUE (?)",menuname);
    }

    public void delete(Object id){
        jdbcTemplate.update("delete menu WHERE id=?",id);
    }

    public void alert(Object id, Object username){
        jdbcTemplate.update("UPDATE menu SET username=? WHERE id=?",username,id);
    }
}
