package javeriana.ms.multiplicacion.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MultiplicacionController {

    LogController logController = new LogController();
    @Autowired
    Environment environment;

    @GetMapping("/multiplicar")
    public String multi(@RequestParam int a,@RequestParam int b, @RequestParam String name){
        String port = environment.getProperty("local.server.port");
        int result = a*b;
        String response = ("la multiplicacion tiene como resultado: " + result + " el microservicio esta corriendo en: " + port);
        logController.writeLog(name);
        return  response;
    }

    @GetMapping(value = "/multiplicar/registros", produces = MediaType.APPLICATION_JSON_VALUE)
    public String registros(){
        ArrayList<LogController> logs = logController.readLogs();

        Gson gson = new Gson();
        String json = gson.toJson(logs);

        return json;
    }
}
