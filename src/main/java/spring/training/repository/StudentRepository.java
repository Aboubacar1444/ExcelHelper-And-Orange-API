package spring.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import spring.training.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
