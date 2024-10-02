package com.cucumber.steps;

import com.setup.ReusableFunctions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ApiSteps extends ReusableFunctions {
    protected static String baseUri = "https://petstore.swagger.io/v2/pet";
    private static Response response;
    static JSONArray jsonArray;

    @Given("create new pet")
    public void createNewPet() {
        RestAssured.baseURI = baseUri;
        RequestSpecification request = RestAssured.given();

        String path = System.getProperty("user.dir") + "/src/test/resources/api/addNewPet.json";
        byte[] body = new byte[0];

        try {
            body = Files.readAllBytes(Path.of(path));
        }
        catch (Exception e) {
            addFailLog(Arrays.toString(e.getStackTrace()));
        }

        String bodyAsString = new String(body);

        request.header("Content-Type", "application/json");

        response = request.body(bodyAsString).post();
        addInfoLog("send request to create new pet");

        Assert.assertEquals(200, response.getStatusCode());
        addInfoLog("status cod from the request is: " + response.getStatusCode());
    }

    @Then("update the status to sold")
    public void updateTheStatusToSold() {
        RestAssured.baseURI = baseUri;
        RequestSpecification request = RestAssured.given();

        String path = System.getProperty("user.dir") + "/src/test/resources/api/updatePetStatus.json";
        byte[] body = new byte[0];

        try {
            body = Files.readAllBytes(Path.of(path));
        }
        catch (Exception e) {
            addFailLog(Arrays.toString(e.getStackTrace()));
        }

        String bodyAsString = new String(body);

        request.header("Content-Type", "application/json");

        response = request.body(bodyAsString).put();
        addInfoLog("send request to update the status to sold");

        Assert.assertEquals(200, response.getStatusCode());
        addInfoLog("status cod from the request is: " + response.getStatusCode());
    }

    @Given("get all available pets")
    public void getAllAvailablePets() {
        RestAssured.baseURI = baseUri;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.get("/findByStatus?status=available");
        addInfoLog("send request to get all available pets");

        Assert.assertEquals(200, response.getStatusCode());
        addInfoLog("status cod from the request is: " + response.getStatusCode());

        String body = response.getBody().asString();
        jsonArray = new JSONArray(body);
    }

    @And("verify the fourth pet name")
    public void verifyTheFourthPetName() {
        JSONObject jsonObject = jsonArray.getJSONObject(3);
        if (jsonObject.get("name").equals("Puff")) {
            addPassLog("the name of fourth Pet is Puff");
        }
        else {
            addFailLog("the name of fourth Pet is NOT Puff! the name is: " +
                    jsonObject.get("name"));
        }
    }

    @Then("writer to console the pet object")
    public void writerToConsoleThePetObject() {
        JSONObject jsonObject = jsonArray.getJSONObject(3);
        System.out.println(jsonObject);
        addInfoLog("the pet object is: " + jsonObject);
    }

    @Given("get all sold pets")
    public void getAllSoldPets() {
        RestAssured.baseURI = baseUri;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        response = request.get("/findByStatus?status=sold");
        addInfoLog("send request to get all sold pets");

        Assert.assertEquals(200, response.getStatusCode());
        addInfoLog("status cod from the request is: " + response.getStatusCode());

        String body = response.getBody().asString();
        jsonArray = new JSONArray(body);
    }

    @Then("verify all pets with status sold")
    public void verifyAllPetsWithStatusSold() {
        String status = "sold";
        boolean allStatusesTheSame = true;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            if (!jsonObject.get("status").equals(status)) {
                allStatusesTheSame = false;
                break;
            }
        }

        if (allStatusesTheSame) {
            addPassLog("all statuses is the same: sold");
        }
        else {
            addFailLog("not all statuses the same!");
        }
    }
}
