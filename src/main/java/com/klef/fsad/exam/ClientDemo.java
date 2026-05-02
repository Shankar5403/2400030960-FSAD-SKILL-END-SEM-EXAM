package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {
        // Build SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Vehicle Management System ===");
            System.out.println("1. Insert a new Vehicle record");
            System.out.println("2. Update Vehicle Name/Status by ID");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertVehicle(sessionFactory);
                    break;
                case 2:
                    System.out.print("Enter Vehicle ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Status: ");
                    String newStatus = scanner.nextLine();
                    updateVehicle(sessionFactory, id, newName, newStatus);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 3);

        scanner.close();
        sessionFactory.close();
    }

    // I. Insert a new record into the database
    public static void insertVehicle(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Vehicle vehicle = new Vehicle();
            vehicle.setName("Toyota Camry");
            vehicle.setDescription("A highly reliable and fuel-efficient mid-size sedan.");
            vehicle.setDate(new Date()); // Sets current date
            vehicle.setStatus("Available");
            vehicle.setType("Sedan");
            vehicle.setPrice(25000.50);

            // Save the entity
            session.save(vehicle);
            transaction.commit();
            System.out.println("Vehicle inserted successfully! Generated ID: " + vehicle.getId());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Failed to insert vehicle.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // II. Update fields such as Name or Status based on the ID
    public static void updateVehicle(SessionFactory sessionFactory, int id, String newName, String newStatus) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Fetch the vehicle by ID
            Vehicle vehicle = session.get(Vehicle.class, id);

            if (vehicle != null) {
                // Update Name and Status
                vehicle.setName(newName);
                vehicle.setStatus(newStatus);

                // Hibernate will automatically update the record when we commit
                session.update(vehicle);
                transaction.commit();
                System.out.println("Vehicle with ID " + id + " updated successfully!");
                System.out.println("Updated Details: " + vehicle);
            } else {
                System.out.println("Vehicle with ID " + id + " not found in the database.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Failed to update vehicle.");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
