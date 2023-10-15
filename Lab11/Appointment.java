import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Represents a weekly appointment at a specified time,
 *  including a description.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.05
 */
public class Appointment extends Actor
{
    //~ Fields ................................................................

    private int hour;
    private String description;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new Appointment object.
     * 
     * @param hour The hour(time) of this appointment, in military time
     *             (0-23).
     * @param description The description of this appointment.
     */
    public Appointment(int hour, String description)
    {
        this.hour = hour;
        this.description = description;
    }
    
    /**
     * Creates a new Appointment object.
     * 
     * @param regularTime The hour(time) of this appointment, in regular time.
     * @param desc        The description of this appointment.
     */
    public Appointment(String regularTime, String desc)
    {
        setTime(regularTime);
        setDescription(desc);
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Get the description of this appointment.
     * @return This appointment's description.
     */
    public String getDescription()
    {
        return description;
    }


    // ----------------------------------------------------------
    /**
     * Get the hour of this appointment.
     * @return This appointment's hour, in military time.
     */
    public int getHour()
    {
        return hour;
    }


    // ----------------------------------------------------------
    /**
     * Set the description of this appointment.
     * @param newDescription The new description for this appointment.
     */
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }


    // ----------------------------------------------------------
    /**
     * Set the hour of this appointment.
     * @param newHour The new hour for this  appointment, in military
     *                time.
     */
    public void setHour(int newHour)
    {
        hour = newHour;
    }

    // ----------------------------------------------------------
    /**
     * Set the hour of this appointment, using a more human-friendly
     * string.
     * @param newHour The new hour for this  appointment, using an
     *                am/pm designation such as "9am" or "5pm".
     */
    public void setTime(String newHour)
    {
        int len = newHour.length();
        String digitsOnly = newHour.substring(0, len - 2);
        int hr = Integer.parseInt(digitsOnly);
        
        if (newHour.equals("12pm"))
        {
            hr = 12;
        }
        else if (newHour.contains("pm"))
        {
            hr = hr + 12;
        }
        else if (newHour.equals("12am"))
        {
            hr = 0;
        }
        
        this.hour = hr;
    }


    // ----------------------------------------------------------
    /**
     * Get a string representation of this appointment.
     * @return A human-readable representation of this appointment
     * that includes the time (in am/pm format) and the description,
     * such as "11am: CS 1114".
     */
    @Override
    public String toString()
    {
        String time = "";
        if (hour > 12)
        {
            String hr = String.valueOf(hour - 12);
            time = time + hr + "pm";
        }
        else if (hour == 0)
        {
            String hr = String.valueOf(hour + 12);
            time = time + hr + "am";
        }
        else if (hour == 12)
        {
            String hr = String.valueOf(hour);
            time = time + hr + "pm";
        }
        else
        {
            String hr = String.valueOf(hour);
            time = time + hr + "am";
        }
        
        return time + ": " + description;
    }
}
