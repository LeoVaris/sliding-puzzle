# Testing

## Unit tests

All of the solving logic is unit tested with a coverage of 100% (see Codecov badge). The unit tests can be run with

``
./gradlew test
``

The unit tests exclude the `io` and `util` folders, as they are not part of the solving functionality. 

## Performance testing

Performance testing is done using the `Tester.java` file in the `util` package. Currently it tests all permutations of the given grid size. 
This approach will likely be changed, as it takes very long to complete. Other option is to randomly create grids and solve them. This will be more efficient, but it can fail to
detect some performance problems with rare grid configurations. 
