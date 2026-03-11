package cuentaBancoEjercicio;

public class Main {
    public static void main(String[] args) {

        CuentaBancaria cuenta1 = new CuentaBancaria();

        System.out.println("Primer Nombre");
        System.out.println(cuenta1.getTitular());

        System.out.println("Cambio de Titular");
        cuenta1.setTitular("Anderson");

        System.out.println("imprimir nuevo titular");
        System.out.println(cuenta1.getTitular());
    }
}