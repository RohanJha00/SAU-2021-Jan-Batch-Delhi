package com.spring.au;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	Point pointA = new Point(10,10);
	Point pointB = new Point(20,10);
	Point pointC = new Point(20,20);
	Point pointD = new Point(10,20);

	@Bean(name="rectangleObj")
	public Rectangle getRectangle() {
		return new Rectangle(pointA,pointB,pointC,pointD);
	}
	
	@Bean(name="pointObj")
	public Point getPoint() {
		return new Point(10,20);
	}

}
