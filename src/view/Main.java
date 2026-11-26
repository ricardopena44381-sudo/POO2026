package view;

import domain.*;
import java.util.Scanner;

public class Main {
    private static Shape[] shapes = new Shape[100]; // Fixed-size array managed in Main
    private static int shapeCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        do {
            showMenu();
            try {
                System.out.print("Select an option: ");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        createShape();
                        break;
                    case 2:
                        showAllShapes();
                        break;
                    case 3:
                        findShapeById();
                        break;
                    case 4:
                        calculateTotals();
                        break;
                    case 5:
                        System.out.println("Exiting program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Please enter a valid numeric option.");
            } catch (IllegalArgumentException e) {
                System.out.println("[Domain Error] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[Unexpected Error] " + e.getMessage());
            }
            System.out.println();
        } while (option != 5);
    }

    private static void showMenu() {
        System.out.println("=== GEOMETRIC SHAPES SYSTEM ===");
        System.out.println("1. Create a new shape");
        System.out.println("2. Show all stored shapes");
        System.out.println("3. Search shape by ID");
        System.out.println("4. Calculate total area and perimeter");
        System.out.println("5. Exit");
    }

    private static void createShape() {
        if (shapeCount >= shapes.length) {
            System.out.println("Storage is full!");
            return;
        }

        System.out.println("\n--- Select Shape Type ---");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Circle");
        System.out.println("5. Ellipse");
        System.out.print("Choose type: ");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        
        // Check for duplicate ID
        for (int i = 0; i < shapeCount; i++) {
            if (shapes[i].getId().equalsIgnoreCase(id)) {
                System.out.println("[Error] A shape with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter center X coordinate: ");
        double x = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter center Y coordinate: ");
        double y = Double.parseDouble(scanner.nextLine());

        Shape newShape = null;

        switch (type) {
            case 1:
                System.out.print("Enter side length: ");
                double side = Double.parseDouble(scanner.nextLine());
                newShape = new Square(id, x, y, side);
                break;
            case 2:
                System.out.print("Enter width: ");
                double width = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter height: ");
                double height = Double.parseDouble(scanner.nextLine());
                newShape = new Rectangle(id, x, y, width, height);
                break;
            case 3:
                System.out.print("Enter side A: ");
                double sa = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter side B: ");
                double sb = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter side C: ");
                double sc = Double.parseDouble(scanner.nextLine());
                newShape = new Triangle(id, x, y, sa, sb, sc);
                break;
            case 4:
                System.out.print("Enter radius: ");
                double radius = Double.parseDouble(scanner.nextLine());
                newShape = new Circle(id, x, y, radius);
                break;
            case 5:
                System.out.print("Enter major radius (semi-major axis): ");
                double major = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter minor radius (semi-minor axis): ");
                double minor = Double.parseDouble(scanner.nextLine());
                newShape = new Ellipse(id, x, y, major, minor);
                break;
            default:
                System.out.println("Invalid shape type selected.");
                return;
        }

        shapes[shapeCount] = newShape;
        shapeCount++;
        System.out.println("Shape created and stored successfully!");
    }

    private static void showAllShapes() {
        if (shapeCount == 0) {
            System.out.println("No shapes stored yet.");
            return;
        }

        System.out.println("\n--- Stored Shapes ---");
        for (int i = 0; i < shapeCount; i++) {
            Shape s = shapes[i];
            printShapeDetails(s);
            System.out.println("--------------------");
        }
    }

    private static void findShapeById() {
        if (shapeCount == 0) {
            System.out.println("No shapes stored yet.");
            return;
        }

        System.out.print("Enter the ID to search: ");
        String searchId = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < shapeCount; i++) {
            if (shapes[i].getId().equalsIgnoreCase(searchId)) {
                System.out.println("\n--- Shape Found ---");
                printShapeDetails(shapes[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No shape found with ID: " + searchId);
        }
    }

    private static void calculateTotals() {
        if (shapeCount == 0) {
            System.out.println("No shapes stored yet.");
            return;
        }

        double totalArea = 0;
        double totalPerimeter = 0;

        // Polimorfismo en acción al recorrer el arreglo Shape[]
        for (int i = 0; i < shapeCount; i++) {
            totalArea += shapes[i].calculateArea();
            totalPerimeter += shapes[i].calculatePerimeter();
        }

        System.out.println("\n--- Global Metrics ---");
        System.out.println("Total Shapes Count: " + shapeCount);
        System.out.printf("Total Area: %.2f\n", totalArea);
        System.out.printf("Total Perimeter: %.2f\n", totalPerimeter);
    }

    private static void printShapeDetails(Shape s) {
        System.out.println("ID: " + s.getId());
        System.out.println("Type: " + s.getClass().getSimpleName());
        System.out.println("Position: (" + s.getX() + ", " + s.getY() + ")");
        
        // Specific dimensions display using pattern matching / casting if needed
        if (s instanceof Square) {
            System.out.println("Side: " + ((Square) s).getSide());
        } else if (s instanceof Rectangle) {
            Rectangle r = (Rectangle) s;
            System.out.println("Width: " + r.getWidth() + ", Height: " + r.getHeight());
        } else if (s instanceof Triangle) {
            Triangle t = (Triangle) s;
            System.out.println("Sides: A=" + t.getSideA() + ", B=" + t.getSideB() + ", C=" + t.getSideC());
        } else if (s instanceof Circle) {
            System.out.println("Radius: " + ((Circle) s).getRadius());
        } else if (s instanceof Ellipse) {
            Ellipse e = (Ellipse) s;
            System.out.println("Major Radius: " + e.getMajorRadius() + ", Minor Radius: " + e.getMinorRadius());
        }

        System.out.printf("Area: %.2f\n", s.calculateArea());
        System.out.printf("Perimeter: %.2f\n", s.calculatePerimeter());
    }
}
