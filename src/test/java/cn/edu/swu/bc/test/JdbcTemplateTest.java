package cn.edu.swu.bc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    @Test
    public void test1() throws PropertyVetoException {
        //创建数据源对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        int row=jdbcTemplate.update("insert into  account value(\"bicheng\",111111);");
        System.out.println(row);
    }

    @Test
    public void test2() {
        //创建数据源对象
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=app.getBean(JdbcTemplate.class);
        int row=jdbcTemplate.update("insert into account value(\"zhangsan\",111111);");
        System.out.println(row);
    }
}


