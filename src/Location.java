public class Location
{
    public final double EARTH_MEAN_RADIUS_KM = 6371; // Earth's mean radius in Kilometers

    private String name;

    private double latitude;
    private Hemisphere lattidueHemisphere;

    private double longitude;
    private Hemisphere longitudeHemisphere;

    private Location()
    {/* prevent uninitialized instances */}

    public Location(String name, double latitude, Hemisphere latitudeHemisphere, double longitude, Hemisphere longitudeHemisphere) throws Exception
    {
        this.name = name;

        // Positive latitude is above the equator (N), and negative latitude is below the equator (S).
        switch (latitudeHemisphere) {
            case NORTH:
                if (latitude < 0)
                    throw new Exception("North latitude cannot be negative");
                break;

            case SOUTH:
                if (latitude > 0)
                    throw new Exception("South latitude cannot be positive");
                break;

            default:
                throw new Exception(String.format("%s is not a valid hemisphere for latitude.  Valid values are North and South", latitudeHemisphere));
        }
        this.latitude = latitude;
        this.lattidueHemisphere = latitudeHemisphere;

        // Positive longitude is east of the prime meridian, while negative longitude is west of the prime meridian (a north-south line that runs through a point in England).
        switch (longitudeHemisphere) {
            case EAST:
                if (longitude < 0)
                    throw new Exception("East longitude cannot be negative");
                break;

            case WEST:
                if (longitude > 0)
                    throw new Exception("West longitude cannot be positive");
                break;

            default:
                throw new Exception(String.format("%s is not a valid hemisphere for longitude.  Valid values are East and West", longitudeHemisphere));
        }

        this.longitude = longitude;
        this.longitudeHemisphere = longitudeHemisphere;

    }

    public Location(String name, double latitude, double longitude) throws Exception
    {
        Hemisphere local_lattidueHemisphere;
        Hemisphere local_longitudeHemisphere;

        // Positive latitude is above the equator (N), and negative latitude is below the equator (S).
        if (latitude >= 0)
            local_lattidueHemisphere = Hemisphere.NORTH;
        else
            local_lattidueHemisphere = Hemisphere.SOUTH;



        // Positive longitude is east of the prime meridian, while negative longitude is west of the prime meridian (a north-south line that runs through a point in England).
        if(longitude >= 0)
            local_longitudeHemisphere = Hemisphere.EAST;
        else
            local_longitudeHemisphere = Hemisphere.WEST;

        //NOTE: requires turning on JDK 24 preview feature: Flexible constructor bodies
        this(name, latitude, local_lattidueHemisphere, longitude, local_longitudeHemisphere);
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
        return String.format("Location{name='%s', latitude=%.2f,  latitudeHemisphere=%s, longitude=%.2f, longitudeHemisphere=%s}"
                , this.name, this.latitude, this.lattidueHemisphere, this.longitude, this.longitudeHemisphere);
    }

    public double distanceBetween(Location that)
    {
        return calculateDistance(this.latitude, this.longitude, that.latitude, that.longitude);
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2)
    {
        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double lon1Rad = Math.toRadians(lon1);
        double lon2Rad = Math.toRadians(lon2);

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);

        return Math.sqrt(x * x + y * y) * EARTH_MEAN_RADIUS_KM;
    }

}


