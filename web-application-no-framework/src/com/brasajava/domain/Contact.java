package com.brasajava.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Contact {
	
	@Id
	@GeneratedValue
	private long contactId;
	private long profileId;
	private String description;
	private String contact;
	@Transient
	private List<LinkHateos>links;	
	
	public Contact(){
		links = new ArrayList<>();	
	}
	
	public Contact(long id, String description,String contact){
		this();
		this.contactId = id;
		this.description = description;
		this.contact = contact;
	}
	
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long id) {
		this.contactId = id;
	}
	
	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public List<LinkHateos> getLinks() {
		return links;
	}
	public void setLinks(List<LinkHateos> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Contact [id=" + contactId + ", description=" + description + ", contact=" + contact + "]";
	}
	
}
