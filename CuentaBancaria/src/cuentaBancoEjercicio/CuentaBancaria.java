package cuentaBancoEjercicio;

public class CuentaBancaria {

    private double saldo;
    private String titular;

    public CuentaBancaria() {
        this.saldo = 1;
        this.titular = "Miguel";
    }

    public CuentaBancaria(double saldo, String titular) {
        this.saldo = saldo;
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0){
            this.saldo = saldo;
        }else {
            System.out.println("El valor no puede ser negativo");
        }
    }

    public String getTitular() {

        String[] partes = titular.split(" ");
        String resultado = "";

        for (String nombre : partes) {

            String encriptado = nombre.substring(0, 1);

            for (int i = 1; i < nombre.length(); i++) {
                encriptado += "*";
            }

            resultado += encriptado + " ";
        }

        return resultado.trim();
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Cuenta Bancaria de: " + this.getTitular() + " con un saldo de: " + this.saldo;
    }

}