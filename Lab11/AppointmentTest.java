import sofia.micro.*;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Elliot Yeo (eyeo)

// -------------------------------------------------------------------------
/**
 *  Tests for the Appointment class.
 *
 *  @author Elliot Yeo (eyeo)
 *  @version 2020.11.05
 */
public class AppointmentTest extends TestCase
{
    //~ Fields ................................................................

    private Appointment appointment;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new AppointmentTest test object.
     */
    public AppointmentTest()
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
        // You'll need to fix this after modifying the Appointment constructor
        appointment = new Appointment(0, "");
    }


    // ----------------------------------------------------------
    /**
     * Tests if getDescription returns the correct String.
     */
    public void testGetDescription()
    {
        assertEquals(appointment.getDescription(), "");
    }
    
    /**
     * Tests if getHour returns the correct int.
     */
    public void testGetHour()
    {
        assertEquals(appointment.getHour(), 0);
    }
    
    /**
     * Tests if setTime returns the correct String.
     */
    public void testSetTime()
    {
        appointment.setTime("12pm");
        
        assertEquals(appointment.getHour(), 12);
    }
    
    /**
     * Tests the second Appointment constructor.
     */
    public void testAppointment()
    {
        appointment = new Appointment("10am", "test");
        
        assertEquals(appointment.getHour(), 10);
        assertEquals(appointment.getDescription(), "test");
    }
    
    /**
     * Tests the overriden toString method when the
     * time given is am.
     */
    public void testToString()
    {
        appointment = new Appointment("11am", "CS1114");
        
        assertEquals(appointment.toString(), "11am: CS1114");
    }
    
    /**
     * Tests the overriden toString method when the
     * time given is pm.
     */
    public void testToString2()
    {
        appointment = new Appointment("1pm", "CS1114");
        
        assertEquals(appointment.toString(), "1pm: CS1114");
    }
    
    

}
