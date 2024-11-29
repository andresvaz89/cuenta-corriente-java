package andresvaz.dev;

public class Main {
    public static void main(String[] args) {
  
        CuentaDeAhorros cuentaAhorros = new CuentaDeAhorros(15000, 5);
        cuentaAhorros.consignar(5000);
        cuentaAhorros.retirar(2000);
        cuentaAhorros.extractoMensual();
        cuentaAhorros.imprimir();

    
        CuentaCorriente cuentaCorriente = new CuentaCorriente(2000, 5);
        cuentaCorriente.consignar(1000);
        cuentaCorriente.retirar(2500);
        cuentaCorriente.extractoMensual();
        cuentaCorriente.imprimir();
    }
}
