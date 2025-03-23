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

        // Use assertTrue to check if the distance is within the range
        assertTrue(distance >= MIN_DISTANCE_KM && distance <= MAX_DISTANCE_KM,
                "The distance should be between " + MIN_DISTANCE_KM + " and " + MAX_DISTANCE_KM + " km");


    }
}