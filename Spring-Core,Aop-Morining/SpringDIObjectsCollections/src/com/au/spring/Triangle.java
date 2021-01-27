package com.au.spring;

import java.util.Map;

public class Triangle {
	
	private Map<String,Point> pointMap;

	public Map<String, Point> getPoint() {
		return pointMap;
	}

	public void setPoint(Map<String, Point> pointMap) {
		this.pointMap = pointMap;
	}
	
	public void draw() {

		for(Map.Entry<String, Point> point :  this.pointMap.entrySet()){
			System.out.println( point.getKey() + ": " + point.getValue().getX() + "," + point.getValue().getY() );
		}

	}

}
