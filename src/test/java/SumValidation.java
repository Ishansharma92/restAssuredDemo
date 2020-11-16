import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

    static int totalPrice;

    @Test
    public void sumOfCourses(){
        JsonPath js = new JsonPath(Payload.coursePrice());

        int count = js.getInt("courses.size()");
        for(int i=0;i<count;i++){
            int prices = js.getInt("courses["+i+"].price");
            int copies = js.getInt("courses["+i+"].copies");
            totalPrice += prices*copies;
        }
        System.out.println(totalPrice);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        Assert.assertEquals(totalPrice,purchaseAmount);
    }
}
