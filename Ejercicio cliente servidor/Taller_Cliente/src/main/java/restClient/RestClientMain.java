package restClient;

import restClient.model.Trip;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Scanner;

public class RestClientMain {

    public static final String SERVER_URL = "http://localhost:8080/api";
    public static Client client = ClientBuilder.newClient();
    public static WebTarget webTarget = client.target(SERVER_URL);

    public static void main(String args[]){

        int opt = -1;
        Scanner obj = new Scanner(System.in);

        while (true){

            menu();
            System.out.print("Ingrese la opción que desea: ");
            opt = obj.nextInt();

            if(opt == 1){
                System.out.println("Lista de viajes \n");
                printTrips();
                System.out.println("\n");
            }

            if (opt == 2){
                System.out.println("Eliminar Viaje \n");
                obj.nextLine();
                System.out.print("Ingrese el id del viaje que desea eliminar: ");
                String id = obj.nextLine();
                deleteTrip(id);
            }

            if (opt == 3){
                System.out.println("Modificar Viaje \n");
                obj.nextLine();
                System.out.print("Ingrese el id del viaje que desea modificar: ");
                String id = obj.nextLine();

                if(isExist(id)){
                    System.out.print("Ingrese el lugar de origen del viaje: ");
                    String startSite = obj.nextLine();
                    System.out.print("Ingrese el lugar de destino del viaje: ");
                    String endSite = obj.nextLine();
                    changeSites(id, startSite, endSite);
                }
                else {
                    System.out.println("No se encontro el viaje");
                }
            }

            if (opt == 4){
                System.out.println("Crear Viaje \n");
                obj.nextLine();
                System.out.print("Ingrese el id del viaje: ");
                String id = obj.nextLine();
                System.out.print("Ingrese el nombre del viaje: ");
                String name = obj.nextLine();
                System.out.print("Ingrese el lugar de origen del viaje: ");
                String startSite = obj.nextLine();
                System.out.print("Ingrese el lugar de destino del viaje: ");
                String endSite = obj.nextLine();
                System.out.print("Ingrese la fecha del viaje: ");
                String date = obj.nextLine();

                Trip trip = new Trip(id, name, startSite, endSite, date);

                createTrip(trip);
            }

            if (opt == 0){
                break;
            }
        }
    }

    public static boolean isExist(String id){
        Response response = webTarget.path("/trips/" + id).request(MediaType.APPLICATION_JSON).get();
        Trip result = response.readEntity(Trip.class);
        if (result != null)
            return true;

        return false;
    }

    public static void printTrips(){
        Response response = webTarget.path("/trips").request(MediaType.APPLICATION_JSON).get();
        String result = response.readEntity(String.class);
        System.out.println(result);
    }

    public static void deleteTrip(String id){
        Response response = webTarget.path("/trips/" + id).request().delete();
        String result = response.readEntity(String.class);
        System.out.println(result);
    }

    public static void changeSites(String id, String startSite, String endSite){
        Response response = webTarget.path("/trips/" + id).request(MediaType.APPLICATION_JSON).get();
        Trip result = response.readEntity(Trip.class);

        result.setStartSite(startSite);
        result.setFinishSite(endSite);

        Response response1 = webTarget.path("/trips/" + id).request().put(Entity.entity(result, MediaType.APPLICATION_JSON));
        String result1 = response1.readEntity(String.class);
        System.out.println(result1);
    }

    public static void createTrip(Trip trip){
        Response response = webTarget.path("/trips").request().post(Entity.entity(trip, MediaType.APPLICATION_JSON));
        String result = response.readEntity(String.class);
        System.out.println(result);
    }

    public static void menu(){
        System.out.println("MENU");
        System.out.println("1. Obtener Viajes");
        System.out.println("2. Eliminar Viaje");
        System.out.println("3. Modificar lugares de origen y destino de un viaje");
        System.out.println("4. Crear Viaje");
        System.out.println("0. Salir");
    }

}
