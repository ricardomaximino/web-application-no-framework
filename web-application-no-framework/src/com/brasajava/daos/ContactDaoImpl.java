package com.brasajava.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.brasajava.domain.Contact;

public class ContactDaoImpl {
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction et;

	public ContactDaoImpl() {
		emf = Persistence.createEntityManagerFactory("noframework");
	}

	public Contact save(Contact contact) {
		if (contact != null) {

			try {
				em = emf.createEntityManager();
				et = em.getTransaction();
				et.begin();
				if (contact.getContactId() == 0) {
					em.persist(contact);
				} else {
					em.merge(contact);
				}
				et.commit();
				em.close();
			} catch (RuntimeException ex) {
				ex.printStackTrace();
				if (em != null) {
					et.rollback();
					return null;
				}
			}

		}
		return contact;
	}

	public boolean delete(long id) {
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Contact contact = em.find(Contact.class, id);
			em.remove(contact);
			et.commit();
			em.close();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (em != null) {
				et.rollback();
				return false;
			}
		}

		return true;
	}

	public Contact findOne(long id) {
		Contact contact = null;
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			contact = em.find(Contact.class, id);
			et.commit();
			em.close();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (em != null) {
				et.rollback();
				return null;
			}
		}
		return contact;
	}

	public List<Contact> findAll() {
		List<Contact> list = new ArrayList<Contact>();
		try {
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			List<?> l = em.createQuery("FROM Contact").getResultList();
			for (Object o : l) {
				list.add((Contact) o);
			}
			et.commit();
			em.close();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			if (em != null) {
				et.rollback();
				return null;
			}
		}
		return list;
	}
}
