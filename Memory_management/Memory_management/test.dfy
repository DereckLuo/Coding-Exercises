	/**
	 * allocate:
	 *	Function to allocate memory locations for processor 
	 **/
	method allocate(arr_: array<int>, tracking: array<int>, open_spots: int, process_number: int, process_size: int, bookkeeping: array2<int>)returns(collection: set<int>)
	requires arr_ != null 	//memory is not null
	requires bookkeeping != null //tracking table is not null
	requires tracking != null
	requires 0 <= process_number < bookkeeping.Length0	//valid process number
	requires arr_.Length == tracking.Length == bookkeeping.Length0 == bookkeeping.Length1
	requires forall m :: 0 <= m < arr_.Length ==> arr_[m] != process_number	//memory doesn't contain process before hands 
	requires forall m :: 0 <= m < bookkeeping.Length1 ==> bookkeeping[process_number, m] == -1;	//map doesn't contain process before hands
	requires 0 < process_size <= open_spots	//valid process_size 

	modifies arr_
	modifies bookkeeping
	modifies tracking 

	//ensures forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) <==> (m in collection))	//new processor location matches with map
	//ensures forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m))
	//ensures forall n:: 0 <= n < bookkeeping.Length1 ==> ((bookkeeping[process_number, n] != -1) <==> (bookkeeping[process_number, n] in collection))
	//ensures forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == old(arr_[m])) <==> (m !in collection))		//everything else are not modified 
	//ensures forall n:: 0 <= n < bookkeeping.Length1 ==> ((bookkeeping[process_number, n] == -1) <==> (bookkeeping[process_number,n] !in collection))
	{
		var i := 0;
		var book_idx := 0;
		var size := process_size;
	  	collection := {};


	  	assert forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m));
	  	assert forall m:: 0 <= m < arr_.Length ==> (arr_[m] != process_number);

		while(i < arr_.Length)
	  	invariant i <= arr_.Length
	  	invariant i <= bookkeeping.Length1
	  	invariant process_number < bookkeeping.Length0
	  	invariant 0 <= book_idx <= i
	  	
	  	//invariant forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) <==> (m in collection))	//new processor location matches with map
	  	//invariant forall n:: 0 <= n < bookkeeping.Length1 ==> ((bookkeeping[process_number, n] != -1) <==> (bookkeeping[process_number, n] in collection))
		//invariant forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == old(arr_[m])) <==> (m !in collection))		//everything else are not modified 
		//invariant forall n:: 0 <= n < bookkeeping.Length1 ==> ((bookkeeping[process_number, n] == -1) <==> (bookkeeping[process_number,n] !in collection))
		//invariant forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m))
		{
			//assert forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m));
			if(arr_[i] == -1){
				//assert forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m));
				assert 0 <= i < arr_.Length;
				assert 0 <= book_idx < bookkeeping.Length1;
				arr_[i] := process_number;
				bookkeeping	[process_number, book_idx] := i;
				assert arr_[i] == process_number && bookkeeping[process_number,book_idx] == i;
				assert exists j:: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] != -1;
				//assert forall m:int :: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) ==> (exists j:int:: 0 <= j < bookkeeping.Length1 && bookkeeping[process_number,j] == m));
				book_idx := book_idx + 1;
				size := size - 1;
				//PrintArray(arr_);
				//print2DArray(bookkeeping);
	      		//var temp := {i};
				//collection := collection + temp;
			}
			if(size == 0){
				tracking[process_number] := 1;
				print "\n-----------------test-----------------\n";
				print " \n Process number is : "; print process_number; print " Process size is : "; print process_size;
				print "\n~~~~~~~~~~~~~ memory ~~~~~~~~~~~~~~\n";
				PrintArray(arr_);
				print "\n~~~~~~~~~~~~~ Tracker ~~~~~~~~~~~~~~\n";
				PrintArray(tracking);
				print "\n~~~~~~~~~~~~~ Table ~~~~~~~~~~~~~~~\n";
				print2DArray(bookkeeping);
				//assert forall m:: 0 <= m < arr_.Length ==> ((arr_[m] == process_number) <==> (m in collection));
				return;
			}
			i := i + 1;
		}
	}

	/**
	 *	deallocate:
	 *		Function to deallocate the memory locations for a specific process
	 **/
	//method deallocate(process_number: int, open_spots: int, arr_: array<int>, bookkeeping: map<int,array<int>>) returns(bk: map<int,array<int>>)
	//requires arr_ != null	//memory is not null
	//requires process_number in bookkeeping  //process being allocated before
	//requires bookkeeping[process_number] != null
	//requires bookkeeping[process_number].Length <= arr_.Length
	//requires forall m:: 0 <= m < bookkeeping[process_number].Length ==> (bookkeeping[process_number][m] < arr_.Length && bookkeeping[process_number][m] >= 0) || bookkeeping[process_number][m] == -1
	//modifies arr_
	//ensures forall m:: 0 <= m < bookkeeping.Length ==> m != process_number
	//ensures forall m:: 0 <= m < arr_.Length ==> arr_[m] != process_number
	//{
	//
	//	/*local variables*/
	//	var locations := bookkeeping[process_number];
	//	var i:= 0;
	//	while(i < locations.Length)
	//  invariant locations.Length <= arr_.Length
	//  invariant i <= locations.Length
	//  invariant forall m:: 0 <= m < locations.Length ==> (locations[m] < arr_.Length && locations[m] >= 0) || locations[m] == -1
	//	{
	//    if locations[i] != -1{
	//      arr_[locations[i]] := 0;
	//    }
	//		i := i + 1;
	//	}
	//	bk := map i | i in bookkeeping && i != process_number :: bookkeeping[i];
	//}

	/**
	 * Finding empty spots:
	 **/
	method empty(arr_: array<int>) returns( open_spots: int)
	requires arr_ != null
	{
		var i := 0;
		open_spots := 0;
		while( i < arr_.Length){
			if arr_[i] == -1{
				open_spots := open_spots + 1;
			}
			i := i + 1;
		}
	}

	/**
	 * Function: check if processor in memory already
	 */
	method checkMemory(arr_: array<int>, process_number: int)returns(ret: bool)
	requires arr_ != null
	ensures (forall m:: 0 <= m < arr_.Length ==> arr_[m] != process_number) <==> ret == true		//ensures ret is true iff no process_number in memory
	{
		var i := 0;
		while(i < arr_.Length)
		invariant 0 <= i <= arr_.Length
		invariant forall n :: 0 <= n < i ==> arr_[n] != process_number
		{
			if (arr_[i] == process_number){
				return false;                                                                    
			}
			i := i + 1;
		}
		assert(forall m::0 <= m < arr_.Length ==> arr_[m] != process_number);
		return true;
	}

	/**
	 *	Function: check if the processor in the map 
	 **/
	method checkMap(bookkeeping: array2<int>, process_number: int)returns (ret: bool)
	requires bookkeeping != null
	requires 0 <= process_number < bookkeeping.Length1
	requires 0 <= process_number < bookkeeping.Length0

	ensures (forall m:: 0 <= m < bookkeeping.Length1 ==> bookkeeping[process_number, m] == -1) <==> ret == true
	{
		var i := 0;
		while(i < bookkeeping.Length1)
		invariant 0 <= i <= bookkeeping.Length1
		invariant forall n:: 0 <= n < i ==> bookkeeping[process_number, n] == -1
		{
			if(bookkeeping[process_number, i] != -1){
				return false;
			}
			i := i + 1;
		}
		return true;
	}



	/**
	 *	Function to check if process number is valid 
	 *	should be in between 0 to 200, including 0, not including 200
	 **/
	method checkProcessNumber(arr: array<int>, number: int)returns(ret: bool)
	requires arr != null
	ensures number >= 0 && number < arr.Length <==> ret == true
	{
		if(number >= 0 && number < arr.Length){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *	Function deallocate check
	 *	Check if the process ID is valid, check if process book matches with memory
	 **/
	method deallocateCheck(arr: array<int>, bookkeeping: array2<int>, process_number: int)returns(ret: bool)
	requires arr != null
	requires bookkeeping != null 
	requires 0 <= process_number < bookkeeping.Length0
	{
	
	}


	/**
	 *	Function to print out an array
	 **/
	method PrintArray(a : array<int>)
	  requires a != null
	{
	  var i := 0;
	  while i < a.Length {
	    if i != 0 {
		  print ", ";
		}
	    print a[i];
	    i := i + 1;
	  }
	  print "\n";
	}

	/**
	 * Function to print out 2D array
	 **/
	method print2DArray(a: array2<int>)
	requires a != null
	{
		var i := 0;
		var j := 0;
		while i < a.Length0{
			j := 0;
			while(j < a.Length1){
				print a[i,j];
				print ", ";
				j := j + 1;
			}
			print "\n";
			i := i + 1;
		}
		print "\n";
	}

	/**
	 *	Function to create 2D array
	 **/
	method create2DArray(arr: array<int>)returns (ret : array2<int>)
	requires arr != null
	ensures ret != null
	ensures ret.Length0 == arr.Length
	ensures ret.Length1 == arr.Length
	{
		ret := new int[arr.Length,arr.Length];
		var i := 0;
		var j := 0;

		while(i < ret.Length0){
			j := 0;
			while(j < ret.Length1){
				ret[i,j] := -1;
				j := j + 1;
			}
			i := i + 1;
		}

		return ret;
	}

	/**
	 *	Function initialize the bookkeeping map
	 **/
	method initBook(bookkeeping: array2<int>)
	requires bookkeeping != null
	modifies bookkeeping
  	ensures forall i,j :: 0 <= i < bookkeeping.Length0 && 0 <= j < bookkeeping.Length1 ==> bookkeeping[i,j] == -1
	{
  		forall i,j | 0 <= i < bookkeeping.Length0 && 0 <= j < bookkeeping.Length1 
  		{
    		bookkeeping[i,j] := -1;
  		}
	}

	/**
	 *	Function create memory
	 **/
	method createMemory(size: int) returns (ret: array<int>)
	requires size > 0
	ensures ret != null
	ensures ret.Length == size
	{
		ret := new int[size];
		var i := 0;
		while( i < ret.Length){
			ret[i] := -1;
			i := i + 1;
		}
		return ret;
	}

	/**
	 *	Function initialize memory
	 *	Requires: 1. array is not null
	 *			  2. array contains all -1
	 **/
	method initMemory(arr: array<int>)
	requires arr != null
	modifies arr 
	ensures forall m:: 0 <= m < arr.Length ==> arr[m] == -1
	{
		var i := 0;
		while( i < arr.Length)
		invariant i <= arr.Length
		invariant forall m:: 0 <= m < i ==> arr[m] == -1
		{
			arr[i] := -1;
			i := i + 1;
		}
	}

	/**
	 *	Function initialize process tracking 
	 **/
	method initTracking(arr: array<int>, tracking : array<int>, bookkeeping: array2<int>)
	requires tracking != null
	requires arr != null
	requires bookkeeping != null
	requires arr.Length == tracking.Length == bookkeeping.Length0 == bookkeeping.Length1
	requires forall m:: 0 <= m < arr.Length ==> arr[m] == -1
	requires forall i,j:: 0 <= i < bookkeeping.Length0 && 0 <= j < bookkeeping.Length1 ==> bookkeeping[i,j] == -1
	modifies tracking

	ensures forall i :: 0 <= i < tracking.Length ==> tracking[i] == -1				//ensure tracking is proper init
	ensures forall i :: 0 <= i < tracking.Length ==> (tracking[i] != -1 ==> (exists j:int :: 0 <= j < arr.Length && arr[j] == i))	//ensure tracking links with memory 
	ensures forall i :: 0 <= i < tracking.Length ==> (tracking[i] == -1 ==> (forall j:: 0 <= j < arr.Length ==> arr[j] != i))
	ensures forall i :: 0 <= i < tracking.Length ==> (tracking[i] != -1 ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[i,j] != -1))	//ensures tracking links with bookkeeping
	ensures forall i :: 0 <= i < tracking.Length ==> (tracking[i] == -1 ==> (forall j:: 0 <= j < bookkeeping.Length1 ==> bookkeeping[i,j] == -1))
	{
		var i := 0;
		while(i < tracking.Length)
		invariant i <= tracking.Length
		invariant forall m:: 0 <= m < i ==> tracking[m] == -1;
		{
			tracking[i] := -1;
			i := i + 1;
		}
	}

	/**
	 *	Function allocateCheck
	 *		Check if the given process can be allocated onto memory
	 **/
	method allocateCheck(arr: array<int>, tracking : array<int>, bookkeeping : array2<int>, process_number : int)returns (ret: bool)
	requires arr != null
	requires tracking != null
	requires bookkeeping != null
	requires arr.Length == tracking.Length == bookkeeping.Length0 == bookkeeping.Length1
	requires forall i :: 0 <= i < tracking.Length ==> (tracking[i] != -1 ==> (exists j:int :: 0 <= j < arr.Length && arr[j] == i))	//requires tracking links with memory 
	requires forall i :: 0 <= i < tracking.Length ==> (tracking[i] != -1 ==> (exists j:int :: 0 <= j < bookkeeping.Length1 && bookkeeping[i,j] != -1))	//requires tracking links with bookkeeping
	requires forall i :: 0 <= i < tracking.Length ==> (tracking[i] == -1 ==> (forall j:: 0 <= j < arr.Length ==> arr[j] != i))
	requires forall i :: 0 <= i < tracking.Length ==> (tracking[i] == -1 ==> (forall j:: 0 <= j < bookkeeping.Length1 ==> bookkeeping[i,j] == -1))

	ensures ret == true ==> process_number >= 0 && process_number < arr.Length
	ensures ret == true ==> tracking[process_number] == -1
	ensures ret == true ==> forall i:: 0 <= i < arr.Length ==> arr[i] != process_number
	ensures ret == true ==> forall i:: 0 <= i < bookkeeping.Length1 ==> bookkeeping[process_number,i] == -1;
	{
		//check process number 
		if(process_number < 0 || process_number >= arr.Length){
			return false;
		}
		//check memory
		else if(tracking[process_number] != -1){
			return false;
		}
		else{
			return true;
		} 
	}


	/*Main function*/
	method Main()
	{
		//creating the memory and bookkeeping
		var arr := new int[200]; 
		initMemory(arr);
		var bookkeeping := new int[arr.Length, arr.Length];
		initBook(bookkeeping);
		var process_tracking := new int[arr.Length];
		initTracking(arr, process_tracking, bookkeeping);
		
		PrintArray(arr);
		var os := empty(arr);
		print "Number of open spots are : ";
		print os;
		print "\n";

		//allocating a process 
		var process_number := 1;
		var process_size := 10;
		var goodAllocate := allocateCheck(arr, process_tracking, bookkeeping, process_number);
		if(goodAllocate && process_size <= os){
			var ret := allocate(arr,process_tracking,os,process_number, process_size, bookkeeping);
		}
//		var valid_processId:= checkProcessNumber(arr, process_number);	//check valid process id 
//		if(valid_processId){
//			var check_memory := checkMemory(arr,process_number);	//check memory for process
//			var check_map := checkMap(bookkeeping, process_number);	//check map for process
//
//	  		if(check_memory && check_map && os >= process_size){
//			var ret := allocate(arr,os,process_number,process_size,bookkeeping);
//			}
//			else{
//				print "There isn't enough space in the memory! \n";
//			}
//			PrintArray(arr);
//		}
//
//		//deallocating a process
//		process_number := 1;
//		valid_processId := checkProcessNumber(arr, process_number);
//		if(valid_processId){
//			var goodDeallocate := deallocateCheck(arr, bookkeeping, process_number);
//		}
	}

