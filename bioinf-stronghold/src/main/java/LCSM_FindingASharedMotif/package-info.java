/**
 * Created by Oleg Grigorjev on 07.08.2016.
 * http://rosalind.info/problems/lcsm/
 *
 * Problem
 * A common substring of a collection of strings is a substring of every member of the collection. We say that a common
 * substring is a longest common substring if there does not exist a longer common substring. For example, "CG" is
 * a common substring of "ACGTACGT" and "AACCGGTATA", but it is not as long as possible; in this case, "GTA" is
 * a longest common substring of "ACGTACGT" and "AACCGTATA".
 * Note that the longest common substring is not necessarily unique; for a simple example, "AA" and "CC" are both
 * longest common substrings of "AACC" and "CCAA".
 * Given: A collection of kk (k≤100k≤100) DNA strings of length at most 1 kbp each in FASTA format.
 * Return: A longest common substring of the collection. (If multiple solutions exist, you may return any single solution.)
 */
package LCSM_FindingASharedMotif;