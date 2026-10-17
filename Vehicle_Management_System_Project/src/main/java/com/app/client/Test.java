
package com.app.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.config.HibernateUtil;
import com.app.exception.VehicleNotFoundException;
import com.app.exception.VehicleOperationExceptionn;
import com.app.model.Insurance;
import com.app.model.ServiceRecord;
import com.app.model.Vehicle;
import com.app.servicei.Requirements;
import com.sericeImpl.RequrirementsImpl;


public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Requirements req = new RequrirementsImpl();

        try {
            int choice;

            do {
                System.out.println("\n===== VEHICLE MANAGEMENT SYSTEM =====");
                System.out.println("1. Insert Vehicle");
                System.out.println("2. Retrieve Vehicle by ID");
                System.out.println("3. Retrieve All Vehicles");
                System.out.println("4. Update Vehicle");
                System.out.println("5. Delete Vehicle");
                System.out.println("6. Delete All Vehicles");
                System.out.println("0. Exit");

                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());

                try {
                    switch (choice) {

                        case 1: {
                            Vehicle v = new Vehicle();

                            System.out.print("Enter Vehicle Name: ");
                            v.setVehicleName(sc.nextLine());

                            System.out.print("Enter Vehicle Number: ");
                            v.setVehicleNumber(sc.nextLine());

                            System.out.print("Enter Vehicle Type: ");
                            v.setVehicleType(sc.nextLine());

                            System.out.print("Enter Vehicle Price: ");
                            v.setPrice(Double.parseDouble(sc.nextLine()));

                            Insurance insurance = new Insurance();

                            System.out.print("Enter Insurance Company: ");
                            insurance.setInsuranceCompany(sc.nextLine());

                            System.out.print("Enter Policy Number: ");
                            insurance.setPolicyNumber(sc.nextLine());

                            System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
                            insurance.setExpiryDate(
                                    LocalDate.parse(sc.nextLine()));

                            v.setInsurance(insurance);

                            List<ServiceRecord> records =
                                    new ArrayList<>();

                            System.out.print("Enter Number of Service Records: ");
                            int n = Integer.parseInt(sc.nextLine());

                            for (int i = 1; i <= n; i++) {

                                ServiceRecord sr = new ServiceRecord();

                                System.out.println("Service Record " + i);

                                System.out.print("Enter Service Date (yyyy-mm-dd): ");
                                sr.setServiceDate(
                                        LocalDate.parse(sc.nextLine()));

                                System.out.print("Enter Service Type: ");
                                sr.setServiceType(sc.nextLine());

                                System.out.print("Enter Service Cost: ");
                                sr.setSeriveCost(
                                        Double.parseDouble(sc.nextLine()));

                                records.add(sr);
                            }

                            v.setServicerecord(records);

                            req.insertData(v);
                            break;
                        }

                        case 2: {
                            System.out.print("Enter Vehicle ID: ");
                            int id = Integer.parseInt(sc.nextLine());

                            req.getSingleData(id);
                            break;
                        }

                        case 3: {
                            req.getAllData();
                            break;
                        }

                        case 4: {
                            System.out.print("Enter Vehicle ID: ");
                            int id = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter New Vehicle Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter New Vehicle Number: ");
                            String number = sc.nextLine();

                            System.out.print("Enter New Vehicle Type: ");
                            String type = sc.nextLine();

                            System.out.print("Enter New Vehicle Price: ");
                            double price = Double.parseDouble(sc.nextLine());

                            req.updateData(id, name, number, type, price);
                            break;
                        }

                        case 5: {
                            System.out.print("Enter Vehicle ID to Delete: ");
                            int id = Integer.parseInt(sc.nextLine());

                            req.deleteData(id);
                            break;
                        }

                        case 6: {
                            System.out.print(
                                    "Delete ALL vehicles and associated records? (yes/no): ");

                            String confirm = sc.nextLine();

                            if (confirm.equalsIgnoreCase("yes")) {
                                req.deleteAllData();
                            } else {
                                System.out.println("Deletion cancelled.");
                            }
                            break;
                        }

                        case 0:
                            System.out.println("Exiting application...");
                            break;

                        default:
                            System.out.println("Invalid choice!");
                    }

                } catch (VehicleNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());

                } catch (VehicleOperationExceptionn e) {
                    System.out.println("Operation failed: "
                            + e.getMessage());

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } while (choice != 0);

        } finally {
            sc.close();
            HibernateUtil.shutdown();
        }
    }
}
