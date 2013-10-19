package nl.dennisg.ae.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

/**
 * JAX-RS REST endpoint for XMPP chat events.
 * docs available at: https://developers.google.com/appengine/docs/java/xmpp
 * 
 * @author dennisg
 *
 */
@Path("xmpp")
public class XMPPResource {

	@POST
	@Path("message/error")
	public Response handleError(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}
	
	@POST
	@Path("message/chat")
	public Response doChatMessage(@Context HttpServletRequest req) throws IOException {
		
		XMPPService xmpp = XMPPServiceFactory.getXMPPService();
        Message message = xmpp.parseMessage(req);

        JID fromJid = message.getFromJid();
        String body = message.getBody();
        
        System.out.println("chat message from: " + fromJid);
        System.out.println("chat message: " + body);
        
        // TODO: handle the message. Based on the sender jid, you can decide
        // whether to trust the sender, and parse it's message, or not...
        // a great use for it would be to return e.g. usage information,
        // to turn on/ off some feature or add something to a task queue, etc.
        
        Message responseMessage = new MessageBuilder()
        	.withRecipientJids(fromJid)
        	.withBody("okay, consider it done...")
        	.build();
        xmpp.sendMessage(responseMessage);
        
		//200 OK
		return Response.ok().build();
	}

	
	@POST
	@Path("presence/available")
	public Response doAvailablePresence(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}	

	@POST
	@Path("presence/unavailable")
	public Response doUnavailablePresence(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}
	
	@POST
	@Path("subscription/subscribe")
	public Response doSubscribe(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}	

	@POST
	@Path("subscription/subscribed")
	public Response doSubscribed(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}	

	@POST
	@Path("subscription/unsubscribe")
	public Response doUnsubscribe(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}	

	@POST
	@Path("/subscription/unsubscribed")
	public Response doUnsubscribed(@Context HttpServletRequest req) throws IOException {
		//200 OK
		return Response.ok().build();
	}	

}
