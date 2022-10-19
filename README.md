# DSA-Decoded

Hi! This is my personal Data Structures and Algorithms repo to keep track of my questions and submissions.

## Normal DSA Questions

1. Palindrome: Find reversed part only for half number then compare it with rest of number. <br>
               ``` Note: If number is odd, then compare by dividing 10 ```

2. GCD and LCM: Divide greater number by lesser number until it becomes undivisible. Then <br>```last remainder will be our gcd```
                <br>``` LCM will be (original n1 * n2) / gcd ```
                
3. Reverse Number: Divide number by 10 till it becomes 0 and add remainder to reversedN with multiplying 10<br>
                   ``` reversedN = reversedN*10 + remainder ```
                   
4. Rotate Number: Divide the number by 10 to the power of k. Then add that number by multiplying with rest of number 10 <br>
                  Example: (123456 (k=2)--> 1234 + 56 --> 56000 + 1234 --> 561234) <br>
                  ``` div = Math.pow(10, k)
                      rotateN = n/div + (n%div) * (Math.pow(10, count-k));
                  ```
                  
5. 
                  
