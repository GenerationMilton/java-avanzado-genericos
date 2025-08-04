package com.livemilton.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;

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

		//List with wildcard ? in printList wildcard method
		List<String> names = new ArrayList<>();
		names.add("Gabriel");
		names.add("Maria");

		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);

		printList(numbers);
		printList(names);

		sumNumbers(numbers);

		addNumbers(numbers);

	}

	//Wildcard ? , Can read all data with object type
	public static void printList(List<?> list){
		for(Object o:list){
			System.out.println(o);
		}
	}

	//Class with sumNumbers that extends - covariance - Permits extends number but forbidden add elements except null values
	public static void sumNumbers(List<? extends Number> numbers){
		double sum =0;
		for(Number num: numbers){
			sum += num.doubleValue();
		}
		System.out.println(sum);
	}

	//class with addNumbers that super class contravariance - accept list that number type, permit add,read object type
	public static  void addNumbers(List<? super Integer> numbers){
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		Object num = numbers.get(0);

		System.out.println(num);
	}

}
