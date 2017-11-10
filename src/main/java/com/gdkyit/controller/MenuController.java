package com.gdkyit.controller;

import com.gdkyit.dao.MenuImpl;
import com.gdkyit.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    MenuImpl menuImpl;

    @GetMapping("")
    public ResponseEntity<?> get(){
        List<Map<String,Object>> list = menuImpl.get();
        ResponseMessage responseEntity = new ResponseMessage("200","",list);
        return new ResponseEntity<Object>(responseEntity, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Map<String,Object> params){
        menuImpl.add(params.get("menuname"));
        ResponseMessage responseMessage = new ResponseMessage("200","","增加成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Map<String,Object> params){
        menuImpl.delete(params.get("id"));
        ResponseMessage responseMessage = new ResponseMessage("200","","删除成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

    @PostMapping("/alert")
    public ResponseEntity<?> alert(@RequestBody Map<String,Object> params){
        menuImpl.alert(params.get("id"),params.get("menuname"));
        ResponseMessage responseMessage = new ResponseMessage("200","","修改成功");
        return new ResponseEntity<Object>(responseMessage,HttpStatus.OK);
    }

}