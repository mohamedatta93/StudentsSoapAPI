/**
 * 
 */
package com.mohamedatta.schoolSoapService.services;

import javax.annotation.PostConstruct;

/**
 * @author Atta
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mohamedatta.xsds.school.AddStudentRequest;
import com.mohamedatta.xsds.school.AddStudentResponse;
import com.mohamedatta.xsds.school.Student;
import com.mohamedatta.xsds.school.StudentDetailsRequest;
import com.mohamedatta.xsds.school.StudentDetailsResponse;

@Endpoint
public class StudentEndpoint 
{
    private static final String NAMESPACE_URI = "http://www.mohamedatta.com/xsds/school";
 
    private StudentRepository StudentRepository;
 
    @Autowired
    public StudentEndpoint(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }
    @PostConstruct
    void addConstStudents() {
    	Student s1 = new Student();
    	s1.setId(1);
    	s1.setAddress("giza");
    	s1.setName("mohamed atta");
    	Student s2 = new Student();
    	s2.setId(2);
    	s1.setAddress("cairo");
    	s1.setName("hossam meem");
    	Student s3 = new Student();
    	s3.setId(3);
    	s1.setAddress("alex");
    	s1.setName("mahmoud noon");
    	StudentRepository.save(s1);
    	StudentRepository.save(s2);
    	StudentRepository.save(s3);
    	
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddStudentRequest")
    @ResponsePayload
    public StudentDetailsResponse addStudent(@RequestPayload AddStudentRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        Student s = new Student();
        s.setAddress(request.getAddress());
        s.setName(request.getName());
        response.setStudent(StudentRepository.save(s));
        
 
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request) {
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(StudentRepository.findById(request.getId()).get());
 
        return response;
    }
}