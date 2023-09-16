package reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadDataDrivenFromJson {


    String successfulLogin = "SuccessfulLogin";




    public String[] readJson(String testStatus) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("data/dataDriven.json");
        Object object =jsonParser.parse(fileReader);
        JSONObject jsonObject =(JSONObject)object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(testStatus);
        String arr[] = new String[jsonArray.size()];

        for (int i =0;i< jsonArray.size();i++) {
            JSONObject users = (JSONObject) jsonArray.get(i);
            String user = (String) users.get("Email");
            String password = (String) users.get("Password");


            arr[i] = user+","+password;

            // [0] Omar,123
            // [1] Mohamed,456
        }
        return arr;
    }



    public String[] testDataForSuccessfulLogin() throws IOException, ParseException {
        return readJson(successfulLogin);
    }


//    public String[] testDataForInvalidUsername() throws IOException, ParseException {
//        return readJson("Hello");
//    }

}
