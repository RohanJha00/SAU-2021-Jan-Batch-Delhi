package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

//@Component
//@Scope(value = "prototype")
public class Rectangle {
	  
	  @Autowired
	  private Point pointA;

	  @Autowired
	  private Point pointB;

	  @Autowired
	  private Point pointC;

	  @Autowired
	  private Point pointD;


	public Rectangle(Point pointA, Point pointB, Point pointC, Point pointD) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.pointD = pointD;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	public void draw() {
	  	System.out.println("Rectangle Drawn with Points :");
		System.out.println("PointA : "+getPointA().getX()+","+getPointA().getY());
		System.out.println("PointB : "+getPointB().getX()+","+getPointB().getY());
		System.out.println("PointC : "+getPointC().getX()+","+getPointC().getY());
		System.out.println("PointD : "+getPointD().getX()+","+getPointD().getY());
	  }

	 
}
