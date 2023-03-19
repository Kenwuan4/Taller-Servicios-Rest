package javeriana.ms.division.controller;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@RestController
public class DivisionController {
    LogController logController = new LogController();
    @Autowired
    Environment environment;

    @GetMapping("/dividir")
    public String division(@RequestParam int a,@RequestParam int b, @RequestParam String name){
        String port = environment.getProperty("local.server.port");
        String response;
        if (b==0){
           response = ("no se puede dividir por cero "  + " el microservicio esta corriendo en: " + port);
        }
        else {
            float result = a/b;
            response = ("la multiplicacion tiene como resultado: " + result + " el microservicio esta corriendo en: " + port);
        }
        logController.writeLog(name);
        return  response;
    }

    @GetMapping(value = "/dividir/registros", produces = MediaType.APPLICATION_JSON_VALUE)
    public String registros(){
        ArrayList<LogController> logs = logController.readLogs();

        Gson gson = new Gson();
        String json = gson.toJson(logs);

        return json;
    }
}
