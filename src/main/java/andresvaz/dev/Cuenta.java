package andresvaz.dev;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

 
    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

 
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

   
    public void calcularInteresMensual() {
        float interesMensual = (saldo * tasaAnual / 100) / 12;
        saldo += interesMensual;
    }

    // Realizar el extracto mensual
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    // Imprimir los detalles de la cuenta
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Número de consignaciones: " + numConsignaciones);
        System.out.println("Número de retiros: " + numRetiros);
        System.out.println("Tasa anual: " + tasaAnual);
        System.out.println("Comisión mensual: " + comisionMensual);
    }
}
