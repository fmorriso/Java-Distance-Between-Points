import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeodesicUnitTests {

    @Test
    void canMeasureDistanceUsingGeodesicMethod() throws Exception {
        GeodesicLocation nyc = new GeodesicLocation("New York City`",  40.730610, -73.935242);
        GeodesicLocation la = new GeodesicLocation("Los Angeles, CA", 34.052235, -118.243683);

        double distance = nyc.distanceBetweenGeodesicMethod(la);

        final double MIN_DISTANCE_KM = 3935;
        final double MAX_DISTANCE_KM = 4000;
        assertTrue(distance >= MIN_DISTANCE_KM && distance <= MAX_DISTANCE_KM,
                String.format("The distance should be between %s and %s km",MIN_DISTANCE_KM, MAX_DISTANCE_KM) );


    }
}