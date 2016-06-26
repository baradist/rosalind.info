/**
 * Created by Oleg Grigorjev on 26.06.2016.
 *
 * http://rosalind.info/problems/bins/
 *
 * Binary search is the ultimate divide-and-conquer algorithm. To find a key kk in a large file containing keys A[1..n]A[1..n] 
 * in sorted order, we first compare kk with A[n/2]A[n/2], and depending on the result we recurse either on the first half of the file, 
 * A[1..n/2]A[1..n/2], or on the second half, A[n/2+1..n]A[n/2+1..n]. The recurrence now is T(n)=T(n/2)+O(1)T(n)=T(n/2)+O(1). 
 * Plugging into the master theorem (with a=1,b=2,d=0a=1,b=2,d=0) we get the familiar solution: a running time of just O(logn)O(log⁡n).
 * Source: Algorithms by Dasgupta, Papadimitriou, Vazirani. McGraw-Hill. 2006.
 * Problem
 * The problem is to find a given set of keys in a given array.
 * Given: Two positive integers n≤105n≤105 and m≤105m≤105, a sorted array A[1..n]A[1..n] of integers from −105−105 
 * to 105105 and a list of mm integers −105≤k1,k2,…,km≤105−105≤k1,k2,…,km≤105.
 * Return: For each kiki, output an index 1≤j≤n1≤j≤n s.t. A[j]=kiA[j]=ki or "-1" if there is no such index.
 */
package BINS_binary_search;