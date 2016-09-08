package com.lwd.platform.testing.web.controller.rest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TestControllerTest {

    private TestController testController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        testController = new TestController();
        mockMvc = standaloneSetup(testController).build();
    }

    @Test
    public void testGetTest() {
    }
}