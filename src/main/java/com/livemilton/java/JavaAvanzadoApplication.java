package com.livemilton.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaAvanzadoApplication {

	public static void main(String[] args) {

		Operation operation = new Operation() {
			@Override
			public int operate(int a, int b) {
				return a+b;
			}
		};
		System.out.println(operation.operate(5,5));

		Operation multiply =(a,b) -> a * b;
		System.out.println(multiply.operate(5,5));

		Operation substraction= (a,b) -> a-b;
		System.out.println(substraction.operate(4,1));
	}

}

//interfaz funcional -crear la anotación - solo puede tener un solo metodo abstracto
//se pueden tener varios metodos por default y estaticos
@FunctionalInterface
interface Operation{
	int operate(int a, int b);

	default String show(){
		return "Soy una operacion";
	}

	default String show2(){
		return "Soy una operacion";
	}

	static Operation substraction(){
		return (a,b)-> a - b;
	}


}