package cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest
{

    private InvoiceGenerator generator;
    private RideRepository rideRepository;
    private Ride[] rides = null;
    InvoiceSummary expectedInvoice;

    @Before
    public void initialization()
    {
        generator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        generator.setRideRepository(rideRepository);
        rides = new Ride[]{
                new Ride(CabRide.NORMAL, 2.0, 5),
                new Ride(CabRide.PREMIUM, 0.1, 1)};
        expectedInvoice = new InvoiceSummary(2,45.0);
    }
    
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() 
    {
        InvoiceSummary invoiceSummary = generator.getTotalFare(rides);
        Assert.assertEquals(invoiceSummary, expectedInvoice);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare()
    {
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=0.3;
        int time=1;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(5.0,fare,0.0);
    }

  
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() 
    {
<<<<<<< HEAD
        String userId = "nethaji55";
        generator.addRides(userId, rides);
        InvoiceSummary invoiceSummary = generator.getInvoiceSummary(userId);
        Assert.assertEquals(invoiceSummary, expectedInvoice);
=======
        String userId="nethaji55";
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        generator.addRides(userId,rides);
        InvoiceSummary invoiceSummary=generator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
>>>>>>> c11be75965023bd554852f91852a6b34bc63bc33
    }
}
