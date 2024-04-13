package com.ydk.springboot.learnjpaandhibernate.course.springdatajpa;


import com.ydk.springboot.learnjpaandhibernate.course.Course;
import com.ydk.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 를 Implements & 구현함으로써
 * Spring 시작시, 필요한 비즈니스 로직들을 수행하도록 설정할 수 있다.
 */
@Component
@RequiredArgsConstructor
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

    private final JpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(11, "Learn Aws SpringDataJpa now", "yimo22"));
        repository.save(new Course(12, "Learn Azure SpringDataJpa now", "yimo22"));
        repository.save(new Course(13, "Learn Devops SpringDataJpa now", "yimo22"));

        repository.deleteById(11L);

        System.out.println(repository.findById(12L));
        System.out.println(repository.findById(13L));

        System.out.println(repository.findAll());
    }
}
