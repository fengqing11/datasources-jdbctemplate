package xyz.fengqing11.datasourcesjdbctemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.fengqing11.datasourcesjdbctemplate.pojo.Book;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
    @Resource(name = "jdbcTemplateOne")
    JdbcTemplate jdbcTemplateOne;
    @Autowired
    @Qualifier("jdbcTemplateTwo")
    JdbcTemplate JdbcTemplateTwo;

    @GetMapping("/test")
    public void test() {
        List<Book> bs1 = jdbcTemplateOne.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
        List<Book> bs2 = JdbcTemplateTwo.query("select * from book",
                new BeanPropertyRowMapper<>(Book.class));
        System.out.println("bs1:" + bs1);
        System.out.println("bs2:" + bs2);
    }
}
