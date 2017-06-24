package com.brasajava.daos;

import java.util.ArrayList;
import java.util.List;

import com.brasajava.domain.Contact;


public class ContactDao {

	private static List<Contact> db = new ArrayList<>();
	private static final String[] contactDescription = {"PHONE","MOBILE","E-MAIL"};
	
		
	public ContactDao(){
		System.out.println("Initiating ContactDao");
		db = new ArrayList<	>();
		Contact contact = null;
		for(int i = 0;i<10;i++){
			int y = 0;
			contact = new Contact(i,contactDescription[y],"Contact - " + i);
			db.add(contact);
			y++;
			if(y > 2) y = 0;
		}
	}
	
	public static List<Contact> getDb(){
		return db;
	}
	
	public List<Contact> getList(){
		return db.subList(0, db.size()-1);
	}
}
