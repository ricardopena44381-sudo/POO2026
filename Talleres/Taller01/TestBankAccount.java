public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount cuenta = new BankAccount("123456789", "Ricardo", 100000.0);
        System.out.println("Titular: " + cuenta.getAccountHolder() + " | Saldo: $" + cuenta.getBalance());

        boolean dep1 = cuenta.deposit(50000.0);
        System.out.println("Deposito 50000. Exitoso: " + dep1 + " -> Saldo: $" + cuenta.getBalance());

        boolean depInvalido = cuenta.deposit(-10000.0);
        System.out.println("Deposito -10000. Exitoso: " + depInvalido + " -> Saldo: $" + cuenta.getBalance());

        boolean retiro1 = cuenta.withdraw(20000.0);
        System.out.println("Retiro 20000. Exitoso: " + retiro1 + " -> Saldo: $" + cuenta.getBalance());

        boolean retiroSinFondo = cuenta.withdraw(200000.0);
        System.out.println("Retiro 200000 (Sin fondos). Exitoso: " + retiroSinFondo + " -> Saldo: $" + cuenta.getBalance());
    }
}