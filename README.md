# Test task
You are given a string S of length n that contains only the characters A and B. You need to answer q queries, each in the form of a tuple (l, r, k). For each query, you must determine the match for the k-th character in the substring S[l…r].

If the k-th character in substring S[l..r] is A and this is x-th occurrence of A in the substring, then the match will be the position for x-th occurrence of B, and vice versa if k-th character in S[l..r] is B.
If there is no match, print -1.
### <br><br><i><b>Task requirements</b></i>:
- Create an executable .jar file. You can use Java version up to 18 inclusive. Please, be aware that if you use any Java version older than 15, some classes which were included into JRE in previous versions (like javafx) are not available in JRE 15. In this case the solution will fail with an exception on the first test case.
- Read the input data from the file named input.txt which will be located in the current working directory. Please, access the file by name, e.g. "input.txt" not "/home/user/input.txt" so it will be resolved to the current working directory automatically.
- As a result of execution, your .jar file should create a file containing the output data, named output.txt in the same folder (working directory).
- Performance of your solution does not matter until it fits in time limit. Note that the time limit is set to 2s and memory limit to set to 128 MB (-Xmx128M).
- The solution .jar file size must be less than 10 MB. You are free to include any libraries, just make sure their usage is justified.

### <br><br><i><b>Input file</b></i>:<br>
The first line of the input contains two integers n and q, where n is the length of the string S and q is the number of queries.

The second line of the input contains the string S, which consists of only the characters A and B.

The next q lines each contain a query in the form of three integers l, r, and k, representing a tuple (l, r, k).

<br>Input values range:
<br>n, q - 1...105
<br>l, r - 1...n
<br>k - 1...n
<br>l <= r
<br>k <= r - l + 1

Example of input file:
<br>8 3
<br>ABBABAAB
<br>1 4 4
<br>2 6 1
<br>3 7 5

<br>Output file
<br>Example of output file (for this input file):
<br>3
<br>3
<br>-1