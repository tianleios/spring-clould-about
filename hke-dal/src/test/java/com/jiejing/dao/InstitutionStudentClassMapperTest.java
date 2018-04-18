package com.jiejing.dao;

import com.jiejing.model.InstitutionStudentClass;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by xm on 17/3/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InstitutionStudentClassMapperTest {

    @Autowired
    private InstitutionStudentClassMapper institutionStudentClassMapper;

    @Test
    public void test(){
        List<InstitutionStudentClass> students = institutionStudentClassMapper.queryStudentIdsByClassId(20160401142297l);
        for(InstitutionStudentClass c:students){
            System.out.println(c.getStudentId());
        }


    }
}
