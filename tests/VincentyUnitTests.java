import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class VincentyUnitTests {

    @Test
    void canMeasureDistanceUsingVincenteMethod() throws Exception {
        VincentyLocation nyc = new VincentyLocation("New York City`",  40.730610, -73.935242);
        VincentyLocation la = new VincentyLocation("Los Angeles, CA", 34.052235, -118.243683);

        double distance = nyc.distanceBetweenVincentyMethod(la);

        final double MIN_DISTANCE_KM = 3935;
        final double MAX_DISTANCE_KM = 4000;
        assertTrue(distance >= MIN_DISTANCE_KM && distance <= MAX_DISTANCE_KM,
                String.format("The distance should be between %s and %s km",MIN_DISTANCE_KM, MAX_DISTANCE_KM) );


    }
}