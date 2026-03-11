package cuentaBancoEjercicio;

public class Main {
    public static void main(String[] args) {

        CuentaBancaria miCuenta = new CuentaBancaria();

        System.out.println("Primer Nombre");
        System.out.println(miCuenta.getTitular());

        System.out.println("Cambio de Titular");
        miCuenta.setTitular("Anderson");

        System.out.println();
        System.out.println(miCuenta.getTitular());
    }
}