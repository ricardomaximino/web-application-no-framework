package com.brasajava.servers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.brasajava.daos.ContactDaoImpl;
import com.brasajava.domain.Contact;
import com.brasajava.domain.LinkHateos;
import com.brasajava.exceptions.DataNotFoundException;

@Path("/contacts")
public class ContactServer {
	private ContactDaoImpl dao;
	
	public ContactServer(){
		dao = new ContactDaoImpl();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getAllContacts(){
		return dao.findAll();
	}
	
	@GET
	@Path("/{contactId}")
	@Produces(MediaType.APPLICATION_JSON		)
	public Contact getContact(@PathParam("contactId") int contactId, @Context UriInfo uriInfo){
		Contact contact =  dao.findOne(contactId);
		if(contact == null){
			throw new DataNotFoundException("Contact with id: " + contactId + " was not found.");
		}
		String uri = createSelfLink(uriInfo, contact);
		addLinks(contact, uri, "self");
		return contact;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact addContact(Contact contact){
		return dao.save(contact);
	}
	
	@Path("/{contactId}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact editContact(@PathParam("contactId") long contactid, Contact contact){
		Contact contactDb = dao.findOne(contactid);
		contactDb.setContact(contact.getContact());
		contactDb.setDescription(contact.getDescription());
		contactDb.setLinks(contact.getLinks());
		contactDb.setProfileId(contact.getProfileId());
		return dao.save(contactDb);
	}

	private String createSelfLink(UriInfo uriInfo,Contact contact){
		return uriInfo.getBaseUriBuilder().path(ContactServer.class).path(String.valueOf(contact.getContactId())).build().toString();		
	}
	
	private void addLinks(Contact contact,String uri,String rel){
		contact.getLinks().add(new LinkHateos(uri,rel));
	}
}
