package com.Project1.Productservice;

import com.Project1.Productservice.DTO.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2"); //to set uri

    @Autowired
    private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;  //Map to convert pojo object to Json

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateCourse() throws Exception {
		 ProductRequest productRequest = getCourseRequest();

	String courseRequestString	= objectMapper.writeValueAsString(productRequest);
		 mockMvc.perform(MockMvcRequestBuilders.post("/api/course")
				.contentType(MediaType.APPLICATION_JSON)
				.content(courseRequestString))
				 .andExpect(status().isCreated()); //mvc will make a call to endpoint bshart ykon course req string da ykon course req obj lw hwa f3ln kda yb2a kda expected status is created
	}

	private ProductRequest getCourseRequest() {
		return ProductRequest.builder()
				.name("Maths")
				.description("Course")
				.price(BigDecimal.valueOf(100))
				.build();
 	}
//--------------------------------ERROR----------------------------------------
}
