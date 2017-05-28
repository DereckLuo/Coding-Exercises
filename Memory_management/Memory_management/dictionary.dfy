datatype ENTRY = PACK(key: int, val: array<int>)
 datatype RES = NONE | SOME(array<int>)

 class DICT{
  var table: array<ENTRY>;  // array to store entries
  var elems: int;           // number of entries in dictionary
  var tsize : int;          // maximum size of dictionary

// Check if dictionary is valid 
function RepInv() : bool
  reads this, table;
  {
    table != null && 
    0 <= elems <= tsize && 
    (tsize > 0) && tsize == table.Length
    && forall i :: 0 <= i < elems ==>
        forall j :: 0 <= j < elems ==> 
        i != j ==> table[i].key != table[j].key
  }

//initialize dictionary 
method init(size : int)
  requires size > 0;
  //requires RepInv();
  ensures RepInv();
  ensures tsize == size && elems == 0;
  ensures fresh(table)
  modifies this;
  
  {
    table := new ENTRY[size];
    elems := 0;
    tsize := size;
  }

//return number of element in the dictionary
method size()returns(s:int)
requires RepInv();
ensures RepInv();
{
  return elems;
}


// link a key with a value 
method assoc(k:int,v:array<int>)
 // associates val v to key k in the dictionary
 requires RepInv();
 requires 0 <= elems < tsize-1; // google says: it must have at least one empty position
 
 ensures RepInv();
 modifies this, table;

 {
  var pos: int := 0;
  
  while(pos < elems)
  invariant 0 <= pos <= elems;
  invariant forall  index :: 0 <= index < pos ==> table[index].key != k;  
  {
    if(table[pos].key == k){  //if found the old key, replace it and return 
      table[pos]:= PACK(k,v);
      return;
    } 
    pos:= pos+1;
  }
  
  //case did not see key in the dictionary
  table[elems] := PACK(k,v);
  
  elems := elems + 1; 
 }

//find value give it's key 
method find(k:int) returns (r:RES)
 // returns NONE if key k is not defined in the dict,
 // or SOME(v) if the dictionary
 requires RepInv();
 ensures RepInv();

 {
   var i: int := 0;
   while(i< tsize)
   invariant 0 <= i <= tsize;
   {
     if(table[i].key == k){
      r := SOME(table[i].val);
     }
     i := i+1;
   }
 }

 
 /**
  * Find index of specific element
  * if not contain the element -- return -1
  **/
 method searchIndex(k: array<int>) returns (posK: int)
  requires RepInv();
  ensures RepInv();
  ensures posK == -1 ==> forall x:: 0<= x < elems ==> table[x].val != k;
  ensures posK != -1 ==> ((0<=posK<elems) && table[posK].val == k);
  {
  var i: int := 0 ;
  posK := -1;
  while(i < elems)
  invariant 0 <= i <= elems ;
  //invariant posK == -1 ==> forall j :: (0<=j<posK) ==> table[j].key != k;
  invariant posK == -1 ==> forall j:: 0 <= j < i ==> table[j].val != k;
  invariant posK != -1 ==> ((0<i<posK) && table[i].val == k); 
  {
    if(table[i].val == k)
    {
      posK := i;
      break;
    }
    i:= i+1;
  }
 }

//delect a key value pair given a key
method delete(k:int)
 // removes any existing association of key k in the dictionary
 requires RepInv();
 ensures RepInv();
 requires k >= 0;
 modifies this, table;
 
 //ensures forall j:int :: 0<= j < tsize;

 {
  var r:RES := find(k);
   //var r: int := searchIndex(k); 
  var i: int;
   
  match r {
  case SOME(i) => 
    var j: int := searchIndex(i);
  
    if j != -1{
      table[j] := table[elems-1]; // index out of range. why?
      elems := elems -1;
    }
   
  case NONE => return;
  
  }
 
 }
 
}



