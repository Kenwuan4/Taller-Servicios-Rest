package javeriana.ms.rest.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import javeriana.ms.rest.model.Trip;
import javeriana.ms.rest.repository.TripRepository;
import java.util.ArrayList;

@Path("/trips")
public class TripController {

    static TripRepository tripRepository = new TripRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trip> getTrips() {
        return tripRepository.getTripList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Trip getTrips(@PathParam("id") String id){
        return tripRepository.getTrip(id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteTrips(@PathParam("id") String id){
        return tripRepository.deleteTrip(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String changeSite(@PathParam("id") String id, Trip trip){
        return tripRepository.customSiteTrip(id, trip.getStartSite(), trip.getFinishSite());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createTrip(Trip trip){
        return tripRepository.createTrip(trip);
    }

}
