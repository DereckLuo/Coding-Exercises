// 1 Constrcutors are not Inherited
// 2 For Inheritance, parent object shall be constructed first and then the child

class A{
	A(){
		System.out.println("This is in A");
	}
	A(int a){
		System.out.println("This is Parameterized in A: "+a);
	}
}

class B extends A{
	B(){
		super(10);
		//super(); // new A(); constrcut the object of Parent first
		System.out.println("This is in B");
	}
}


class C extends B{
	C(){
		//super(); super as a call is inserted by compiler so that we can hvae object of parent
		System.out.println("This is in C");
	}
}

class ConsInher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C cRef = new C();
	}

}
