import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class RestAssuredTest {

    // API Global BASE URI Variable
    String baseUrl = "https://reqres.in/";

    //Let´s execute a simple request to check Rest Assured
    @Test
    public void verifyGetMethod(){
       //Create rest assured request method from Response interface
       Response response = RestAssured.given()
        .contentType(ContentType.JSON)
        .pathParam( "pageNumber", "2" )
        .log().all()
        .when()
        .get( baseUrl + "api/users?page={pageNumber}");
    response.then().log().all()
            .assertThat()
            //Verify Status code
            .statusCode( 200)
            //Verify Body with Matchers class passing parameters
            .body( "page", Matchers.equalTo( 2));



    }

}
