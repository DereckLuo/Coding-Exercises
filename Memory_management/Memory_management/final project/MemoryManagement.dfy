/**
 *  CS 477 Software Verification 
 *  December 2016
 *  Author: Chongxin Luo, Vignesh Sridhar
 *

/**
 * Function initialize memory 
 *	Function to initialize the memory given an initial memory size 
 **/
 method initMemory(size: int) returns (memory: array<int>)
 requires size > 0
 ensures memory != null
 ensures memory.Length == size
 ensures forall m:: 0 <= m < memory.Length ==> memory[m] == 0
 ensures fresh(memory)
 {
 	memory := new int[size];
 	forall(i | 0 <= i < memory.Length){
 		memory[i] := 0;
 	}
 	return memory;
 }

/**
 *  initTable()
 *  initialize the tracking dictionary
 **/
method initTable()returns(table: map<int,int>)
ensures |table| == 0;
{
  table := map[];
}

/**
 * initEmpty
 *  initialize the structure to track empty spots in the memory
 **/
method initEmpty()returns(empty: array<int>)
ensures empty != null
ensures empty.Length == 1
ensures empty[0] == 0
ensures fresh(empty)
{
  empty := new int[1];
  empty[0] := 0;
}

/**
 *  LinkMemory
 *    link up the memory with dictionary and empty 
 **/
method linkMemory(mem: array<int>, table: map<int,int>)
  requires mem != null;
  requires mem.Length > 0;
  requires forall m:int::0 <= m < mem.Length ==> mem[m] == 0;
  requires |table| == 0;

  ensures goodMemoryLink(mem, table);
{
    
}

/**
 * goodMemoryLink()
 **/
function goodMemoryLink(mem: array<int>, table:map<int, int>):bool
requires mem != null && mem.Length > 0;
reads mem;
{ 
  forall m:int:: 0 <= m < mem.Length ==> mem[m] != 0 ==> m in table 
  && forall m:int:: 0 <= m < mem.Length ==> mem[m] == 0 ==> m !in table
  && forall m:int:: m in table ==> 0 <= m < mem.Length
  && forall m:int:: m in table ==> mem[m] == table[m]
}

/**
 * allocatememory
 * allocate the memory for the given process, update memory, bk and emptyspot
 */
method allocate(pcnum: int, pcsize: int, mem: array<int>, table: map<int, int>)returns(ret:bool, newtable: map<int,int>)
 requires mem != null && mem.Length > 0;
 requires forall m:int:: 0 <= m < mem.Length ==> mem[m] == 0;
 requires goodMemoryLink(mem, table);

 modifies mem
 
 // ensures goodMemoryLink(mem, newtable);
 {
  /*validation check*/
  newtable := table;
  assert goodMemoryLink(mem, newtable);
  var slots := emptycount(mem);
  if(pcsize > slots || pcsize <= 0){
    print " Invalid pcsize: It might be negative or memory might be full\n";
    assert goodMemoryLink(mem,newtable);
    return false, newtable;
  }

  //var locations := locationarray(mem.Length);
  //assert forall m :int::0 <= m < locations.Length ==> locations[m] == -1 || (locations[m] >= 0 && locations[m] < mem.Length);
  var locations := [];
  assert forall m:int:: m in locations ==> m >= 0 && m < mem.Length && mem[m] == 0;

  var memidx:int := 0; var locidx := 0;
  var totalsize := pcsize;
  assert(totalsize > 0 && totalsize <= slots);

  assert goodMemoryLink(mem,newtable);
  assert goodMemoryLink(mem,table);
  while(memidx < mem.Length)
  //invariant mem.Length == locations.Length
  invariant 0 <= memidx <= mem.Length
  invariant 0 <= locidx <= memidx
  invariant totalsize >= 0
  invariant forall m:int:: m in locations ==> m >= 0 && m < mem.Length && mem[m] == 0;
  invariant goodMemoryLink(mem,table);
  //invariant forall m :int::0 <= m < locations.Length ==> locations[m] == -1 || (locations[m] >= 0 && locations[m] < mem.Length);
  {
    if(mem[memidx] == 0){
      //locations[locidx] := memidx;
      locations := locations + [memidx];
      locidx := locidx + 1;
      totalsize := totalsize - 1;
      assert memidx in locations;
      assert exists m:int:: 0 <= m < mem.Length && m in locations;
      assert forall m:int:: m in locations ==> m >= 0 && m < mem.Length && mem[m] == 0;
      if(totalsize == 0){
        assert exists m:int:: 0 <= m < mem.Length && m in locations;
        assert |locations| != 0;
        //assert exists m:int:: m >= 0 && m < locations.Length && locations[m] != -1;
        break;
      }
    }
    memidx := memidx + 1;
  }
  assert goodMemoryLink(mem,table);

  if(totalsize == 0){
    
    forall(i | i in locations)
    {
      mem[i] := pcnum;
    }

    newtable := table[pcnum := 1];

    // assert goodMemoryLink(mem, newtable);
    return true, newtable;
  }
  else{
    assert goodMemoryLink(mem,newtable);
    return false, newtable;
  }
}

