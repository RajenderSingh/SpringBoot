package com.example.demo1.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.example.demo1.domain.NumberDTO;
import com.example.demo1.domain.Result;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebAppConfiguration
public class MinMaxControllerTest {

	@InjectMocks
	private MinMaxController minMaxController;
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(minMaxController)
//        .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
        .setViewResolvers(new ViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                return new MappingJackson2JsonView();
            }
        }).build(); 
	}

	@Test
	public void findMinMax_ValidInput_Successful() throws Exception {
		Integer[] intArray = { 1, 2, 3, 4, 5, 6 };
		List<Integer> numberLst = Arrays.asList(intArray);
		NumberDTO numberDTO = new NumberDTO(numberLst);
		String numRequest = new ObjectMapper().writeValueAsString(numberDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/challenge")
				.accept(MediaType.APPLICATION_JSON).content(numRequest)
				.contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse mockHttpServletResponse = mockMvc
				.perform(requestBuilder).andReturn()
				.getResponse();
		Result result = new ObjectMapper().readValue(mockHttpServletResponse.getContentAsString(), Result.class);
		assertEquals(Integer.valueOf(6), result.getMax());
		assertEquals(Integer.valueOf(1), result.getMin());
	}
	
	@Test
	public void findMinMax_InValidInput_Successful() throws Exception {
		Integer[] intArray = { 1, 2, 3, 4, 5, 6 };
		List<Integer> numberLst = Arrays.asList(intArray);
		NumberDTO numberDTO = new NumberDTO(numberLst);
		String numRequest = new ObjectMapper().writeValueAsString(numberDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/challenge")
				.accept(MediaType.APPLICATION_JSON).content(numRequest)
				.contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse mockHttpServletResponse = mockMvc
				.perform(requestBuilder).andReturn()
				.getResponse();
		Result result = new ObjectMapper().readValue(mockHttpServletResponse.getContentAsString(), Result.class);
		assertNotEquals(Integer.valueOf(5), result.getMax());
		assertNotEquals(Integer.valueOf(2), result.getMin());
	}

}
