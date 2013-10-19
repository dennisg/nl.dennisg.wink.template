package nl.dennisg.ae.resource;

import java.io.IOException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * example JAX-RS REST endpoint for task queues
 * 
 * @author dennisg
 *
 */
@Path("task")
public class TaskResource {

	@POST
	@Path("example")
	public Response doGet(@FormParam("name") String name) throws IOException {

		//do something with the given name, anything...
		System.out.println("Starting example task for: " + name);
		
		
		//200 OK
		return Response.ok().build();
	}
}
