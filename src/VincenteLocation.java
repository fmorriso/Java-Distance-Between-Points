public class VincenteLocation extends Location {


    private static final double a = 6378137.0;  // Semi-major axis (meters)
    private static final double f = 1 / 298.257223563;  // Flattening
    private static final double b = (1 - f) * a;  // Semi-minor axis

    public VincenteLocation(String name, double latitude, Hemisphere latitudeHemisphere, double longitude, Hemisphere longitudeHemisphere) throws Exception {
        super(name, latitude, latitudeHemisphere, longitude, longitudeHemisphere);
    }

    public VincenteLocation(String name, double latitude, double longitude) throws Exception {
        super(name, latitude, longitude);
    }

    protected VincenteLocation() {/* prevent uninitialized instances */}

    public double distanceBetweenVincenteMethod(VincenteLocation that){
        return calculateVincentyDistance(that.getLatitude(), that.getLongitude(), this.getLatitude(), this.getLongitude());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    /** Distance in kilometers between two points using Vincente's Formula
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return kilometers distance between two points on the surface of the Earth
     */
    private double calculateVincentyDistance(double lat1, double lon1, double lat2, double lon2) {
        double L = Math.toRadians(lon2 - lon1);
        double U1 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat1)));
        double U2 = Math.atan((1 - f) * Math.tan(Math.toRadians(lat2)));

        double sinU1 = Math.sin(U1), cosU1 = Math.cos(U1);
        double sinU2 = Math.sin(U2), cosU2 = Math.cos(U2);

        double lambda = L, lambdaP;
        double sinLambda, cosLambda, sinSigma, cosSigma, sigma;
        double sinAlpha, cos2Alpha, cos2SigmaM, C;
        int iterLimit = 100;

        do {
            sinLambda = Math.sin(lambda);
            cosLambda = Math.cos(lambda);
            double v = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            sinSigma = Math.sqrt((cosU2 * sinLambda) * (cosU2 * sinLambda) + v * v);

            if (sinSigma == 0) return 0;  // Coincident points

            cosSigma = sinU1 * sinU2 + cosU1 * cosU2 * cosLambda;
            sigma = Math.atan2(sinSigma, cosSigma);
            sinAlpha = cosU1 * cosU2 * sinLambda / sinSigma;
            cos2Alpha = 1 - sinAlpha * sinAlpha;
            cos2SigmaM = cosSigma - 2 * sinU1 * sinU2 / cos2Alpha;

            if (Double.isNaN(cos2SigmaM)) cos2SigmaM = 0;  // Equatorial line case

            C = f / 16 * cos2Alpha * (4 + f * (4 - 3 * cos2Alpha));
            lambdaP = lambda;
            lambda = L + (1 - C) * f * sinAlpha *
                    (sigma + C * sinSigma * (cos2SigmaM + C * cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM)));

        } while (Math.abs(lambda - lambdaP) > 1e-12 && --iterLimit > 0);

        if (iterLimit == 0) return Double.NaN;  // Formula failed to converge

        double uSq = cos2Alpha * (a * a - b * b) / (b * b);
        double A = 1 + uSq / 16384 * (4096 + uSq * (-768 + uSq * (320 - 175 * uSq)));
        double B = uSq / 1024 * (256 + uSq * (-128 + uSq * (74 - 47 * uSq)));
        double deltaSigma = B * sinSigma * (cos2SigmaM + B / 4 *
                (cosSigma * (-1 + 2 * cos2SigmaM * cos2SigmaM) -
                        B / 6 * cos2SigmaM * (-3 + 4 * sinSigma * sinSigma) *
                                (-3 + 4 * cos2SigmaM * cos2SigmaM)));

        return b * A * (sigma - deltaSigma) / 1000;  // Distance in kilometers
    }

/*    public static void main(String[] args) {
        double lat1 = 34.05, lon1 = -118.25;  // Los Angeles, CA
        double lat2 = 40.71, lon2 = -74.01;   // New York, NY

        double distance = calculateVincentyDistance(lat1, lon1, lat2, lon2);
        System.out.printf("Distance: %.3f km%n", distance / 1000);
    }*/
}
