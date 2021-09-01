# User manual

First clone the project and navigate to the root of the project. 

To run the program, use the command

```
./gradlew run --quiet --console=plain
```

The grid should be given in a single line. 

For example a grid
```
3 2 1
6 5 4
8 7 _
```

should be given as `3 2 1 6 5 4 8 7 0`. Note that the `_` representing the empty square should be given as a zero.  

## Example cases

Not all grids can be solved. Below is a list of few great examples to use. 
Also note that due to the poor performance of the algorithm, many grids will take a very long time to solve. 

* ```
  1 8 2
  _ 4 3
  7 6 5
  ```
  which should be given as `1 8 2 0 4 3 7 6 5`.

* ```
  1 2 4 7
  10 5 6 8
  13 3 11 _
  9 14 15 12
  ```
  which should be given as `1 2 4 7 10 5 6 8 13 3 11 0 9 14 15 12`.

* ```
  5 1 2 3
  9 15 7 4
  13 10 14 _
  11 8 6 12
  ```
  which should be given as `5 1 2 3 9 15 7 4 13 10 14 0 11 8 6 12`.
