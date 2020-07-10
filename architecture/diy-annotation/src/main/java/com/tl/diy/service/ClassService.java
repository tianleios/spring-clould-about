package com.tl.diy.service;

import com.tl.diy.annotation.DIY;
import com.tl.diy.annotation.DIYClass;
import com.tl.diy.service.rule.Rule;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tianlei on 2020/4/27
 */
@Service
public class ClassService implements SmartInitializingSingleton {

    // 老师
    @Autowired
    private TeacherService teacherService;

    //学生
    private StudentService studentService;

    //课程
    private CourseService courseService;

    //班规
    @Autowired
    private List<Rule> rules;

    @Autowired
    private Map<String, Rule> ruleMap;

    @Autowired
    @Qualifier("XRule")
    private Rule rule;

    @DIY
    private DIYClass diyServie;

    public ClassService(@Autowired StudentService studentService) {
         this.studentService = studentService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void afterSingletonsInstantiated() {

        System.out.println(String.format("teacherService : %s \n" +
                        "studentService : %s \n" +
                        "courseService  : %s \n" +
                        "diyServie  : %s \n"
                ,
                teacherService,
                studentService,
                courseService,
                diyServie.getName()));

    }
}
