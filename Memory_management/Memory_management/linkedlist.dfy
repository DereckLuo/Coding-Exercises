/*
   CS:5810 Formal Methods in Software Engineering
   Fall 2015
   The University of Iowa
   
   Instructor: Cesare Tinelli
*/

// Parametric linked lists


// Traditional (aclyclic) linked list implementation with a node containig 
// the list element and a reference to the rest of the list.
// Empty lists are represented simply by null. 
// Hence non-null values of type Node<T> represent non-empty lists.



class Node<T> {
  // abstract variable storing the list of elements in sequence (in the same order)
  ghost var list: seq<T>;

  // Heap frame, 
  // Consists of the set of nodes constituting the list headed by 'this'
  ghost var nodes: set<Node<T>>;

  // element stored in the node
  var elem: T;
  // next node in the list, if any
  var next: Node<T>;

  // The invariant predicate provides a definition of 'list' and 'nodes'
  // by induction of the length of the list
  predicate Valid()
    reads this, nodes;
  {
     //this in nodes &&      
     null !in nodes &&
     if next == null then (
       nodes == {this} && 
       list == [elem]
     )
     else (
       next in nodes &&
       nodes == {this} + next.nodes &&
       // acyclity condition
       this !in next.nodes &&
       list == [elem] + next.list &&
       next.Valid()
     )
  }
  
  // Makes 'this' the head of a sigleton list containg element 'e'
  constructor singleton(e: T)
    modifies this;
    ensures Valid();
    ensures list == [e];
  {
    elem := e;
    next := null;

    list := [e];
    nodes := {this};
  }

  // Makes 'this' the head of a non-sigleton list containg element 'e' 
  // and continuing with the list headed by 'n'
  constructor insert(e: T, n: Node<T>)
    modifies this;
    requires n != null;
    requires n.Valid();
    requires this !in n.nodes; 
    ensures Valid();
    ensures list == [e] + n.list;
  {
    elem := e;
    next := n;

    list := [e] + n.list;
    nodes := {this} + n.nodes;
  }

  // Returns the (possibly empty) tail of the list headed by 'this'
  method tail() returns (t: Node<T>)
    requires Valid();
    ensures Valid();
    ensures t == null ==> |list| == 1;
    ensures t != null ==> t.Valid() &&
                          t.nodes <= nodes &&
                          t.list == list[1..];
  {
     t := next;
  }

  // Returns the element stored in the head of the list
  method head() returns (e: T)
    requires Valid();
    ensures Valid();
    ensures e == list[0];
  {
     e := elem;
  }
}


method main() 
{
  var l1 := new Node.singleton(3);
  var l2 := new Node.insert(4, l1);
  assert l1.list == [3];
  assert l2.list == [4,3];
}
