package MathApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalcuatorTest {
    @InjectMocks
    Calculator calc= new Calculator();
    @Mock
    CalculatorService service;

    @Test
    public void testAdd(){

        when(service.add(10,20)).thenReturn(30);
        Assert.assertEquals(calc.add(10, 20),30,0);
    }

    @Test
    public void testSub(){

        when(service.sub(20,10)).thenReturn(10);
        Assert.assertEquals(calc.sub(20, 10),10,0);
    }

    @Test
    public void testMul(){

        when(service.mult(10,20)).thenReturn(200);
        Assert.assertEquals(calc.mult(10, 20),200,0);
    }

    @Test
    public void testDiv(){

        when(service.mult(20,10)).thenReturn(2);
        Assert.assertEquals(calc.div(20, 10),2,0);
    }
}
