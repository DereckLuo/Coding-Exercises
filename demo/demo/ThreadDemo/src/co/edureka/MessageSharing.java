package co.edureka;

class Message{
	String message;
	
	public Message() {
		message = "Nothing";
	}
	
	void writeMessage(String message){
		this.message = message;
	}
	
	String readMessage(){
		return message;
	}
}

class WriterThread extends Thread{
	Message m;
	
	WriterThread(Message m) {
		this.m = m;
	}
	
	@Override
	public void run() {
		synchronized (m) {
			m.writeMessage("Being Exceptional is thumb rule to success");
			System.out.println("Message Written");
			
			//m.notify();
			m.notifyAll();
		}
	}
}

class ReaderThread extends Thread{
	Message m;
	
	ReaderThread(Message m) {
		this.m = m;
	}
	
	@Override
	public void run() {
		synchronized (m) {
			
			try {
				m.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s = m.readMessage();
			System.out.println("Message Read: "+s);
		}
	}
}

public class MessageSharing {
	public static void main(String[] args) {
		Message m = new Message(); // message contains nothing
		ReaderThread rt1 = new ReaderThread(m);
		ReaderThread rt2 = new ReaderThread(m);
		WriterThread wt = new WriterThread(m);
		
		rt1.start(); // once this guy starts, it waits on m
		rt2.start(); // once this guy starts, it waits on m
		wt.start(); // when rt waits on m, wt writes in m and notifies rt to read
	}
}
