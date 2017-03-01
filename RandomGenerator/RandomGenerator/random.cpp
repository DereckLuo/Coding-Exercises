#include<math.h>
#include<iostream>
#include<vector>
#include<string>
#include<stdlib.h>
#include<stdio.h>
#include<time.h>



using namespace std;

int main() {
	srand(time(NULL));
	vector<string> input = {	"Destihl",
								"Seven Saints",
								"Kofusion",
								"Sushi Kame",
								"301",
								"pizza factory", 
								"PAR!", 
								"Sian", 
								"Dos Reales Mexican",
								"Sichuan China",
								"Alexander Steak"
							};

	cout << "Food is from: " << input[rand() % input.size()] << "\n";

	return 0;
}