/**
 * allocate:
 *	Function to allocate memory locations for processor 
 **/
method allocate(arr_: array<int>, open_spots: int, process_number: int, process_size: int, bookkeeping: map<int, array<int>>)returns(collection: set<int>,bk: map<int,array<int>>)
requires arr_ != null 	//memory is not null
requires process_size <= arr_.Length 	//process requires be able to fit into memory 
requires open_spots >= process_size 	//memory requires enough spaces for processor 
requires process_size > 0
modifies arr_
//modifies bookkeeping
ensures forall m:: 0 <= m < arr_.Length && (m in collection) ==> arr_[m] == process_number;     //ensures all required positions are correctlly modified
ensures forall m :: 0 <= m < arr_.Length && (m !in collection) ==> arr_[m] == old(arr_[m]);   //ensures all non-required positions did not change during the process
{
	var i := 0;
	var size := process_size;
  	collection := {};
  	/*local variable*/
  	var locations := new int[arr_.Length];
  	var location_idx := 0;
	
	while(i < arr_.Length)
  	invariant i <= arr_.Length
  	invariant location_idx <= i
  	//invariant size >= 0
  	invariant forall m:: 0 <= m < arr_.Length && (m in collection) ==> arr_[m] == process_number
  	invariant forall m:: 0 <= m < arr_.Length && (m !in collection) ==> arr_[m] == old(arr_[m])
	{
		if(arr_[i] == 0){
			arr_[i] := process_number;
      		var temp := {i};
			collection := collection + temp;
			size := size - 1;
			locations[location_idx] := i;
			location_idx := location_idx + 1;
		}
		if(size == 0){
			bk := bookkeeping[process_number := locations];
			return;
		}
		i := i + 1;
	}
}

/**
 *	deallocate:
 *		Function to deallocate the memory locations for a specific process
 **/
method deallocate(process_number: int, open_spots: int, arr_: array<int>, bookkeeping: map<int,array<int>>) returns(locations: array<int>, bk: map<int,array<int>>)
requires arr_ != null	//memory is not null
requires process_number in bookkeeping  //process being allocated before
requires bookkeeping[process_number] != null
requires bookkeeping[process_number].Length <= arr_.Length
requires process_number > 0 //valid process number
requires forall m:: 0 <= m < bookkeeping[process_number].Length ==> -1 <= bookkeeping[process_number][m] < arr_.Length    //map array is valid
requires forall m:: 0 <= m < bookkeeping[process_number].Length ==> (bookkeeping[process_number][m] != -1 ==> arr_[bookkeeping[process_number][m]] == process_number) //only map array stored process number 
requires forall m:: 0 <= m < bookkeeping[process_number].Length ==> (forall n:: 0 <= n < arr_.Length ==> (n != bookkeeping[process_number][m] ==> arr_[n] != process_number)) //everything else does not store process number
requires forall n:: 0 <= n < arr_.Length ==> arr_[n] == process_number ==> forall m:: 0 <= m <bookkeeping[process_number].Length ==> (bookkeeping[process_number][m] ==-1 || bookkeeping[process_number][m] == n)
modifies arr_
modifies bookkeeping[process_number]
//ensures forall m:: 0 <= m < bookkeeping.Length ==> m != process_number
ensures forall m:: 0 <= m < arr_.Length ==> arr_[m] != process_number //process not in the array anymore
{
	/*local variables*/
	//var locations := bookkeeping[process_number];
  //assert(forall m:: 0 <= m < locations.Length ==> (-1 <= locations[m] < arr_.Length));
	var i:= 0;
	while(i < bookkeeping[process_number].Length)
  invariant bookkeeping[process_number].Length <= arr_.Length
  invariant 0 <= i <= bookkeeping[process_number].Length
  //invariant forall m:: 0 <= m < locations.Length ==> (-1 <= locations[m] < arr_.Length)
  //invariant forall m:: 0 <= m < locations.Length ==> (locations[m] != -1 ==> arr_[locations[m]] == process_number)
  invariant forall m:: 0<= m < bookkeeping[process_number].Length ==> -1 <= bookkeeping[process_number][m] < arr_.Length
  invariant forall m:: 0 <= m < bookkeeping[process_number].Length ==> (forall n:: 0 <= n < arr_.Length ==> (n != bookkeeping[process_number][m] ==> arr_[n] != process_number)) //everything else does not store process number
  
	{
    
    if (bookkeeping[process_number][i] != -1){
      arr_[bookkeeping[process_number][i]] := 0;
      bookkeeping[process_number][i] := -1;
      assert (forall m:: 0 <= m < bookkeeping[process_number].Length ==> (bookkeeping[process_number][m] != -1 ==> arr_[bookkeeping[process_number][m]] == process_number || arr_[bookkeeping[process_number][m]] == 0));  
    }
    
		i := i + 1;
	}
  assert(forall m:: 0 <= m < arr_.Length ==> arr_[m] != process_number);
	bk := map i | i in bookkeeping && i != process_number :: bookkeeping[i];
}

/**
 * Finding empty spots:
 **/
method empty(arr_: array<int>) returns( open_spots: int)
requires arr_ != null
{
	var i := 0;
	open_spots := 0;
	while( i < arr_.Length){
		if arr_[i] == 0{
			open_spots := open_spots + 1;
		}
		i := i + 1;
	}
}

/*Main function*/
method Main()
{
	//creating the memory
	var bookkeeping := map[];
	var arr := new int[200];
	var i := 0;
	while(i < arr.Length){
		arr[i] := 0;
		i := i + 1;
	}
	PrintArray(arr);
	var os := empty(arr);
	print "Number of open spots are : ";
	print os;
	print "\n";

	if(os >= 10){
		var ret, m := allocate(arr,os,1,10,bookkeeping);
	}
	else{
		print "There isn't enough space in the memory! \n";
	}
	PrintArray(arr);

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