# INFO6205
Assignment 2
============
Code
----------
1.[Timer.java](src/main/java/edu/neu/coe/info6205/util/Timer.java)<br>
2.[InsertionSort.java](src/main/java/edu/neu/coe/info6205/sort/simple/InsertionSort.java)<br>
3.[Assignment2_part3.java](src/main/java/edu/neu/coe/info6205/sort/simple/Assignment2_part3.java)

Part 1
----------
Unit test screenshots:
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/timerTest.png)
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/BenchmarkTest.png)

Part 2
-------------
Unit test screenshots:
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/InsertionSortTest.png)

Part 3
--------------
The time of system spend on each kind of orderlist:
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/Assignment2_part3.png)
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/Assignment2_part3_2.png)
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/Assignment2_part3_3.png)
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/Assignment2_part3_4.png)
![Image text](https://github.com/ZyTnT/INFO6205-HW/blob/main/Assignment2/picture/Assignment2_part3_5.png)

Here we can see that the result was stable in 5 experiments with different n.<br>
The reverse order list spend the most time, almost apporch to O(N^2)<br>
Random list has normal performance.<br>
Partially Random list spend less time than random.<br>
The ordered list is spend least time, always zero.
 
