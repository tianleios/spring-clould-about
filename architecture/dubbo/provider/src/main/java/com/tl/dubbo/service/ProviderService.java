package com.tl.dubbo.service;

import com.tl.dubbo.common.model.Teacher;
import com.tl.dubbo.common.service.Provider;
import org.apache.dubbo.config.annotation.Service;

/**
 * Created by tianlei on 2019-07-28
 */
@Service(proxy = "jdk")
public class ProviderService  implements Provider {
    @Override
    public Teacher sayHi(String content) {
        Teacher teacher = new Teacher();
        teacher.setName(content);
        teacher.setAge(18);
        return teacher;

//        if (content.length() > 3) {
//            throw new RuntimeException("tl error");
//        }
//        return "Hi!" + content;
    }
}
