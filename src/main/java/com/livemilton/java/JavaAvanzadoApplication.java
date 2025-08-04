package com.livemilton.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class JavaAvanzadoApplication {

	public static void main(String[] args) {

		//ArrayList Generic with String
		ArrayList<String> list = new ArrayList<>();
		list.add("milton");
		list.add("Nico");

		for(String name: list){
			System.out.println(name.toUpperCase());
		}
		System.out.println("******************");

		//Box Generic in string
		Box<String> stringBox = new Box<>("milton");
		System.out.println(stringBox.getValue());

		//Box generic in integer
		Box<Integer> integerBox = new Box<>(10);
		System.out.println(integerBox.getValue());
		System.out.println("******************");


	}

}
