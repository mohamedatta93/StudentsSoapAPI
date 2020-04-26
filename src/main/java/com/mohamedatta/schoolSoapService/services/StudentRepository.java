package com.mohamedatta.schoolSoapService.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mohamedatta.xsds.school.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
