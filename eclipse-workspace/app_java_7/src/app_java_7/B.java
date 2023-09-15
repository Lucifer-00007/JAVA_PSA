//Polymorphism
package app_java_7;

public class B extends A{
	public void test() { //Here we are overriding the "test()" method 
		System.out.println(200);
	}
	public static void main(String[] args) {
		B b1 = new B();
		b1.test(); //200

		A a1 = new A();
		a1.test(); //100
		
	}
}
