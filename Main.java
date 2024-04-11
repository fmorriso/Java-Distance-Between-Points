import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        System.out.format("Distance between points using java version %s on %s%n",
                getJavaVersion(), getCurrentLocalDateTime());

        Location nyc = new Location("New York City`",  40.730610, -73.935242);
        System.out.println(nyc);

        Location la = new Location("Los Angeles, CA", 34.052235, -118.243683);
        System.out.println(la);
        // Straight line distance: 2440.65 miles , 3927.85 kilometers (km) , 12886647 feet , 3927850 meters
        System.out.format("Distance between %s and %s: %.2f KM%n", nyc.getName(), la.getName(), nyc.distanceBetweenPoints(la));
    }

    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version runTimeVersion = Runtime.version();
        return String.format("%s.%s.%s.%s", runTimeVersion.feature(), runTimeVersion.interim(), runTimeVersion.update(), runTimeVersion.patch());
    }


    /** Get the local date and time in a format similar to ISO 8601 format
     * @return string containing the current local Date/Time in a format close to ISO 8601 format (yyyy-mm-dd hh:mm:ss)
     */
    private static String getCurrentLocalDateTime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format(dtf.format(LocalDateTime.now()));
    }



}
