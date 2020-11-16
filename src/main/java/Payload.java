public class Payload {

    public static String addPlace() {

        return "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": -38.383494,\n" +
                "        \"lng\": 33.427362\n" +
                "    },\n" +
                "    \"accuracy\": 50,\n" +
                "    \"name\": \"Rahul Shetty Academy\",\n" +
                "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "    \"address\": \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\n" +
                "        \"shoe park\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://rahulshettyacademy.com\",\n" +
                "    \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String coursePrice(){

        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";

        /* Actual JSON >>
        {
    "dashboard": {
        "purchaseAmount": 910,
        "website": "rahulshettyacademy.com"
    },
    "courses": [
        {
            "title": "Selenium Python",
            "price": 50,
            "copies": 6
        },
        {
            "title": "Cypress",
            "price": 40,
            "copies": 4
        },
        {
            "title": "RPA",
            "price": 45,
            "copies": 10
        }
    ]
}
       JSON ENDS  */
    }

    public static String helpingMethod(){
        return "[\n" +
                "    [\n" +
                "        {\n" +
                "            \"Home123::9876543210::1994-10-13\": [\n" +
                "                {\n" +
                "                    \"Address\": \"1\",\n" +
                "                    \"id\": \"123\",\n" +
                "                    \"Office\": null\n" +
                "                }\n" +
                "            ],\n" +
                "            \"Home987::9876653210::1996-10-13\": [\n" +
                "                {\n" +
                "                    \"Address\": \"2\",\n" +
                "                    \"id\": \"129\",\n" +
                "                    \"Office\": null\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "]";
    }

    public static String AddBook(String isbnNo, String aisleNo) {
        String payload = "{\n" +
                "\"name\":\"Learn Appium Automation with Java V1\",\n" +
                "\"isbn\":\""+isbnNo+"\",\n" +
                "\"aisle\":\""+aisleNo+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n" +
                " \n";
        return payload;
    }


}
