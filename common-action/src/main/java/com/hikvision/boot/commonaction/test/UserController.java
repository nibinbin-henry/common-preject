package com.hikvision.boot.commonaction.test;

import com.hikvision.boot.commoncore.test.TestDo;
import com.hikvision.boot.commonservice.test.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: nibinbin
 * @date: 2020/4/19 11:04
 * @modify by
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl lettuce;
    @RequestMapping("/selectAll")
    public List<TestDo> selectAll(){

        return lettuce.selectAll();
    }
}
