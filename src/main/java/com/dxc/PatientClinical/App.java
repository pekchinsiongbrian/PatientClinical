package com.dxc.PatientClinical;

import java.util.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dxc.entity.ClinicalData;
import com.dxc.entity.PatientData;

public class App {
	private static SessionFactory factory;
    public static void main(String[] args) {
    	try {
        	// create factory object
        	factory = new Configuration().configure("/resource/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
        	System.err.println("Failed to create session instance.");
        	throw new ExceptionInInitializerError(e);
        }
    	
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
        
        ClinicalData cd1 = new ClinicalData();
        cd1.setComponentName("Height");
        cd1.setComponentValue(1.72);
        cd1.setMeasuredDateTime(new Date());
        
        ClinicalData cd2 = new ClinicalData();
        cd2.setComponentName("Weight");
        cd2.setComponentValue(65.9);
        cd2.setMeasuredDateTime(new Date());
        
        ArrayList<ClinicalData> list1 = new ArrayList<ClinicalData>();
        list1.add(cd1);
        list1.add(cd2);
        
        PatientData pd1 = new PatientData();
        pd1.setFname("Lee");
        pd1.setLname("Jun Hao");
        pd1.setAge(28);
        pd1.setClinicalData(list1);
        
        ClinicalData cd3 = new ClinicalData();
        cd3.setComponentName("Height");
        cd3.setComponentValue(1.77);
        cd3.setMeasuredDateTime(new Date());
        
        ClinicalData cd4 = new ClinicalData();
        cd4.setComponentName("Weight");
        cd4.setComponentValue(59.8);
        cd4.setMeasuredDateTime(new Date());
        
        ArrayList<ClinicalData> list2 = new ArrayList<ClinicalData>();
        list2.add(cd3);
        list2.add(cd4);
        
        PatientData pd2 = new PatientData();
        pd2.setFname("Brian");
        pd2.setLname("Pek");
        pd2.setAge(25);
        pd2.setClinicalData(list2);
        
        session.persist(pd1);
        session.persist(pd2);
        tx.commit();
        
        session.close();
        System.out.println("success");
    }
}