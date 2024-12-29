package org.conan.utils;

import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.conan.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.fail;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j
public class TimeMapperTest {
    @Setter(onMethod_ = {@Autowired})
    private TimeMapper timeMapper;

    @Test
    public void testGetTime() {
        System.out.println(timeMapper.getClass().getName());
        System.out.println(timeMapper.getTime());
    }

    @Test
    public void testGetTime2() {
        System.out.println("getTime2");
        System.out.println(timeMapper.getTime2());
    }
}