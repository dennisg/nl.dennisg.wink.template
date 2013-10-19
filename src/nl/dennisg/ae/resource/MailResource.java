package nl.dennisg.ae.resource;

import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * JAX-RS REST endpoint for the incoming mail.
 * 
 * @author dennisg
 *
 */
@Path("mail")
public class MailResource {

	
	
	/**
	 * Receive an email. Using the request <code>InputStream</code>, 
	 * you can construct a MimeMessage. Dissect it to parse the available
	 * Multipart message parts.
	 * 
	 * @param email the target (receiving) email address.
	 * @param req the <code>HttpServletRequest</code>
	 * @return a proper <code>Response</code>
	 * @throws IOException, usually when we fail to construct the MimeMessage from the request.
	 * @throws MessagingException
	 */
	@POST
	@Path("{email}")
	public Response receiveMail(@PathParam("email") String email, @Context HttpServletRequest req) throws IOException, MessagingException {
		System.out.println("email to: " + email);
		
		Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null); 
        MimeMessage message = new MimeMessage(session, req.getInputStream());
        
        System.out.println(message.getFrom()[0]);
        
        MimeMultipart mp = (MimeMultipart)message.getContent();
        System.out.println(mp.getBodyPart(0).getContent());
        
        
        //200 OK
		return Response.ok().build();
	}
}
