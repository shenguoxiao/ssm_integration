package com.ssm.integration.controller;

import com.ssm.integration.pojo.Person;
import com.ssm.integration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName:PersonController
 * @Description:
 * @Author:shen
 * @Time:2020-03-27
 * @Version:1.0
 */
@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("addPerson")
    @ResponseBody
    public String addPerson()
    {
        Person person = new Person("24","shenguoxiao",24);
        boolean isDone = personService.addPerson(person);
        String message = "";
        if(isDone)
            message="add success!";
        else
            message = "add failure!";
        return message;
    }
    @ResponseBody
    @RequestMapping("connect1")
    public String connect1()
    {
        Person person = new Person("","shenguoxiao",24);
        personService.addPerson1(person);
        return "connect1";
    }
    @ResponseBody
    @RequestMapping("connect2")
    public String connect2()
    {

        return "connect2";
    }

    @RequestMapping("transaction")
    @ResponseBody
    public String transaction() throws Exception {
        personService.transactionFun();
        return "success";
    }
}
