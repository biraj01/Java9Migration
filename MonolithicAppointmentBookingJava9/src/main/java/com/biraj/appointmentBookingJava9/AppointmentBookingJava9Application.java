package com.biraj.appointmentBookingJava9;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.biraj.appointmentBookingJava9.model.AppointmentBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.biraj.appointmentBookingJava9.dao.AppointmentRepository;
import com.biraj.appointmentBookingJava9.dao.CounselorRepository;
import com.biraj.appointmentBookingJava9.dao.StudentRepository;
import com.biraj.appointmentBookingJava9.model.CounselorBean;
import com.biraj.appointmentBookingJava9.model.StudentBean;

@SpringBootApplication
public class AppointmentBookingJava9Application {

	 @Bean
	    CommandLineRunner init(StudentRepository studentRepo, CounselorRepository coun, AppointmentRepository app) {
	        return args -> {
	            StudentBean student1 = new StudentBean();
	            student1.setFirstName("Biraj");
	            student1.setLastName("Dhungel");
	            student1 = studentRepo.save(student1);
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
