package ru.geekbrains.marketautumn.repo;

import org.springframework.stereotype.Repository;
import ru.geekbrains.marketautumn.dto.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<>(Arrays.asList(
                new Student(1L, "Bob"),
                new Student(2L, "Jonh"),
                new Student(3L, "Dave")
        ));
    }

    public Student findById(Long id) {
        return students.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Студент не найден"));
    }

    public List<Student> getStudents(){
        return students;
    }

}
