import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        System.out.format("Distance between points using java version %s on %s%n",
                getJavaVersion(), getCurrentLocalDateTime());

        Location l1 = new Location("Test", Hemisphere.NORTHERN, 2.456, 110.987);
        System.out.println(l1);
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
