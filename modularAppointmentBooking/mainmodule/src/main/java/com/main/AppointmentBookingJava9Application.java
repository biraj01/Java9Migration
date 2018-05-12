package com.main;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import com.dataaccess.entities.AppointmentBean;
import com.dataaccess.entities.CounselorBean;
import com.dataaccess.entities.StudentBean;
import com.dataaccess.repository.api.AppointmentRepository;
import com.dataaccess.repository.api.CounselorRepository;
import com.dataaccess.repository.api.StudentRepository;


@SpringBootApplication(scanBasePackageClasses={com.appointmentService.api.AppointmentService.class, com.dataaccess.repository.api.StudentRepository.class})
@ComponentScan({"com"})
@EntityScan( basePackages = {"com.dataaccess.entities"})
public class AppointmentBookingJava9Application {

	 @Bean
	    CommandLineRunner init(StudentRepository studentRepository, CounselorRepository coun, AppointmentRepository app) {
	        return args -> {
	            StudentBean student1 = new com.dataaccess.entities.StudentBean();
	            student1.setFirstName("Biraj");
	            student1.setLastName("Dhungel");
	            student1 = studentRepository.save(student1);
	            CounselorBean counselor = new CounselorBean();
	            counselor.setFirstName("Stefan");
	            counselor.setLastName("Sarstedt");
	            counselor.setOpenFrom(LocalTime.of(9, 00));
	            counselor.setOpenTill(LocalTime.of(15, 00));
	            counselor = coun.save(counselor);
	            
	            CounselorBean counselor2 = new CounselorBean();
	            counselor2.setFirstName("Olaf");
	            counselor2.setLastName("Zukunft");
	            counselor2.setOpenFrom(LocalTime.of(12, 00));
	            counselor2.setOpenTill(LocalTime.of(18, 00));
	            counselor2 = coun.save(counselor2);  
	            
	            CounselorBean counselor3 = new CounselorBean();
	            counselor3.setFirstName("Brend");
	            counselor3.setLastName("Kahlbrandt");
	            counselor3.setOpenFrom(LocalTime.of(12, 00));
	            counselor3.setOpenTill(LocalTime.of(18, 00));
	            coun.save(counselor3);

				AppointmentBean bean = new AppointmentBean();
				bean.setCounselorBean(counselor3);
				bean.setStudentBean(student1);
				bean.setFrom(LocalDateTime.now());
				bean.setTo(LocalDateTime.now().plusHours(1));
				app.save(bean);
	            
	        };
	    }

	public static void main(String[] args) {
		SpringApplication.run(AppointmentBookingJava9Application.class, args);
	}
	
}
