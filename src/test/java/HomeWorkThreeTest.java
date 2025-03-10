import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import petrovsky.CargoDimension;
import petrovsky.Delivery;
import petrovsky.ServiceWorkload;

import static org.testng.Assert.assertEquals;

public class HomeWorkThreeTest {
    @Test(description = "ExampleTest", groups = "Example")
    void testCheapestOrder() {
        Delivery delivery = new Delivery(1, CargoDimension.SMALL, false, ServiceWorkload.NORMAL);
        Assert.assertEquals(400,delivery.calculateDeliveryCost());
    }

    @Test(dataProvider = "cargoData", dataProviderClass = MyDataProvider.class)
    public void testCargoCalculation(CargoDimension dim, int dist, boolean fra, ServiceWorkload loa, int result) {
        // Ваш тестовый код
        Delivery delivery = new Delivery(dist, dim, fra, loa);
        Assert.assertEquals(delivery.calculateDeliveryCost(), result, "Cargo cost calculation is incorrect");
    }
    @Test(description = "DistanceOrderNegative")
    public void testDistanceOrderNegative() {
        try {
            Delivery delivery = new Delivery(-1, CargoDimension.SMALL, false, ServiceWorkload.NORMAL);
            // Если код дошел сюда, значит, исключение не было выброшено
            Assert.fail("Expected IllegalArgumentException, but no exception was thrown");
        } catch (IllegalArgumentException e) {
            // Проверяем сообщение исключения
            assertEquals(e.getMessage(), "destinationDistance should be a positive number!");
        }
    }

}
