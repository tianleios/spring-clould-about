package com.jiejing;

import com.jiejing.dao.InstitutionBroadcastMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evil on 12/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:com/jiejing/spring/applicationContext*.xml")
public class BroadcastTest extends AbstractJUnit4SpringContextTests {
    @Resource InstitutionBroadcastMapper institutionBroadcastMapper;


    @Test public void updateSetTop(){
        List<Long> ids=new ArrayList<Long>();
        ids.add(10L);
        ids.add(11L);
        institutionBroadcastMapper.updateBroadcastSetTop(ids,1);
    }

}
