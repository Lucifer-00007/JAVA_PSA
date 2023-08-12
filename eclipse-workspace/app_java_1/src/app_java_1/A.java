package app_java_1;

public class A {
	A(int x) { // no of args=1, type=int
		System.out.println(x);
	}

	A(char x) { // no of args=1, type=char
		System.out.println(x);
	}

	A(double x) { // no of args=1, type=double
		System.out.println(x);
	}

	public static void main(String args[]) {
		A a1 = new A(10);
		A a2 = new A('t');
		A a3 = new A(15.5);
	}
}