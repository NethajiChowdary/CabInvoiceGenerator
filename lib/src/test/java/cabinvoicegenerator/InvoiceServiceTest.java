package cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest
{

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare()
    {
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=2.0;
        int time=5;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare()
    {
        InvoiceGenerator generator=new InvoiceGenerator();
        double distance=0.1;
        int time=1;
        double fare=generator.calculateFare(distance,time);
        Assert.assertEquals(5.0,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() 
    {
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = {  new Ride(2.0, 5),
                          new Ride(0.1, 1)
                        };
        InvoiceSummary invoiceSummary = generator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary()
    {
        String userId="sayali123";
        InvoiceGenerator generator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        generator.addRides(userId,rides);
        InvoiceSummary invoiceSummary=generator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(invoiceSummary, expectedInvoiceSummary);
    }
}