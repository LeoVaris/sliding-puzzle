# Implementation document

## Program structure

The main problem solving logic is located at `solver.Solver`. It contains practically all of the logic used in the solver. 
The solver uses an IDA* search algorithm and Manhattan distance as the heuristic. The program also first checks if the grid can solved using logic
explained [here](https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/). The project also contains a very simple list/array implementation to be used by the interface. 
It is a list with a static maximum size, as the required size never exceeds a small number and the list is not a critical part of the algorithm. 

## Time complexity

As the problem is NP-hard, there is no exact time limit for the algorithm. I would assume the time complexity is somewhere between `O(n^2)` and `O(n!)`. 

## Problems and possible improvements

The project currently uses the Manhattan distance as the heuristic. This could be changed to the Walking distance, possibly greatly reducing the algorithm's running time. 
Otherwise the program is quite optimized, and to my best knowledge there isn't any bugs. 

## Sources

- [15 puzzle - Wikipedia](https://en.wikipedia.org/wiki/15_puzzle)
- [Fifteen puzzle optimal solver](http://kociemba.org/themen/fifteen/fifteensolver.html)
- [How to make a 15-puzzle automatic answering program (in Japanese, used via Google translate)](http://www.ic-net.or.jp/home/takaken/nt/slide/solve15.html)
- [The (n^2−1)-puzzle and related relocation problems](https://www.sciencedirect.com/science/article/pii/S0747717108800016)
- [How to check if an instance of 15 puzzle is solvable?](https://www.geeksforgeeks.org/check-instance-15-puzzle-solvable/)

