//Trying to access private variable method from different package in sub and no-sub class.

package p2;
import p1.A;
public class C extends A{
	public static void main(String[] args) {
		A a1 = new A();
		a1.test1(); //error
	    System.out.println(a1.x); //error 
		
	}
}
