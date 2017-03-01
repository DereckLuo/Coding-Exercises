method deallocate(process_numbers: int, open_spots : int, arr_: array<int>, bookkepping: map<int,array<int>> ) returns(os: int, arr: array<int>, bk: map<int,array<int>>)
/*place pre condition and post condition*/
{
  /*taking input variables */
  var p := process_numbers;
  var o := open_spots;

  /*local variables*/
  var locations := bookkepping[p];
  var i:= 0;
  while(i < locations.Length)
  /* place loop invariance here*/
  {
    arr_[locations[i]] := 0;
  	i := i + 1;  
  }
  bk := map i | i in bk && i != p :: bk[i];
  os := o;
  arr := arr_;
}