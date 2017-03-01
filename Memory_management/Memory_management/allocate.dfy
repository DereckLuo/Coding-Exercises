method allocate(size: int, process_numbers: int, open_spots : int, arr_: array<int>, bookkepping: map<int, array<int>> ) returns(os: int, s: int, counter: int, arr: array<int>, bk: map<int,array<int>>)
/*place pre condition and post condition*/
requires arr_ != null   //memory is not null 
requires size <= arr_.Length  //process requires fitable memory slots 
requires open_spots >= size //memory still has at least 1 open slots
requires size > 0
modifies arr_
ensures s == 0


{
  /*taking input variables */
  s := size;
  var p := process_numbers;
  var o := 0;//open_spots;
  
  /*local variables*/
  var locations := new int[arr_.Length];  

  var location_idx := 0;
  counter := 0;
  var cnt := 0;		//count number of memory slots that assigned
  var i:= 0;

  //get the number of open spots in the array
  while(i < arr_.Length)
  invariant i <= arr_.Length
  {
  	if (arr_[i] == 0){
  		o := o + 1;
  	}
  	i := i + 1;
  }
  if( o < s){
  	assert(o < s);
  	s := 0;
  	return;
  }

  assert( o >= size);
  assert(locations.Length == arr_.Length);
  i := 0;
  location_idx := i;
  while(i < arr_.Length) // loop through the entire array
  /* place loop invariance here*/
  invariant i <= arr_.Length
  invariant location_idx <= i
  invariant s == size - counter
  invariant o >= s
  {
  	assert(s == size - counter);
  	assert(i < arr_.Length);
  	assert(location_idx < arr_.Length);
  	assert(location_idx < locations.Length);
  	assert(o >= 0);
  	if (arr_[i] == 0){
  		assert(o >= 0);
  		arr_[i] := p;
  		o := o - 1;
  		s := s - 1;
  		counter := counter + 1;
  		locations[location_idx] := i;
  		if (size == counter){
  			assert(s == 0);
  			assert(s == size - counter);
  			bk := bookkepping[p := locations];
  			os := o;
       		cnt := counter;
        	arr := arr_;
        	return;
  		}
  		location_idx := location_idx + 1;
  	}
    i := i + 1;
  }
  //assert(s == size - counter);
}
