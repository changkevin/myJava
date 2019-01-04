package com.zhang.myjava.generics;

import java.util.ArrayList;
import java.util.List;

//设定类型通配符的上限
//List<Circle>并不是List<Shape>的子类型
public class Canvas {
	public void drawAll(List<? extends Shape> shapes) {
		//shapes.forEach(s->s.draw(this));
		//shapes.add(0, new Circle()); //wrong
	}
	
	public static void main(String[] args) {
		List<Shape> list = new ArrayList<>();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		list.add(circle);
		list.add(rectangle);
		Canvas canvas = new Canvas();
		canvas.drawAll(list);
	}
}
