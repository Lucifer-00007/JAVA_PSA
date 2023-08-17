package app_java_5;
//Accessing private method and variable inside same class.  
public class A {
	private int x = 10;
	private void test() {
		System.out.println(1000); 
	}
	public static void main(String[] args) {
		A a1 = new A();
		System.out.println(a1.x);
		a1.test();
	}
}
