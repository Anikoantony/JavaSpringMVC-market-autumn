package ru.geekbrains.marketautumn.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.marketautumn.dto.Student;
import ru.geekbrains.marketautumn.repo.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // заинжектить репозиторий
public class StudentService {

    private final StudentRepository repository;

    public Student getStudent(Long id){
        return repository.findById(id);
    }

    public List<Student> getAllStudent(){
        return repository.getStudents();
    }
}
