package com.upwork.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.upwork.task.service.StudentScheduleService;

@Configuration
@EnableTransactionManagement
public class TaskApplicationConfig {
	@Bean
	public StudentScheduleService studentScheduleService() {
		return new StudentScheduleService();
	}
}
