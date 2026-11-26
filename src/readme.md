+---------------------------------------------------------------+
|                    <<abstract>>                               |
|                       Shape                                   |
+---------------------------------------------------------------+
| - id: String                                                  |
| - x: double                                                   |
| - y: double                                                   |
+---------------------------------------------------------------+
| + Shape(id: String, x: double, y: double)                     |
| + getId(): String                                             |
| + setId(id: String): void                                     |
| + getX(): double                                              |
| + setX(x: double): void                                       |
| + getY(): double                                              |
| + setY(y: double): void                                       |
| + {abstract} calculateArea(): double                          |
| + {abstract} calculatePerimeter(): double                     |
+---------------------------------------------------------------+
       ▲               ▲               ▲               ▲               ▲
       │               │               │               │               │
       │ (Herencia)    │               │               │               │
+--------------+ +---------------+ +---------------+ +-------------+ +---------------+
|   Square     | |   Rectangle   | |   Triangle    | |   Circle    | |    Ellipse    |
+--------------+ +---------------+ +---------------+ +-------------+ +---------------+
| - side: double| | - width: double| | - sideA: double| | - radius:   | | - majorRadius:|
|              | | - height:double| | - sideB: double| |   double    | | - minorRadius:|
+--------------+ +---------------+ | - sideC: double| +-------------+ +---------------+
| + Square(...) | | + Rectangle(..)| +---------------+ | + Circle(...) | | + Ellipse(...) |
| + getSide()  | | + getWidth()  | | + Triangle(..)| | + getRadius() | | + getMajorRad()|
| + setSide()  | | + getHeight() | | + getSideA()  | | + setRadius() | | + getMinorRad()|
| + calcArea() | | + setWidth()  | | + getSideB()  | | + calcArea()  | | + setRadii()  |
| + calcPerim()| | + setHeight() | | + getSideC()  | | + calcPerim() | | + calcArea()  |
|              | | + calcArea()  | | + setSides()  | |             | | + calcPerim() |
|              | | + calcPerim() | | + calcArea()  | |             | |               |
|              | |               | | + calcPerim() | |             | |               |
+--------------+ +---------------+ +---------------+ +-------------+ +---------------+
