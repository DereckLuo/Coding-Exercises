public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int arr[] = {10,20,30,40,50};
		//int[] arr = {10,20,30,40,50};

		//int i = 10;
		//System.out.println("i is: "+i);
		
		// arr is a reference variable -> it is holding reference to array
		
		/*int arr[] = new int[5];
		
		for(int j=0;j<5;j++){
			arr[j] = j+10;
		}
		
		System.out.println("arr is: "+arr);
		
		for(int i=0;i<5;i++){
			System.out.println(arr[i]);
		}*/
		
		
		//int[][] arr = {{1,2,3},{4,5,6},{7,8}};
		
		/*int arr[][] = new int[3][3];
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+"  ");
			}
			System.out.println();
		}
		
							 //[how many 1d arrays] [how many elements in 1d array]
		int[][] brr = new int[5][];
		brr[0] = new int[1];
		brr[1] = new int[2];
		brr[2] = new int[3];
		brr[3] = new int[4];
		brr[4] = new int[5];
		
		
		for(int l=0;l<brr.length;l++){
			for(int m=0;m<brr[l].length;m++){
				System.out.print(brr[l][m]+"  ");
			}
			System.out.println();
		}
		
		//int[][] crr = new int[][]; err
		//int [][] drr = new int[][5]; err
		
		// Reverse of a String
		String abc = "SHIPRA";				
		int len = abc.length();
		char[] str = new char[len];		
		for (int i = 0; i <= len-1; i++) {
			//System.out.println(abc.charAt(i));
			str[i]=abc.charAt(i);					
		}				
		for (int j = len-1; j >= 0; j--) {
			System.out.print(str[j]);
		}*/
		
		int arr[][] = {{10,20,30},{40,50,60},{70,80,90}}; // [],[],[]
		//				  0          1          2
		
		
		/*for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}*/
		
		// Enhanced For Loop / ForEach
		
		for(int[] arrElem : arr){
			for(int element : arrElem){
				System.out.println(element);
			}
			System.out.println();
		}
	
		
		//for(int element : arr){
		//	System.out.println(element);
		//}
		
		
		
	}

}
