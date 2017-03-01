package co.edureka;

class Table{
	//synchronized void printTable(int num){
	void printTable(int num){
		for(int i=1;i<=10;i++){
			System.out.println(num+" "+i+"'s are "+(num*i));
		}
	}
}

class PrintThread1 extends Thread{
	Table t; // 4001 -> Points to the same object
	
	PrintThread1(Table u) {
		t = u;
	}
	
	@Override
	public void run() {
		synchronized (t) { // synchronized blocks -> acquire lock on t
			t.printTable(5);
		}
	}
}

class PrintThread2 extends Thread{
	Table t; // 4001 -> Points to the same object
	
	PrintThread2(Table u) {
		t = u;
	}
	
	@Override
	public void run() {
		synchronized (t) {
			t.printTable(7);
		}
	}
}

public class PrintTable {

	public static void main(String[] args) {
		
		Table t = new Table(); // Object of Table | t is having address of the object (4001)
		
		// Both of these threads are going to access the same object
		PrintThread1 th1 = new PrintThread1(t);
		PrintThread2 th2 = new PrintThread2(t);
		
		th1.start(); // start function calls run function internally
		th2.start();

	}

}
