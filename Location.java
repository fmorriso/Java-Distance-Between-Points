public class Location
{
    public final double MEAN_RADIUS = 6371; // Earth's mean radius in Kilometers
    private String name;

    private double latitude;
    private Hemisphere lattidueHemisphere;

    private double longitude;
    private Hemisphere longitudehemisphere;

    private Location()
    {/* prevent uninitialized instances */}

    public Location(String name, double latitude, Hemisphere latitudeHemisphere ,double longitude, Hemisphere longitudeHemisphere) throws Exception
    {
        this.name = name;

        this.latitude = latitude;
        if(latitudeHemisphere == Hemisphere.NORTH ||  latitudeHemisphere == Hemisphere.SOUTH)
            this.lattidueHemisphere = latitudeHemisphere;
        else
            throw new Exception(String.format("%s is not a valid hemisphere for latitude.  Valid values are North and South", latitudeHemisphere));

        this.longitude = longitude;
        if(longitudeHemisphere == Hemisphere.WEST ||  longitudeHemisphere == Hemisphere.EAST)
            this.longitudehemisphere = longitudeHemisphere;
        else
            throw new Exception(String.format("%s is not a valid hemisphere for longitude.  Valid values are East and West", longitudeHemisphere));
    }

    public String getName()
    {
        return name;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    @Override
    public String toString()
    {
        return String.format("Location{name='%s', latitude=%.2f %s,  longitude=%.2f %s}"
                , this.name,  this.latitude,this.lattidueHemisphere, this.longitude, this.longitudehemisphere);
    }

    public double distanceBetweenPoints(Location that)
    {
        double latDiff = 0;
        // if the latitudes are in the same hemisphere, subtract; otherwise add
        if(this.lattidueHemisphere == that.lattidueHemisphere)
        {
            latDiff = this.latitude - that.latitude;
        }
        else
        {
            latDiff = this.latitude + that.latitude;
        }

        double lonDiff = 0;
        if(this.longitudehemisphere == that.longitudehemisphere)
        {
            lonDiff = this.longitude - that.longitude;
        }
        else
        {
            lonDiff = this.longitude + that.longitude;
        }

        // Haversine java formula
        // 11:20 into YouTube :
        // https://www.youtube.com/watch?v=HaGj0DjX8W8
        // d = 3440.1 * arccos[ ( sin(latA) * sin(latB) ) + cos(latA) * cos(latB) * cos(lonA - lonB) ]
        // https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/



        return 0;
    }

    public static double haversine(double lat1, double lon1,
                            double lat2, double lon2)
    {
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }

}


