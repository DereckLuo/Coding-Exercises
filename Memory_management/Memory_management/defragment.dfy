method defragment(process_numbers: int, open_spots : int, arr_: array<int>, bookkepping: map<int, array<int>> ) returns(os: int, arr: array<int>, bk: map<int,array<int>>)
/*place pre condition and post condition*/
{
  /*taking input variables */
  var p := process_numbers;
  var o := open_spots;

  /*local variables*/
  var size := bookkepping[p].Length;
  var counter := 0;
  var i := 0;
  while(i < 200){
    if(arr_[i] == 0 || arr_[i] == p){
      counter := counter + 1;
      if (size == counter){
        break;
      }
      else{
        counter := 0;
      }
    }
    i := i + 1;
  }

  var locations := bookkepping[p];
  var j := 0;
  while(j < size){
    arr_[locations[j]] := 0;
    j := j + 1;
  }

  var new_locations := new array<int>;
  var new_counter := i - size + 1;
  var new_idx := 0;
  while(new_counter < i){
    arr_[new_counter] := p;
    new_locations[new_idx] := new_counter;
    new_idx := new_idx + 1;
    new_counter := new_counter + 1;
  }
  bk := bookkepping[p := new_locations];
}