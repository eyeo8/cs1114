import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

//-------------------------------------------------------------------------
/**
 *  Represents a simple weekly calendar of appointments that are
 *  shown in a grid from 8am to 5pm on each day of the week.
 *  Internally, appointments are stored in a 2D array
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.05
 */
public class WeeklyCalendar extends World
{
    //~ Fields ................................................................

    private Appointment[][] appointments;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeeklyCalendar object.
     */
    public WeeklyCalendar()
    {
        super(8, 11, 50);
        this.appointments = new Appointment[7][10];
        // Initialize your 2D array of appointments
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Add a new appointment on the specified day.  The time for the
     * appointment is extracted from the appointment object itself.
     * If the day is invalid, the method does nothing.  If the appointment
     * is outside the window of 8am-5pm, the method does nothing.
     * If another appointment has already been entered for the
     * specified day/time, it is removed and replaced by the one
     * being added.
     * 
     * @param day         The day for the appointment (0-6).
     * @param appointment The appointment to add on that day (contains
     *                    its own time).
     */
    public void addAppointment(int day, Appointment appointment)
    {
        if (day >= 0 && day <= 6 && appointment.getHour() >= 8 
            && appointment.getHour() <= 17)
        {
            if (appointments[day][appointment.getHour() - 8] != null)
            {
                appointments[day][appointment.getHour() - 8].remove();
            }
            appointments[day][appointment.getHour() - 8] = appointment;
            this.add(appointment, day + 1, appointment.getHour() - 7);
        }
        
    }


    // ----------------------------------------------------------
    /**
     * Retrieve an existing appointment (if any) by day and hour.
     * 
     * @param day  The day to check (0-6).
     * @param hour The hour to check (0-23), in military time.
     * @return The appointment at the specified day and time,
     * if there is one, or null if no appointment is found, if
     * the day specified is invalid, or if the hour specified is
     * outside the range 8-17.
     */
    public Appointment getAppointment(int day, int hour)
    {
        if (day >= 0 && day <= 6 && hour >= 8 
            && hour <= 17)
        {
            if (appointments[day][hour - 8] != null)
            {
                return appointments[day][hour - 8];
            }
        }
        return null;
    }
}
