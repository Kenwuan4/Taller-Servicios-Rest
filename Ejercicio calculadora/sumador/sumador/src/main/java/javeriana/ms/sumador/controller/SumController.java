package javeriana.ms.sumador.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SumController {

    LogController logController = new LogController();
    @Autowired
    Environment environment;



    @GetMapping("/suma")
    public String sum(@RequestParam int a,@RequestParam int b, @RequestParam String name ){
        String port = environment.getProperty("local.server.port");
        int result = a+b;
        String response = ("la suma tiene como resultado: " + result + " el microservicio esta corriendo en: " + port);
        logController.writeLog(name);
        return  response;
    }

    @GetMapping(value = "/suma/registros", produces = MediaType.APPLICATION_JSON_VALUE)
    public String registros(){

        ArrayList<LogController> logs = logController.readLogs();

        Gson gson = new Gson();
        String json = gson.toJson(logs);

        return json;

    }
}
