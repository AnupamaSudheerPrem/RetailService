package com.anu.poc.myretail.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ProductControllerTest extends RetailServiceParentTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testControllerHttpOK() throws Exception {
		
		mockMvc.perform(get("/myretail/v1/products/77605448")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.product.item.tcin").value("77605448")).andExpect(jsonPath("$.price.productId").value("77605448"))
				.andExpect(jsonPath("$.price.price").value(31)).andExpect(jsonPath("$.price.country_code").value("USD"))
				.andExpect(jsonPath("$.offer.offerPercentage").value(10.0));
	}
	
	@Test
	public void testControllerHttp404() throws Exception {
		mockMvc.perform(get("/myretail/v1/products/77605442")).andExpect(status().isNotFound());
	}
	
	
}
