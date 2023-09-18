package com.vtxlab.demo.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcrest -> Matched
// Junit5 -> jupiter ->@Mock , @InjectMock , Mockito(when)
// Spring Test Framework -> @WebMvcTest
// what is @SpringBootTest?
@SpringBootTest // With a complete coontext
// mvn test -> Simulate App Server Start & Bean Injection on Context
class DemoResttemplateApplicationTests {

	@Test
	void contextLoads() {}// Test Server Start

}
