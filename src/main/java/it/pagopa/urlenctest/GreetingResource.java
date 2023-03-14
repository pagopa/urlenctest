package it.pagopa.urlenctest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

@Path("/greeting")
public class GreetingResource {
    @GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	public Uni<String> hello(@PathParam("name") String name) {
		Log.debugf("name = [%s]", name);
		return Uni.createFrom().item(String.format("Hello %s!",  name));
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}/{surname}")
	public Uni<String> goodbye(@PathParam("name") String name, @PathParam("surname") String surname) {
		Log.debugf("name = [%s], surname= [%s]", name, surname);
		return Uni.createFrom().item(String.format("Goodbye %s %s!", name, surname));
	}
}