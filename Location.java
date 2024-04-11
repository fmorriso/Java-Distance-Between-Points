public class Location
{
    private String name;

    private double latitude;
    private Hemisphere lattidueHemisphere;

    private double longitude;
    private Hemisphere longitudehemisphere;

    private Location()
    {/* prevent uninitialized instances */}

    public Location(String name, double latitude, Hemisphere latitudeHemisphere ,double longitude, Hemisphere longitudeHemisphere)
    {
        this.name = name;

        this.latitude = latitude;
        this.lattidueHemisphere = latitudeHemisphere;

        this.longitude = longitude;
        this.longitudehemisphere = longitudeHemisphere;

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



        return 0;
    }
}


