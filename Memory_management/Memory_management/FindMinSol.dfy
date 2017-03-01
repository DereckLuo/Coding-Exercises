method FindMin(a : array<int>) returns (min : int)
	requires a != null;
	ensures forall i :: 0  <= i < a.Length ==> min <= a[i];
{
	if (a.Length == 0) { return; }
	var index := 1;
	min := a[0];
	while(index < a.Length) 
		invariant 1 <= index <= a.Length;
		invariant forall k :: 0 <= k < index ==> a[k] >= min;
	{
		if (a[index] < min) {
			min := a[index];
		}
		index := index + 1;
	}
}
