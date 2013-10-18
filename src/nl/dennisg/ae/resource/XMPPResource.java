package nl.dennisg.ae.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("xmpp")
public class XMPPResource {

	@GET
	public Response doGet() throws IOException {
		return Response.ok("OK").build();
	}
	
	
	@POST
	@Path("message/chat")
	public Response doChatMessage(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}

	
	@POST
	@Path("presence/available")
	public Response doAvailablePresence(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}	

	@POST
	@Path("presence/unavailable")
	public Response doUnavailablePresence(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}
	
	@POST
	@Path("subscription/subscribe")
	public Response doSubscribe(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}	

	@POST
	@Path("subscription/subscribed")
	public Response doSubscribed(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}	

	@POST
	@Path("subscription/unsubscribe")
	public Response doUnsubscribe(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}	

	@POST
	@Path("/subscription/unsubscribed")
	public Response doUnsubscribed(@Context HttpServletRequest req) throws IOException {
		return Response.ok().build();
	}	

}
