package com.gdkyit.controller;

import com.gdkyit.dao.RoleImpl;
import com.gdkyit.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleImpl roleImpl;

    @GetMapping("")
    public ResponseEntity<Object> get(){
        ResponseMessage responseMessage =new ResponseMessage("200","","");
        List<Map<String,Object>> list = roleImpl.get();
        responseMessage.setData(list);
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Map<String, Object> params){
        roleImpl.add(params.get("rolename"));
        ResponseMessage responseMessage = new ResponseMessage("200","","增加成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

    @PostMapping("/alert")
    public ResponseEntity<?> alert(@RequestBody Map<String,Object> params){
        roleImpl.alert(params.get("id"),params.get("rolename"));
        ResponseMessage responseMessage = new ResponseMessage("200","","修改成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Map<String, Object> params){
        roleImpl.delete(params.get("id"));
        ResponseMessage responseMessage = new ResponseMessage("200","","删除成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

}
