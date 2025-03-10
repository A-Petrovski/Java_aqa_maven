import org.testng.annotations.DataProvider;
import petrovsky.CargoDimension;
import petrovsky.ServiceWorkload;

public class MyDataProvider {

    @DataProvider(name = "cargoData")
    public static Object[][] provideCargoData() {
        return new Object[][]{
                {CargoDimension.SMALL, 0, true, ServiceWorkload.NORMAL, 450},   // +100,+50, +300, x1  expectedResult=450
                {CargoDimension.SMALL, 5, false, ServiceWorkload.HIGH, 400},   // +100,+100, +0, x1.4, expectedResult=400
                {CargoDimension.LARGE, 15, true, ServiceWorkload.VERY_HIGH, 1120}, // +200,+200, +300, x1.6, expectedResult=1120
                {CargoDimension.LARGE, 200, false, ServiceWorkload.INCREASED, 600}  // +200,+300, +0, x1.2, expectedResult=600
        };
    }
}