/**
 *  locationarray
 **/
method locationarray(size:int)returns(r:array<int>)
requires size > 0
ensures r != null && r.Length == size
ensures forall i:int:: 0 <= i < r.Length ==> r[i] == -1;
ensures fresh(r);
{
  r := new int[size];
  forall(i | 0 <= i < size){
    r[i] := -1;
  }
  return r;
}


/**
 *  deallocate
 *   remove a process from the memory 
 **/
method deallocate(pcnum:int, mem:array<int>, table:map<int,int>)returns(ret:bool, newtable : map<int,int>)
requires mem != null && mem.Length > 0;
requires goodMemoryLink(mem, table);

modifies mem 

//ensures goodMemoryLink(mem, newtable);
{
  /*validation check*/
  newtable := table;
  if(pcnum !in table){
    print "Invalid deallocation: cant find the process!\n";
    return false, newtable;
  }

  var memidx:int := 0;
  while(memidx < mem.Length)
  invariant 0 <= memidx <= mem.Length
  {
    if(mem[memidx] == pcnum){
      mem[memidx] := 0;
    }
    memidx := memidx + 1;
  }
  newtable := map i | i in table && i != pcnum::table[i];
}


/**
 *  emptycount
 **/
method emptycount(mem:array<int>)returns(ret:int)
requires mem != null
{
  ret := 0;
  var i := 0;
  while(i < mem.Length)
  {
    if (mem[i] == 0){
      ret := ret + 1;
    }
    i := i + 1;
  }
}

function RecursiveCount(key: int, a: array<int>, from: nat) : int
    reads a
    requires a != null
    requires from <= a.Length
    decreases a.Length-from
{
    if from == a.Length then 0
    else if a[from] == key then 1+RecursiveCount(key, a, from+1)
    else RecursiveCount(key, a, from+1)
}



/**
 *  predicate:
 *    predicate indicate the numbers in bk are valid 
 **/
predicate bkvaluevalid(mem:array<int>, bk:array2<int>)
requires mem != null
requires bk != null
reads mem, bk 
{
  forall i,j:int :: 0 <= i < bk.Length0 && 0 <= j < bk.Length1 ==> bk[i,j] >= 0 && bk[i,j] < mem.Length
}

/**
 * function: bkmatch1 --> match bk with memory,
 *    check if the bookkeeping matches with the memory 
 **/
function bkmatch1(mem: array<int>, bk: array2<int>, idx:int): bool
reads mem, bk 
requires mem != null
requires bk != null
requires idx >= 0 && idx <= bk.Length0
requires mem.Length == bk.Length0 == bk.Length1
requires bkvaluevalid(mem,bk)
decreases bk.Length0-idx 
{
  if idx == bk.Length0 then true
  else bkmatch1(mem,bk,idx+1)
  // else if bkmatch2(mem,bk,idx,0) == true then bkmatch1(mem, bk, idx+1)
  // else false
}

/**
 * function: bkmatch2 --> helper function for bkmatch 1
 *  helper function to help bkmatch1
 **/
function bkmatch2(mem: array<int>, bk: array2<int>, idx1:nat, idx2:nat): bool
reads mem, bk
requires mem != null
requires bk != null
requires idx2 >= 0 && idx2 <= bk.Length1
requires idx1 >= 0 && idx1 < bk.Length0
requires mem.Length == bk.Length0 == bk.Length1
requires bkvaluevalid(mem,bk)
decreases bk.Length1-idx2
{
  if idx2 == bk.Length1 then true
  else if bk[idx1,idx2] == 0 then true
  else if mem[bk[idx1,idx2]] == idx1 then bkmatch2(mem,bk,idx1,idx2+1)
  else false
}








 /* main function */
 method memory_management_allocate(){
  print" Function Starts !\n";
 	var memorysize := 200;
 
 	/* initialize memory */
 	var mem := initMemory(memorysize);
 	/* initial bookkeeping */
  var table := initTable();
 	// var bk := initBookkeeping(memorysize);
 	/* initial emptytracking */
  var empty := initEmpty();
  /* link up memory with all trackers */
 	linkMemory(mem, table);

 	var pcnum := 1; var pcsize := 10; 

  var error, newtable := allocate(pcnum, pcsize, mem, table);
  if(error){
    print " allocate faled !\n";
  }
  table := newtable;
}

method memory_management_deallocate(){

  print" Function Starts !\n";
  var memorysize := 200;
 
  /* initialize memory */
  var mem := initMemory(memorysize);
  /* initial bookkeeping */
  var table := initTable();
  // var bk := initBookkeeping(memorysize);
  /* initial emptytracking */
  var empty := initEmpty();
  /* link up memory with all trackers */
  linkMemory(mem, table);

  var pcnum := 1; var pcsize := 10; 

  var error, newtable := allocate(pcnum, pcsize, mem, table);
  if(error){
    print " allocate faled !\n";
  }
  table := newtable;
}





