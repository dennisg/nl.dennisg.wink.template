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

@Path("mail")
public class MailResource {

	
	
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
        
		return Response.ok().build();
	}
}
