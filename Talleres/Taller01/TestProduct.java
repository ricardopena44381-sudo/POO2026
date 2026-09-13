public class TestProduct {
    public static void main(String[] args) {
        Product producto = new Product("Portatil", 1500000.0, 10);
        System.out.println("Producto: " + producto.getName() + " | Precio: $" + producto.getPrice() + " | Stock: " + producto.getStock());

        boolean precioValido = producto.updatePrice(1400000.0);
        System.out.println("Actualizar precio a 1400000. Aceptado: " + precioValido);

        boolean precioInvalido = producto.updatePrice(-500.0);
        System.out.println("Actualizar precio a negativo. Aceptado: " + precioInvalido);

        boolean stockValido = producto.updateStock(5);
        System.out.println("Actualizar stock a 5. Aceptado: " + stockValido);

        boolean stockInvalido = producto.updateStock(-2);
        System.out.println("Actualizar stock a -2. Aceptado: " + stockInvalido);

        System.out.println("Estado final -> Precio: $" + producto.getPrice() + " | Stock: " + producto.getStock());
    }
}