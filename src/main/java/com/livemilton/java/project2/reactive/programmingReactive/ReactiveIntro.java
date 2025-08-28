package com.livemilton.java.project2.reactive.programmingReactive;

import io.reactivex.rxjava3.core.Observable;

public class ReactiveIntro {
    public static void main(String[] args) {
        //1-example
        //just method , create an observable and emit sequentially the elements that contain
        Observable<String> courseStream = Observable.just("HTML", "CSS", "JAVA", "C");

        courseStream.subscribe(
                item -> System.out.println("Recibido: " + item),
                error -> System.out.println(error.getMessage()),
                ()-> System.out.println("Finalizando..")
        );


    }
}
