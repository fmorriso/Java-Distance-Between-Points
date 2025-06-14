# Java Distance Between Points

Compute the distance between two points by using the approximation of Earth's mean radius of 6731 kilometers
and the assumption Earth is a perfect sphere.

## Tools Used

| Tool                 |  Version |
|:---------------------|---------:|
| Java                 | 24.0.1.0 |
| JUnit                |   5.13.1 |
| net.sf.geographiclib |      2.0 |
| IntelliJ             | 2025.1.2 |
| VSCode               |  1.101.0 |

## Change History

| Date       | Description                                                                         |
|:-----------|:------------------------------------------------------------------------------------|
| 2025-03-10 | Initial creation                                                                    |
| 2025-03-19 | Switch from GitLab to GitHub, turn on JDK 24 Preview feature: flexible constructors |
| 2025-03-23 | Add Geodesic and Vincente's formulas for calculating distance                       |
| 2025-06-13 | upgrade to JUnit 5.13.1                                                             |

## References

* [Calculate Distance Between Two Coordinates in Java](https://www.baeldung.com/java-find-distance-between-points)
* [Haversine formula to find distance between two points on a sphere](https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/)
* [Video: How to Determine the Distance Between Geographic Coordinates?](https://www.youtube.com/watch?v=HaGj0DjX8W8)
* [Java Implementation of GeographicLib - Maven Central](https://mvnrepository.com/artifact/net.sf.geographiclib/GeographicLib-Java)
* [Vincenty's formulae](https://en.wikipedia.org/wiki/Vincenty's_formulae)

## Distance between two lat/lon information

The distance between Big Ben in London (51.5007° N, 0.1246° W) and The Statue of Liberty in
New York (40.6892° N, 74.0445° W) is 5574.8 km.
This is not the exact measurement because the
formula assumes that the Earth is a perfect sphere when in fact it is an oblate spheroid.

```java
// Haversine java formula
// 11:20 into YouTube :
// https://www.youtube.com/watch?v=HaGj0DjX8W8
// d = 3440.1 * arccos[ ( sin(latA) * sin(latB) ) + cos(latA) * cos(latB) * cos(lonA - lonB) ]
// https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
```
