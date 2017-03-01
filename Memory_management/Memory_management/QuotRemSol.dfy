method QuotRem(n: int, m: int)  returns (r: int, q: int) 
	requires n >= 0 && m > 0;
	ensures n == m ==> q == 1;
	ensures n == (q * m) + r;
{
	r := n;
	q := 0;
	while(r >= m)
		invariant n == m && r < n ==> q == 1;
		invariant n == (q * m) + r; 
	{
		r := r - m;
		q := q + 1;
	}
}