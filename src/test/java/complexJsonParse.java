import io.restassured.path.json.JsonPath;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class complexJsonParse {

    public static void main(String[] args) {

        JsonPath js2 = new JsonPath(Payload.coursePrice());
        int course_count = js2.getInt("courses.size()");
        System.out.println(course_count);

        int totalAmountPaid = js2.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmountPaid);

        String firstCourseTitle = js2.getString("courses[0].title");
        System.out.println(firstCourseTitle);

        //Print All Courses title and their resp. prices
        for(int i=0;i<course_count;i++){
            System.out.println(js2.getString("courses["+i+"].title"));
            System.out.println(js2.getInt("courses["+i+"].price"));
        }

        System.out.println("Print no. of copies sold by RPA Courses");
        for(int i=0;i<course_count;i++){
            String courseTitle = js2.getString("courses["+i+"].title");
            if(courseTitle.equals("RPA")){
                System.out.println(js2.getInt("courses["+i+"].copies"));
                break;
            }
        }


        // Helping/Learning for Udemy Comment
        /*
        JsonPath js3 = new JsonPath(Payload.helpingMethod());
        int home_count = js3.getInt("[0][0].size()");
        System.out.println(home_count);

        Map dynamic_home_map = js3.getMap("[0][0]");
        System.out.println(dynamic_home_map);
        List<String> homeList = (List<String>) dynamic_home_map.keySet().stream().collect(Collectors.toList());
        System.out.println(homeList.size());

      //  [0][0]["Home987::9876653210::1996-10-13"][0].Address

        for (String s : homeList) {
            String office_value = js3.get("[0][0][" + '"' + s + '"' + "][0].Address").toString();
           // System.out.println(office_value);
            System.out.println(js3.getString("[0][0][" + '"' + s + '"' + "][0].Address"));
        }

         */
    }
}
