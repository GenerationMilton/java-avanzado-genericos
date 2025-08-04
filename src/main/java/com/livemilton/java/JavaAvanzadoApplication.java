package com.livemilton.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;

@SpringBootApplication
public class JavaAvanzadoApplication {

	public static void main(String[] args) {

		//ArrayList Generic with String
		System.out.println("******* ArrayList generic *******");
		ArrayList<String> list = new ArrayList<>();
		list.add("milton");
		list.add("Nico");

		for(String name: list){
			System.out.println(name.toUpperCase());
		}


		//Box Generic in string
		System.out.println("****** Generic Class *******");
		Box<String> stringBox = new Box<>("milton");
		System.out.println(stringBox.getValue());

		//Box generic in integer
		Box<Integer> integerBox = new Box<>(10);
		System.out.println(integerBox.getValue());



		//Call to utility class with generic
		System.out.println("****** Utility Class with generic method *******");
		Utility.printItem("Milton");
		Utility.printItem(10);

		Utility.printItem("Mitlon", 30);


		//Call Maths Utils with restrictions
		System.out.println("****** MathUtil Class with generic method with restriction*******");
		MathUtils.sum(2,2);

	}

}
