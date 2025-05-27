public sealed class Shape permits Circle, Square, Rectangle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rect = new Rectangle();

        circle.print();
        square.print();
        rect.print();
    }
}