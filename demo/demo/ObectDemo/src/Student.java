// its a representation how an object will look like in the memory
// its a blueprint
class Student {
	// Data Members
	String name;
	int age;
	String email;
	char gender;
	String address;
	
	// Member Functions
	
	// Special Member Function
	// Name same as that of class
	// It has no return type as well
	// Constructor -> Takes no Argument or Input -> Default Constructor
	// Is automatically created by compiler in every class you create
	/*Student(){
		name = null;
		age = 0;
		email = null;
		gender = ' ';
		address = null;
	}*/
	
	Student(){
		name = "NA";
		age = 0;
		email = "NA";
		gender = 'N';
		address = "NA";
	}
	
	// Constructor with Arguments
	Student(String n, int a, String e, char g, String ad){
		name = n;
		age = a;
		email = e;
		gender = g;
		address = ad;
	}
	
	// 1. Setters
	void setName(String n){
		name = n;
	}
	
	void setAge(int a){
		age = a;
	}
	
	void setEmail(String e){
		email = e;
	}
	
	void setGender(char g){
		gender = g;
	}
	
	void setAddress(String a){
		address = a;
	}
	
	//2. Getters
	String getName(){
		return name;
	}
	
	int getAge(){
		return age;
	}
	
	char getGender(){
		return gender;
	}
	
	String getEmail(){
		return email;
	}
	

	String getAddress(){
		return address;
	}
	
}
