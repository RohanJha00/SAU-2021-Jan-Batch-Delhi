package com.spring.au;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DrawingApp {

	public static void main(String[] args) throws IOException {

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        Rectangle rectangle = (Rectangle)factory.getBean("rectangleObj");

		rectangle.draw();
//		
	}

}
