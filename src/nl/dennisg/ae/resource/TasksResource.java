package nl.dennisg.ae.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * example JAX-RS REST endpoint for task queues
 * 
 * @author dennisg
 *
 */
@Path("task")
public class TasksResource {

	@GET
	public Response doGet() throws IOException {
		
		//200 OK
		return Response.ok().build();
	}
}
