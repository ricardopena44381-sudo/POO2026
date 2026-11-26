classDiagram
    direction TB

    class Shape {
        <<abstract>>
        - String id
        - double x
        - double y
        + Shape(String id, double x, double y)
        + String getId()
        + void setId(String id)
        + double getX()
        + void setX(double x)
        + double getY()
        + void setY(double y)
        + calculateArea()* double
        + calculatePerimeter()* double
    }

    class Square {
        - double side
        + Square(String id, double x, double y, double side)
        + double getSide()
        + void setSide(double side)
        + double calculateArea()
        + double calculatePerimeter()
    }

    class Rectangle {
        - double width
        - double height
        + Rectangle(String id, double x, double y, double width, double height)
        + double getWidth()
        + void setWidth(double width)
        + double getHeight()
        + void setHeight(double height)
        + double calculateArea()
        + double calculatePerimeter()
    }

    class Triangle {
        - double sideA
        - double sideB
        - double sideC
        + Triangle(String id, double x, double y, double sideA, double sideB, double sideC)
        + double getSideA()
        + double getSideB()
        + double getSideC()
        + void setSides(double sideA, double sideB, double sideC)
        + double calculateArea()
        + double calculatePerimeter()
    }

    class Circle {
        - double radius
        + Circle(String id, double x, double y, double radius)
        + double getRadius()
        + void setRadius(double radius)
        + double calculateArea()
        + double calculatePerimeter()
    }

    class Ellipse {
        - double majorRadius
        - double minorRadius
        + Ellipse(String id, double x, double y, double majorRadius, double minorRadius)
        + double getMajorRadius()
        + double getMinorRadius()
        + void setRadii(double majorRadius, double minorRadius)
        + double calculateArea()
        + double calculatePerimeter()
    }

    Shape <|-- Square
    Shape <|-- Rectangle
    Shape <|-- Triangle
    Shape <|-- Circle
    Shape <|-- Ellipse
