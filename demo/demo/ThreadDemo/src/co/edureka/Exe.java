package co.edureka;

class Thread1 extends Thread{ // Heavy Weight | Extra functions of thread class shall be inherited
	
	Thread1(String name){
		super(name); // Which sets the name of thread
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.println("**Thread1**");
			try {
				Thread.sleep(1000); // This thread will not be working for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Thread2 implements Runnable{ // Light Weight | No extra functions will be inherited into your class
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.println("@@Thread2@@");
			try {
				Thread.sleep(1000); // This thread will not be working for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/*	A case where Runnable shall be preferred
 * class MyClass extends Exception implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=10;i++){
			System.out.println("@@Thread2@@");
		}
	}
}*/

public class Exe {
	// Main Thread | th1 | th2 -> thy shall run in parallel
	public static void main(String[] args) {	
		System.out.println("Main Thread Started");
		
		Thread1 th1 = new Thread1("Alpha Thread");
		Runnable r = new Thread2(); // Polymorphic Behavior
		
		Thread th2 = new Thread(r); // We are passing reference of the object into Thread's Constructor
		th2.setName("Charlie Thread");
		
		th1.start();
		
		/*try {
			th1.join(); // tell CPU to execute all the tasks of th1 and rest of the threads shall wait
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		// Requests
		//th1.setPriority(Thread.MAX_PRIORITY); //10
		//th2.setPriority(Thread.NORM_PRIORITY);//5
		//Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//0
		
		th1.yield();
		
		th2.start();
		
		
		
		for(int i=1;i<=10;i++){
			System.out.println("--Main Thread--");
			try {
				Thread.sleep(1000); // This thread will not be working for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Thread.currentThread().setName("MyMain");
		
		System.out.println("Name of th1 is: "+th1.getName());
		System.out.println("Name of th2 is: "+th2.getName());
		System.out.println("Name of main is: "+Thread.currentThread().getName());
		
		
		System.out.println("Main Thread Finished");
	}
}
