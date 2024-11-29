package andresvaz.dev;

public class CuentaDeAhorros extends Cuenta {
    private boolean cuentaActiva;

    public CuentaDeAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.cuentaActiva = saldo >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta no está activa, no se puede consignar.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta no está activa, no se puede retirar.");
        }
    }

    @Override
    public void extractoMensual() {
        if (numRetiros > 4) {
            comisionMensual = (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        cuentaActiva = saldo >= 10000;
    }

    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (numConsignaciones + numRetiros));
    }
}
