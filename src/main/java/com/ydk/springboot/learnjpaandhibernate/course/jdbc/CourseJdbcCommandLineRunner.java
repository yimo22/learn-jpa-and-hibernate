package com.ydk.springboot.learnjpaandhibernate.course.jdbc;


import com.ydk.springboot.learnjpaandhibernate.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 를 Implements & 구현함으로써
 * Spring 시작시, 필요한 비즈니스 로직들을 수행하도록 설정할 수 있다.
 */
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    private CourseJdbcRepository repository;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository){
        this.repository = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn Aws now", "yimo22"));
        repository.insert(new Course(2, "Learn Azure now", "yimo22"));
        repository.insert(new Course(3, "Learn Devops now", "yimo22"));

        repository.delete(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
    }
}
