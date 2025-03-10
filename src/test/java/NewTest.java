import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class NewTest {
    @Test(description = "test")
    public void firstTest() {
        assertEquals(1,1);
    }

    @Test(description = "exception")
    public void exceptionTest(){
        String test = null;
        try {
            test.length();
            Assert.fail("waiting for exception");
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Cannot invoke \"String.length()\" because \"test\" is null");
        }
    }
    @Test(description = "soft assert") // нужно прочекать варианты с параметрами этой аннотации
    public void assertAllTest(){
        SoftAssert softAssert = new SoftAssert();
        String name = "Alexander";
        softAssert.assertEquals(name,"Ksander","invalid name");
        softAssert.assertEquals(name,"Alexander","invalid name");
        softAssert.assertEquals(name,"Vika", "invalid name");
        softAssert.assertAll(); // если эту строку не указать, то достаточно одного пройденного теста.
    }
}
