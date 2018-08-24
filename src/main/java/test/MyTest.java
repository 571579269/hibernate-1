package test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bean.Student;
import com.service.myService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"/spring-xml/bean.xml"})	
public class MyTest {  
    
	@Autowired
    private myService service;
	
	@Test  
    public void Insert(){  
        Student student = new Student();  
        student.setDate(new Date());  
        student.setName("Long");  
        service.save(student);  
    }  
    @Test  
    public void testFind(){  
        Student findOne = service.findOne(3); 
        System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
        if(findOne!=null)
        System.out.println(findOne);else
        System.out.println("≤È’“≤ªµΩ");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }  
}  