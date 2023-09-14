package com.vtxlab.democalculater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoCalculaterApplication {//呢個class 可以autowire，因為有@configuration，自己都都係一個bean，所以可以autowired
	

	private static ConfigurableApplicationContext context; // belong to class
	private static String[] beans;


	public String[] getBean() {
		return beans;
	}

	public static void main(String[] args) {
		context = SpringApplication.run(DemoCalculaterApplication.class, args);
		// 有return type ： ConfigurableApplicationContext
		// extends ApplicationContext
		beans = context.getBeanDefinitionNames();

	}

}
