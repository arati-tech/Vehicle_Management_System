package com.sericeImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.config.HibernateUtil;
import com.app.exception.VehicleNotFoundException;
import com.app.exception.VehicleOperationExceptionn;
import com.app.model.Vehicle;
import com.app.servicei.Requirements;

public class RequrirementsImpl implements Requirements{

	@Override
	public void insertData(Vehicle v) {
		 Transaction tx = null;
		 try (Session session =HibernateUtil.getSessionFactory().openSession()) {
			 	tx = session.beginTransaction();
			 	session.persist(v);
			 	 tx.commit();
			 	 System.out.println("Vehicle inserted successfully...!");
		 }
		 catch (Exception e)
		 {
	    	   if (tx != null && tx.isActive()) {
	                tx.rollback();
		 }

	   throw new VehicleOperationExceptionn("Error inserting vehicle: " + e.getMessage(), e);
	        }
	    }

	            

	           
	            
	 	@Override
	public void getSingleData(int id) {
	 		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	            Vehicle v = session.get(Vehicle.class, id);

	            if (v == null) {
	                throw new VehicleNotFoundException(
	                        "Vehicle not found with ID: " + id);
	            }

	            System.out.println(v);

	        } catch (VehicleNotFoundException e) {
	            throw e;

	        } catch (Exception e) {
	            throw new VehicleOperationExceptionn(
	                    "Error retrieving vehicle: " + e.getMessage(), e);
	        }
	    }
	
	 	
	@Override
	public void getAllData() {
		try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<Vehicle> list = session
                    .createQuery("from Vehicle", Vehicle.class)
                    .getResultList();

            if (list.isEmpty()) {
                System.out.println("No vehicle records found!");
            } else {
                for (Vehicle v : list) {
                    System.out.println(v);
                    System.out.println("-------------------");
                }
            }

        } catch (Exception e) {
            throw new VehicleOperationExceptionn(
                    "Error retrieving vehicles: " + e.getMessage(), e);
        }
	}

	@Override
	public void updateData(int id, String name, String number, String type, Double price) {
		try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<Vehicle> list = session
                    .createQuery("from Vehicle", Vehicle.class)
                    .getResultList();

            if (list.isEmpty()) {
                System.out.println("No vehicle records found!");
            } else {
                for (Vehicle v : list) {
                    System.out.println(v);
                    System.out.println("-------------------");
                }
            }

        } catch (Exception e) {
            throw new VehicleOperationExceptionn(
                    "Error retrieving vehicles: " + e.getMessage(), e);
        }
	}

	@Override
	public void deleteData(int id) {
		Transaction tx = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            Vehicle v = session.get(Vehicle.class, id);

            if (v == null) {
                throw new VehicleNotFoundException(
                        "Vehicle not found with ID: " + id);
            }

            session.remove(v);

            tx.commit();

            System.out.println("Vehicle deleted successfully!");

        } catch (Exception e) {

            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            if (e instanceof VehicleNotFoundException) {
                throw (VehicleNotFoundException) e;
            }

            throw new VehicleOperationExceptionn(
                    "Error deleting vehicle: " + e.getMessage(), e);
        }
	}

	@Override
	public void deleteAllData() {
		   Transaction tx = null;

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            tx = session.beginTransaction();

	            List<Vehicle> list = session
	                    .createQuery("from Vehicle", Vehicle.class)
	                    .getResultList();

	            for (Vehicle v : list) {
	                session.remove(v);
	            }

	            tx.commit();

	            System.out.println("All vehicle records deleted!");

	        } catch (Exception e) {

	            if (tx != null && tx.isActive()) {
	                tx.rollback();
	            }

	            throw new VehicleOperationExceptionn(
	                    "Error deleting all vehicles: " + e.getMessage(), e);
	        }
	    }
	}


