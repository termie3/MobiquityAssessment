import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class getUsers {
    @Test
    public void getUsers()
    {
        baseURI="https://jsonplaceholder.typicode.com";
        given().
                get("/users").
                then().
                statusCode(200).
                body("name[8]", equalTo("Glenna Reichert"))
                .log().body();

    }

    @Test
    public void getUserId()
    {
        baseURI="https://jsonplaceholder.typicode.com";
        given().
                get("/users/9").
                then().
                statusCode(200)
                .log().body();

    }

    @Test
    public void getPosts()
    {
        baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.get("/users");

        /*JsonPath jsonPathEvaluator = response.jsonPath();
        String name = jsonPathEvaluator.get("username");
        System.out.println("name received response " + name);
        Assert.assertEquals(name,"Delphine","response body contains Delphine");*/

        ResponseBody body = response.getBody();
        int lenthString = body.asString().length();
        int[][] arrayList = new int[0][0];
        System.out.println("Response body is " + body.asString());
        String bodyString = body.asString();
        Assert.assertEquals(bodyString.contains("Delphine"),true,"response body contains Delphine");


        String results = null;
        String searchField = "username";
        String searchUsername = "Delphine";
        for (int i=0; i < lenthString;i++ )
        {
            if (searchField.equals(searchUsername))
            {
                System.out.println("name found " + results.contains(searchUsername));
                break;
            }
            else
                System.out.println("not found");
        }
    }
}
