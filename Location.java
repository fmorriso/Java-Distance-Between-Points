public class Location
{
    private String name;
    private double latitude;
    private double longitude;

    private Location()
    {/* prevent uninitialized instances */}

    public Location(String name, double latitude, double longitude)
    {
        this.name = name;
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
        return String.format("Location{name='%s', latitude=%.2f, longitude=%.2f}", this.name, this.latitude, this.longitude);
    }
}


