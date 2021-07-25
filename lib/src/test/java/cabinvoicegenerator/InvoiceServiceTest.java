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

}