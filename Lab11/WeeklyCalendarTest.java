import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the WeeklyCalendar class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.05
 */
public class WeeklyCalendarTest extends TestCase
{
    //~ Fields ................................................................

    private WeeklyCalendar calendar;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new WeeklyCalendarTest test object.
     */
    public WeeklyCalendarTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        calendar = new WeeklyCalendar();
    }


    // ----------------------------------------------------------
    
    /**
     * Tests if addAppointment adds an appointment.
     */
    public void testAddAppointment()
    {
        calendar.addAppointment(3, new Appointment("11am", "CS1114"));
        
        assertEquals(calendar.getObjects(Appointment.class).size(), 1);
    }
    
    /**
     * Tests if getAppointment returns the correct appointment.
     */
    public void testGetAppointment()
    {
        Appointment testAppointment = new Appointment("9am", "CS1114");
        calendar.addAppointment(3, testAppointment);
        
        assertEquals(calendar.getAppointment(3, 9), testAppointment);
    }

}
