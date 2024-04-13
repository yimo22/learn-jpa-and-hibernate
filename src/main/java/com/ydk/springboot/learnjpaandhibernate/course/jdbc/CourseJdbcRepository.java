package com.ydk.springboot.learnjpaandhibernate.course.jdbc;

import com.ydk.springboot.learnjpaandhibernate.course.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CourseJdbcRepository {
    private final JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
            """
                INSERT INTO COURSE(ID, name, author)
                VALUES (?, ?, ?)
            """;

    private static String DELETE_QUERY =
            """
                DELETE FROM COURSE
                WHERE `id` = ?        
            """;
    private static String SELECT_QUERY =
            """
                SELECT * FROM COURSE
                WHERE `id` = ?        
            """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(Long id){
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id){
        // ResultSet -> Bean => Row Mapper
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);


    }

}
