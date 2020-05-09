package com.ssm.integration.dao;

import com.ssm.integration.pojo.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PersonMapper {
    public void addPerson(@Param("person") Person p);

    public void addTran1(@Param("name") String value, @Param("createTime") Date time);
    public void addTran2(@Param("name") String value, @Param("createTime") Date time);
}
