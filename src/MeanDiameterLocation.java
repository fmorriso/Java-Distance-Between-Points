public class MeanDiameterLocation extends Location{


    public MeanDiameterLocation(String name, double latitude, Hemisphere latitudeHemisphere, double longitude, Hemisphere longitudeHemisphere) throws Exception {
        super(name, latitude, latitudeHemisphere, longitude, longitudeHemisphere);
    }

    public MeanDiameterLocation(String name, double latitude, double longitude) throws Exception {
        super(name, latitude, longitude);
    }

    protected MeanDiameterLocation() {/* prevent uninitialized instances */}

    public double distanceBetweenGeodesicMethod(GeodesicLocation that){
        return calculateMeanDiameterDistance(that.getLatitude(), that.getLongitude(), this.getLatitude(), this.getLongitude());
    }

    private double calculateMeanDiameterDistance(double latitude, double longitude, double latitude1, double longitude1) {
        return 1.;
    }

}
