#include<iostream>
#include<math.h>
#include<vector>
#include<array>
#include<map>
#include<assert.h>

using namespace std;

class Memory
{
public:

	/** allocate memory spaces for process
	* Take input size: the number of spots the process requires in the memory
	* Take input process_number: the process that is allocating the memory
	*/
	void allocate(int size, int process_number) {
		vector<int>locations;
		assert(size <= open_spots && size >= 0);		//assert for incorrect input

		int counter = 0;
		for (int i = 0; i < 200; i++) {
			if (arr_[i] == 0) {
				arr_[i] = process_number;
				counter++;
				open_spots--;
				locations.push_back(i);
				if (counter == size) {
					bookkepping.insert(pair<int, vector<int>>(process_number, locations));
					return;
				}
			}
		}

	}

	/*delete the memory spaces after use */
	void deallocate(int process_number) {
		vector<int>locations = bookkepping[process_number];
		for (int i = 0; i < locations.size(); i++) {
			arr_[locations[i]] = 0;
			open_spots++;
		}
		bookkepping.erase(process_number);
	}

	/*merge memory locations of the same process*/
	void defragment(int process_number) {
		int size = bookkepping[process_number].size();
		int counter = 0;
		int i = 0;
		for (i = 0; i < 200; i++) {
			if (arr_[i] == 0 || arr_[i] == process_number) {
				counter++;
				if (size == counter)break;
			}
			else {
				counter = 0;
			}
		}
		vector<int> locations = bookkepping[process_number];
		for (int j = 0; j < size; j++) {
			arr_[locations[j]] = 0;
		}
		vector<int>new_locations;
		for (counter = i - size + 1; counter < i; counter++) {
			arr_[counter] = process_number;
			new_locations.push_back(counter);
		}
		bookkepping.erase(process_number);
		bookkepping.insert(pair<int, vector<int>>(process_number, new_locations));


	}
	void printloc(int process_number) {
		vector<int>locations = bookkepping[process_number];
		for (int i = 0; i < locations.size(); i++) {
			cout << locations[i] << " ";
		}
	}

	/* Variables */
	int open_spots = 200;
	int arr_[200] = {};
	map<int, vector<int>> bookkepping;


};


int main() {
	Memory mem;

	for (int i = 0; i < 200; i++) {
		cout << mem.arr_[i];
	}
	cout << "\n";
	mem.allocate(10, 1);
	mem.allocate(5, 2);
	mem.allocate(5, 3);
	mem.deallocate(2);
	mem.allocate(10, 4);
	mem.printloc(4);
	cout << "\n";
	mem.defragment(4);
	mem.printloc(3);
	cout << "\n";
	mem.printloc(4);
	return 0;
}


