package com.ssm.integration.service;

import com.ssm.integration.dao.PersonMapper;
import com.ssm.integration.pojo.Person;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName:PersonService
 * @Description:
 * @Author:shen
 * @Time:2020-03-27
 * @Version:1.0
 */
@Service
public class PersonService {

    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Logger logger = Logger.getLogger(PersonService.class);

    @Autowired
    private PersonMapper personMapper;

    public boolean addPerson(Person person) {
        try {
            personMapper.addPerson(person);
            logger.info("person add service success!");
            return true;
        }catch(Exception e)
        {
            logger.error(e.getMessage());
            return false;
        }
    }

    public boolean addPerson1(Person person) {
        try {
            personMapper.addPerson(person);
            String name = Thread.currentThread().getName();
            System.out.println("ThreadName:"+name);

            return true;
        }catch(Exception e)
        {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void transactionFun() throws Exception {
        String createTime= SDF.format(new Date());
        Date time = new Date();
        Random random = new Random();

        int i = random.nextInt(4);
        System.out.println("i:"+i);
        personMapper.addTran1("shenguoxiao",time);
        if(i<1)
        {
            throw new Exception("exception1");
        }
        personMapper.addTran2("yuanning",time);
        throw new Exception("exception");
    }
}
