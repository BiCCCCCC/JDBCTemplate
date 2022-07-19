package cn.edu.swu.bc.test;

import cn.edu.swu.bc.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void updateTest(){
        jdbcTemplate.update("update account set money=? where name=?",66666,"bicheng");
    }

    @Test
    public void deleteTest(){
        jdbcTemplate.update("delete from account where name=? or  name=?","zhangsan","lisi");
    }

    @Test
    public void queryTest(){
        List<Account> account = jdbcTemplate.query("select * from account  where name=\"bicheng\"", new BeanPropertyRowMapper<>(Account.class));
        System.out.println(account);
    }

    @Test
    public void queryOneTest(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account ", long.class);
        System.out.println(count);
    }
}
