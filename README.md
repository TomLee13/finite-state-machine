# Finite State Machine Simulation
## TuringFlipper
This program simulates the machine with the following values for delta:
```
 delta(q0,0) = (q0,1,R)    
 delta(q0,1) = (q0,0,R)  
 delta(q0,B) = (q1,B,R)  
```
## TuringSubstractor
The function delta is described below.
```
delta(q0,0) = (q1,B,R)   Begin. Replace the leading 0 by B.

delta(q1,0) = (q1,0,R)   Search right looking for the first 1.
delta(q1,1) = (q2,1,R)

delta(q2,1) = (q2,1,R)   Search right past 1’s until encountering a 0. Change that 0 to 1.
delta(q2,0) = (q3,1,L)


delta(q3,0) = (q3,0,L)   Move left to a blank. Enter state q0 to repeat the cycle.
delta(q3,1) = (q3,1,L)   
delta(q3,B) = (q0,B,R)
                         If in state q2 a B is encountered before a 0, we have situation i 
                         described above. Enter state q4 and move left, changing all 1’s 
                         to B’s until encountering a B. This B is changed back to a 0, 
                         state q6 is entered and M halts.
delta(q2,B) = (q4,B,L)   
delta(q4,1) = (q4,B,L)
delta(q4,0) = (q4,0,L)
delta(q4,B) = (q6,0,R)
                          If in state q0 a 1 is encountered instead of a 0, the first block 
                          of 0’s has been exhausted, as in situation (ii) above. M enters 
                          state q5 to erase the rest of the tape, then enters q6 and halts. 
delta(q0,1) = (q5,B,R)   
delta(q5,0) = (q5,B,R)
delta(q5,1) = (q5,B,R)
delta(q5,B) = (q6,B,R)
```
### TuringDecider
Design and implement a Turing machine that reads a series of zeroes and ones and decides the language 
```
L = {0^n1^n, n >= 1}. 
```
The sequence of zeroes and ones will be termintated by a blank. Your Turing machine will read the input and decide the string. 
It will leave the result (a 1 = ‘yes’ or a 0 = ‘no’) on the output tape. 
