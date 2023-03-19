package javeriana.ms.calculadora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/calculadora/suma")
    public String calculadoraSuma (@RequestParam int a, @RequestParam int b, @RequestParam String name){
        String response = restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&name={name}", String.class, a,b,name);
        return response;
    }

    @GetMapping(value = "/calculadora/suma/registros", produces = MediaType.APPLICATION_JSON_VALUE)
    public String calculadoraSumaReg (){
        String response = restTemplate.getForObject("http://sumador/suma/registros",String.class);
        return response;
    }

    @GetMapping("/calculadora/resta")
    public String calculadoraResta (@RequestParam int a, @RequestParam int b, @RequestParam String name){
        String response = restTemplate.getForObject("http://restador/resta?a={a}&b={b}&name={name}", String.class, a,b,name);
        return response;
    }

    @GetMapping("/calculadora/resta/registros")
    public String calculadoraRestaRegi (){
        String response = restTemplate.getForObject("http://restador/resta/registros", String.class);
        return response;
    }

    @GetMapping("/calculadora/multiplicar")
    public String calculadoraMulti (@RequestParam int a, @RequestParam int b, @RequestParam String name){
        String response = restTemplate.getForObject("http://multiplicador/multiplicar?a={a}&b={b}&name={name}", String.class, a, b, name);
        return response;
    }

    @GetMapping("/calculadora/multiplicar/registros")
    public String calculadoraMultiRegi (){
        String response = restTemplate.getForObject("http://multiplicador/multiplicar/registros", String.class);
        return response;
    }

    @GetMapping("/calculadora/dividir")
    public String calculadoraDividir (@RequestParam int a, @RequestParam int b, @RequestParam String name){
        String response = restTemplate.getForObject("http://divisor/dividir?a={a}&b={b}&name={name}", String.class, a,b,name);
        return response;
    }

    @GetMapping("/calculadora/dividir/registros")
    public String calculadoraDividirRegis (){
        String response = restTemplate.getForObject("http://divisor/dividir/registros", String.class);
        return response;
    }
}
