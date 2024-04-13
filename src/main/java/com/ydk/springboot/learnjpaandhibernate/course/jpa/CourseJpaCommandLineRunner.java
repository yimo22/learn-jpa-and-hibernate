package com.ydk.springboot.learnjpaandhibernate.course.jpa;


import com.ydk.springboot.learnjpaandhibernate.course.Course;
import com.ydk.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 를 Implements & 구현함으로써
 * Spring 시작시, 필요한 비즈니스 로직들을 수행하도록 설정할 수 있다.
 */
@Component
@RequiredArgsConstructor
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    private final CourseJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(5, "Learn Aws Jpa now", "yimo22"));
        repository.insert(new Course(6, "Learn Azure Jpa now", "yimo22"));
        repository.insert(new Course(7, "Learn Devops Jpa now", "yimo22"));

        repository.deleteById(5);

        System.out.println(repository.findById(6L));
        System.out.println(repository.findById(7L));
    }
}
