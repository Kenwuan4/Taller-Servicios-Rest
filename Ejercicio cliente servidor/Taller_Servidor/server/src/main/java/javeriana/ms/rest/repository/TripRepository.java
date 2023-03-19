package javeriana.ms.rest.repository;

import javeriana.ms.rest.model.Trip;

import java.io.*;
import java.util.ArrayList;

public class TripRepository {

    ArrayList<Trip> tripList;

    public TripRepository(){
        this.tripList = new ArrayList<Trip>();
        readBd();
    }

    public void saveBd(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bd.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.tripList);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBd(){

        try {
            FileInputStream fileOutputStream = new FileInputStream("bd.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
            this.tripList = (ArrayList<Trip>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Trip> getTripList(){
        return this.tripList;
    }

    public Trip getTrip(String id){
        for(Trip t: this.tripList){
            if(t.getId().equals(id))
                return t;
        }
        return null;
    }

    public String deleteTrip(String id){
        Trip trip = null;

        for(Trip t: this.tripList){
            if(t.getId().equals(id))
                trip = t;

        }

        if(trip != null){
            this.tripList.remove(trip);
            saveBd();
            return "Se elimino exitosamente el viaje";
        }
        else{
            return "No se encontro el viaje con el viaje especificado";
        }
    }

    public String customSiteTrip(String id, String starSite, String finishSite){
        for(Trip t: this.tripList){
            if(t.getId().equals(id)){
                t.setStartSite(starSite);
                t.setFinishSite(finishSite);
                saveBd();
                return "Viaje modificado con exito";
            }
        }
        return "No se encontro el viaje";
    }

    public String createTrip(Trip trip){
        this.tripList.add(trip);
        saveBd();
        return "Viaje creado con exito";
    }

}
