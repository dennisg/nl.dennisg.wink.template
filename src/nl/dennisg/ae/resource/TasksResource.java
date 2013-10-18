package nl.dennisg.ae.resource;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("task")
public class TasksResource {

	@GET
	public Response doGet() throws IOException {
		return Response.ok("OK").build();
	}
}
