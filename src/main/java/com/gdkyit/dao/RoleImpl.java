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
public class RoleImpl implements Role{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> get() {
        return jdbcTemplate.queryForList("select * from role");
    }

    @Override
    public void add(Object rolename) {
        jdbcTemplate.update("insert into role(rolename)value(?)",rolename);
    }

    @Override
    public void alert(Object id, Object rolename) {
        jdbcTemplate.update("UPDATE role SET rolename=? WHERE id=?",rolename,id);
    }

    @Override
    public void delete(Object id) {
        jdbcTemplate.update("DELETE FROM role WHERE id=?",id);
    }
}
