import org.example.AdvancedMath;
import org.example.BasicMath;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvanceMathTester {
    @InjectMocks
    AdvancedMath advancedMath=new AdvancedMath();
    @Mock
    BasicMath basicMath;
    @Test
    public void test1(){
        when(basicMath.subtract(80.0,20.0)).thenReturn(60.0);
        Assert.assertEquals(advancedMath.multiplyDifferenceBy5(80.0,20.0),300.0,0);
    }
    @Test
    public void test2(){
        when(basicMath.add(75.0,25.0)).thenReturn(100.0);
        when(basicMath.multiply(100.0,5.0)).thenReturn(500.0);
        Assert.assertEquals(advancedMath.multiplySumBy5(75.0,25.0),500.0,0);
    }
    @Test
    public void test3(){
        when(basicMath.add(20.0,20.0)).thenReturn(40.0);

        Assert.assertEquals(advancedMath.squareOfSum(20.0,20.0),1600.0,0);
        verify(basicMath, atLeast(2)).add(20.0,20.0);
        verify(basicMath, times(2)).add(20.0,20.0);
    }
    @Test
    public void test4(){
        when(basicMath.divide(50.0,100.0)).thenReturn(0.5);
        Assert.assertEquals(advancedMath.getPercentage(50.0,100.0), 50d,0);
        reset(basicMath);
        Assert.assertEquals(advancedMath.getPercentage(50.0,100.0), 00.0,0);
    }
    @Test
    public void test1BDD(){
        given(basicMath.subtract(80.0,20.0)).willReturn(60.0);
        Assert.assertEquals(advancedMath.multiplyDifferenceBy5(80.0,20.0),300.0,0);
    }
    @Test
    public void test2BDD(){
        given(basicMath.add(75.0,25.0)).willReturn(100.0);
        given(basicMath.multiply(100.0,5.0)).willReturn(500.0);
        Assert.assertEquals(advancedMath.multiplySumBy5(75.0,25.0),500.0,0);
    }
    @Test
    public void test3BDD(){
        given(basicMath.add(20.0,20.0)).willReturn(40.0);

        Assert.assertEquals(advancedMath.squareOfSum(20.0,20.0),1600.0,0);
        verify(basicMath, atLeast(2)).add(20.0,20.0);
        verify(basicMath, times(2)).add(20.0,20.0);
    }
    @Test
    public void test4BDD(){
        given(basicMath.divide(50.0,100.0)).willReturn(0.5);
        Assert.assertEquals(advancedMath.getPercentage(50.0,100.0), 50d,0);
        reset(basicMath);
        Assert.assertEquals(advancedMath.getPercentage(50.0,100.0), 00.0,0);
    }
}
