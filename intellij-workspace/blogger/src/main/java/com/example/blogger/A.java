package com.example.blogger;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class A {
    public static void main(String[] args) {
        Function<Integer, String> myFunction = i -> "Result: " +i; //Function Functional Interface
        String val = myFunction.apply(100);
        System.out.println(val); //Result: 100

        Supplier<A> mySupplier = () -> new A();
        A s = mySupplier.get();
        System.out.println(s);

        Consumer<String> myConsumer= ss -> System.out.println("Consumed: "+ss);
        myConsumer.accept("Hello");
    }

}
