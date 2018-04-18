package com.jiejing.dao;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by xm on 17/7/26.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentSignInMapperTests {

    @Resource
    private StudentSignInMapper studentSignInMapper;


//    @Test
//    public void testSelectByClassId(){
//        List<StudentSignIn> studentSignInList = studentSignInMapper.selectByClassId(20160315141130l);
//        studentSignInList.stream().forEach(n->{
//            System.out.println(n.getId());
//        });
//    }

//    @Test
//    public void insert(){
//        StudentSignIn studentSignIn = new StudentSignIn();
//        studentSignIn.setIsTrial(true);
//        studentSignIn.setId(1234567l);
//        studentSignIn.setInstId(1234567l);
//        studentSignIn.setClassId(1234567l);
//        studentSignIn.setClassName("班级哦");
//        studentSignIn.setClassHour(0);
//        studentSignIn.setTeacherId(1234567l);
//        studentSignIn.setStudentId(1234567l);
//        studentSignIn.setStatus(1);
//        studentSignIn.setSignDate(new Date());
//
//        studentSignInMapper.insert(studentSignIn);
//    }
}
