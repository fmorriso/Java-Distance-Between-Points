# Java Distance Between Points

Compute the distance between two points.

## Tools Used

| Tool     |  Version |
|:---------|---------:|
| Java     | 24.0.0.0 |
| JUnit    |    5.9.1 |
| IntelliJ | 2024.3.5 |
| VSCode   |   1.98.0 |

## Change History

| Date       | Description                                                                         |
|:-----------|:------------------------------------------------------------------------------------|
| 2025-03-10 | Initial creation                                                                    |
| 2025-03-19 | Switch from GitLab to GitHub, turn on JDK 24 Preview feature: flexible constructors |

## References

* []()

## Distance between two lat/lon information

https://stackoverflow.com/questions/27928/calculate-distance-between-two-latitude-longitude-points-haversine-formula

https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/

https://www.baeldung.com/java-find-distance-between-points

The distance between Big Ben in London (51.5007° N, 0.1246° W) and The Statue of Liberty in
New York (40.6892° N, 74.0445° W) is 5574.8 km. This is not the exact measurement because the
formula assumes that the Earth is a perfect sphere when in fact it is an oblate spheroid.

https://en.wikipedia.org/wiki/Vincenty's_formulae

        // Haversine java formula
        // 11:20 into YouTube :
        // https://www.youtube.com/watch?v=HaGj0DjX8W8
        // d = 3440.1 * arccos[ ( sin(latA) * sin(latB) ) + cos(latA) * cos(latB) * cos(lonA - lonB) ]
        // https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/

