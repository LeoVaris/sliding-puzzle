# Testing

All of the code is tested with unit tests, but the main functionality has also been verified manually 
(for example by trying to complete puzzles [here](https://lorecioni.github.io/fifteen-puzzle-game/)).

## Unit tests

All of the solving logic is unit tested with a coverage of 100% (see Codecov badge). The unit tests can be run with

```
./gradlew test
```

The unit tests exclude the `io` and `util` folders, as they are not part of the solving functionality. 

## Performance testing

Performance testing contains two implementations: `RandomizedTester` and `PermutationTester`. Both of them are located in the `util` package. 

### PermutationTester

This tester can be run with the command
```
./gradlew runPermutationTest
```

it will run _all_ 3x3 grids and calculate the solving times. This is extremely slow, and will take hours to complete. 

### RandomizedTester

This tester can be run with the command

```
./gradlew runRandomizedTest
```
with an optional argument `-Pargs="n"`, which is used to manually specify the amount of grids tested (`n` should be replaced with an integer). By default it tests 1000 grids. Below is an chart of running 1500 grids with the randomized tester. ![Performance with random grids (n=1500)](https://user-images.githubusercontent.com/49756722/131719274-e6412efd-68ff-402a-908f-857000cd48b6.png)

