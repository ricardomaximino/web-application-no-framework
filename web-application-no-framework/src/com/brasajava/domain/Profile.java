package com.brasajava.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long profileId;
	private String name;
	private String lastname;
	private LocalDate birthday;
	@OneToMany
	private List<Contact> contacts;
	@Transient
	private List<LinkHateos> links;
	
	public Profile(){
		contacts = new ArrayList<>();
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<LinkHateos> getLinks() {
		return links;
	}
	public void setLinks(List<LinkHateos> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", name=" + name + ", lastname=" + lastname + ", birthday="
				+ birthday + ", contacts=" + contacts + "]";
	}
}
