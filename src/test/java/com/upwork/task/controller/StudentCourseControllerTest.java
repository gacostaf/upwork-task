package com.upwork.task.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.upwork.task.TaskApplication;
import com.upwork.task.model.StudentCourse;

@SpringBootTest(classes = TaskApplication.class)
@AutoConfigureMockMvc
class StudentCourseControllerTest {
    private static final String BASE_URL = "/student-course";

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	private StudentCourseController studentCourseController;
	
	@Test
	void deleteStudentCourse_success() throws Exception {
	   mockMvc.perform(
				  MockMvcRequestBuilders
			      .post(BASE_URL + "/")
			      .content(asJsonString(new StudentCourse(700, "1234567", "111", new Date())))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON));
		
       this.mockMvc.perform(
        		MockMvcRequestBuilders
                .delete(BASE_URL + "/{id}", "700")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        				
       this.mockMvc.perform(
       			  MockMvcRequestBuilders
    		      .get(BASE_URL + "/{id}", 700)
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isNotFound());	
	}
	
	@Test
	void saveStudentCourse_success() throws Exception {
		this.mockMvc.perform(
		  MockMvcRequestBuilders
	      .post(BASE_URL + "/")
	      .content(asJsonString(new StudentCourse(700, "1234567", "111", new Date())))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	    .andExpect(status().isCreated());
		
		this.mockMvc.perform(
			MockMvcRequestBuilders
			.get(BASE_URL + "/{id}", 700)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());		
	}
	
	@Test	
	void getAllStudentCourse() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get(BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		

	}

	@Test	
	void getStudentCourse() throws Exception {
	   mockMvc.perform(
				  MockMvcRequestBuilders
			      .post(BASE_URL + "/")
			      .content(asJsonString(new StudentCourse(700, "1234567", "111", new Date())))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON));
			
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get(BASE_URL+"/{id}", 700)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}

	@Test	
	void putStudentCourse() throws Exception {
	   mockMvc.perform(
				  MockMvcRequestBuilders
			      .post(BASE_URL + "/")
			      .content(asJsonString(new StudentCourse(700, "1234567", "111", new Date())))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON));
	   
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.put(BASE_URL+"/{id}", 700)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new StudentCourse(700, "1234567", "111", new Date()))))
				.andExpect(status().isOk());		
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
