public class LoopsAndConditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		// Integer - byte short int long
		
		/*byte a = 40;
		byte b = 30;
		byte c = 20;
		
		if(a>b){
			if(a>c){
				System.out.println("a is greatest: "+a);
			}else{
				System.out.println("c is greatest: "+c);
			}
		}else{
			if(b>c){
				System.out.println("b is greatest: "+b);
			}else{
				System.out.println("c is greatest: "+c);
			}
		}*/
		
		/*int age = 24;
		
		switch(age){
			case 10:
				
				break;
				
			case 18:
				//....
				break;
					
			case 24:
				
				break;
		}*/
		
		int num = 5;
		int i = 100;
		
		/*
		 for(int i=1;i<=10;i++){
			System.out.println(num+" "+i+"'s are "+(num*i));
		 }
		
		System.out.println("--------------------");
		
		// Nested For Loop
		for(int j=0;j<5;j++){
			System.out.println("j is: "+j);
			for(int k=0;k<5;k++){
				System.out.print(k+" ");
			}
			System.out.println();
		}*/
		
		
		while(i<=10){ // Condition is checked at entry level
			System.out.println(num+" "+i+"'s are "+(num*i));
			i++;
		}
		
		System.out.println("-------------------");
		
		num = 7;
		i = 100;
		do{
			System.out.println(num+" "+i+"'s are "+(num*i));
			i++;
		}while(i<=10); // condition is checked at exit level
		
		
	}
}
