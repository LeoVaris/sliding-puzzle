# Specification

## Course details

Study programme: Tietojenkäsittelytieteen kandiohjelma

Project language: English

## The problem

Goal of this project is to implement a solver for the sliding puzzle. The solver should find one of the shortest sequences. Most common variant of this is the [15 puzzle](https://en.wikipedia.org/wiki/15_puzzle).
In the beginning the project will focus on the 15 puzzle. If there's is enough time, the project may be expanded to support larger puzzles. For larger puzzles shortest sequence is very difficult to find, but
find _some_ solution is easier. 

## Input

The program will receive the puzzle grid as the input. It will be used to form the shortest sequence of moves to solve the puzzle. 

## Target time complexity

Finding the shortest sequence of moves is a NP-hard problem. Therefore there is no single target for a time/space complexity.

## Algorithms

The main algorithm used is iterative deepening A* (IDA*), which is used for the move searching. There are few options for the heuristics listed below.

- Manhattan distance. It is a simple way to compute the heuristic, but is does not provide a very useful value. 
- Walking distance. It is a heuristic made by Ken'ichiro Takahashi. It offers a lot more useful value to be used in pruning. 
  Problem with implementing the walking distance is that the explanation is offered only in Japanese, so using it may fail due
  to problems with translating the material. 
  
## Sources

- [15 puzzle - Wikipedia](https://en.wikipedia.org/wiki/15_puzzle)
- [Fifteen puzzle optimal solver](http://kociemba.org/themen/fifteen/fifteensolver.html)
- [How to make a 15-puzzle automatic answering program (in Japanese, used via Google translate)](http://www.ic-net.or.jp/home/takaken/nt/slide/solve15.html)
- [The (n^2−1)-puzzle and related relocation problems](https://www.sciencedirect.com/science/article/pii/S0747717108800016)
  
