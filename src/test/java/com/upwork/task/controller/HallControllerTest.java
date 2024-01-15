package com.upwork.task.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.upwork.task.model.Hall;

@SpringBootTest(classes = TaskApplication.class)
@AutoConfigureMockMvc
class HallControllerTest {
    private static final String BASE_URL = "/hall";

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	private HallController hallController;
	
	@Test
	void deleteHall_success() throws Exception {
	   mockMvc.perform(
				  MockMvcRequestBuilders
			      .post(BASE_URL + "/")
			      .content(asJsonString(new Hall(700, "idHall", "name")))
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
	void saveHall_success() throws Exception {
		this.mockMvc.perform(
		  MockMvcRequestBuilders
	      .post(BASE_URL + "/")
	      .content(asJsonString(new Hall(700, "idHall", "name")))
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
	void getAllHall() throws Exception {
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get(BASE_URL)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		

	}

	@Test	
	void getHall() throws Exception {
	   mockMvc.perform(
				  MockMvcRequestBuilders
			      .post(BASE_URL + "/")
			      .content(asJsonString(new Hall(700, "idHall0", "name")))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON));
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get(BASE_URL+"/{id}", 700)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());		
	}

	@Test	
	void putHall() throws Exception {
		   mockMvc.perform(
					  MockMvcRequestBuilders
				      .post(BASE_URL + "/")
				      .content(asJsonString(new Hall(700, "idHall0", "name")))
				      .contentType(MediaType.APPLICATION_JSON)
				      .accept(MediaType.APPLICATION_JSON));
			
	 		this.mockMvc.perform(
				MockMvcRequestBuilders
				.put(BASE_URL+"/{id}", 700)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(new Hall(700, "idHall1", "name"))))
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
