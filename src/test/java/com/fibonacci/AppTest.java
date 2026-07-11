package com.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext context;

    @Test
    public void testBeansExist() {
        assertTrue(context.containsBean("fibonacciController"), "FibonacciController bean should exist");
        assertTrue(context.containsBean("fibonacci"), "Fibonacci bean should exist");
    }

    @Test
    public void testFibonacciEndpoint() throws Exception {
        mockMvc.perform(get("/fibonacci").param("n", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("The 10th term of the Fibonacci sequence is 55."));
    }

    @Test
    public void testFibonacciEndpointNegative() throws Exception {
        mockMvc.perform(get("/fibonacci").param("n", "-1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid input: n was negative"));
    }

    @Test
    public void testFibonacciEndpointNonNumeric() throws Exception {
        mockMvc.perform(get("/fibonacci").param("n", "abc"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input: n must be an integer"));
    }

    @Test
    public void testFibonacciEndpointDefault() throws Exception {
        mockMvc.perform(get("/fibonacci"))
                .andExpect(status().isOk())
                .andExpect(content().string("The 0 term of the Fibonacci sequence is 0."));
    }

    @Test
    public void testIndexPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
