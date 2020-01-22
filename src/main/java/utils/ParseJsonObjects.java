package utils;

import com.google.gson.Gson;
import models.InvalidUserData;
import models.UserData;
import org.apache.commons.io.IOUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonObjects {

    public String serializeListObjects() {
        List<UserData> data = new ArrayList<>();
        data.add(new UserData(
                "lindsay.ferguson@reqres.in",
                "Lindsay",
                "Ferguson",
                "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg"));
        data.add(new UserData(
                "janet.weaver@reqres.in",
                "Janet",
                "Weaver",
                "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"));

        String json = new Gson().toJson(data);

        try (FileWriter file = new FileWriter("src/main/resources/savedUsers.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String serializeUpdatedObject(boolean isPartly) {
        UserData data = null;

        if (!isPartly) {
            data = new UserData(
                    "petro.bluth@reqres.in",
                    "Petro",
                    "Petrovych",
                    "https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg");
        } else {
            data = new UserData(
                    null,
                    "Petro",
                    "Petrovych",
                    null);
        }

        String json = new Gson().toJson(data);

        try (FileWriter file = new FileWriter("src/main/resources/savedUsers.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String serializeInvalidObject() {
        InvalidUserData data = new InvalidUserData(
                    "Ivan",
                    "Manager",
                    "Skiing");

        String json = new Gson().toJson(data);

        try (FileWriter file = new FileWriter("src/main/resources/savedUsers.json")) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public UserData deserializeObject() {
        InputStream in = ParseJsonObjects.class.getClassLoader().getResourceAsStream("simpleUser.json");
        String result = null;

        try {
            assert in != null;
            result = IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserData userData = new Gson().fromJson(result, UserData.class);
        return userData;
    }
}
