import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


public class GeodesicLocation extends Location {
    public GeodesicLocation(String name, double latitude, Hemisphere latitudeHemisphere, double longitude, Hemisphere longitudeHemisphere) throws Exception {
        super(name, latitude, latitudeHemisphere, longitude, longitudeHemisphere);
    }

    public GeodesicLocation(String name, double latitude, double longitude) throws Exception {
        super(name, latitude, longitude);
    }

    protected GeodesicLocation() {/* prevent uninitialized instances */}

    @Override
    public String toString() {
        return super.toString();
    }


    public double distanceBetweenGeodesicMethod(GeodesicLocation that){
        return calculateGeodesicDistance(that.getLatitude(), that.getLongitude(), this.getLatitude(), this.getLongitude());
    }

    /** Calculate distance between two points in kilometers
     * @param start_lat
     * @param start_lon
     * @param end_lat
     * @param end_lon
     * @return distance in kilometers between two points on the surface of Earth.
     */
    private double calculateGeodesicDistance(double start_lat, double start_lon, double end_lat, double end_lon) {

        GeodesicData result = Geodesic.WGS84.Inverse(start_lat, start_lon, end_lat, end_lon);
        return result.s12 / 1000.0;

    }
}
