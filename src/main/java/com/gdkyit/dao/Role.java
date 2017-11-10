package com.gdkyit.dao;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public interface Role {
    public List<Map<String, Object>> get();

    public void add(Object rolename);

    public void alert(Object id, Object rolename);

    public void delete(Object id);

}
