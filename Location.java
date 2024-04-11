public class Location
{
    private String name;
    private Hemisphere hemisphere;
    private double latitude;
    private double longitude;

    private Location()
    {/* prevent uninitialized instances */}

    public Location(String name, Hemisphere hemisphere ,double latitude, double longitude)
    {
        this.name = name;
        this.hemisphere = hemisphere;
        this.latitude = latitude;
        this.longitude = longitude;
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
        return String.format("Location{name='%s', hemisphere=%s, latitude=%.2f, longitude=%.2f}"
                , this.name, this.hemisphere, this.latitude, this.longitude);
    }
}


