package andresvaz.dev;

public class CuentaCorriente extends Cuenta {
    // Hacemos el campo 'sobregiro' privado para protegerlo
    private float sobregiro;

    // Constructor para inicializar la cuenta corriente
    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);  // Llamada al constructor de la clase base
        this.sobregiro = 0;  // Inicializamos el sobregiro a 0
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            super.retirar(cantidad);  // Llamada al método de la clase base
        } else {
            // Si el saldo es insuficiente, calculamos el sobregiro
            sobregiro += cantidad - saldo;
            saldo = 0;  // El saldo se pone a 0
            numRetiros++;  // Aumentamos el número de retiros
        }
    }

    @Override
    public void consignar(float cantidad) {
        super.consignar(cantidad);  // Llamada al método de la clase base
        if (sobregiro > 0) {
            // Si existe sobregiro, primero intentamos pagarlo con la consignación
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;  // Si la consignación cubre todo el sobregiro, lo reseteamos a 0
            } else {
                sobregiro -= cantidad;  // Si no cubre todo, reducimos el sobregiro
            }
        }
    }

    @Override
    public void extractoMensual() {
        super.extractoMensual();  // Llamada al método de la clase base (agregar lógica si es necesario)
    }

    // Método para imprimir la información de la cuenta corriente
    @Override
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comisionMensual);
        System.out.println("Número de transacciones: " + (numConsignaciones + numRetiros));
        System.out.println("Sobregiro: " + getSobregiro());  // Usamos el getter para acceder al sobregiro
    }

    // Getter para el campo sobregiro
    public float getSobregiro() {
        return sobregiro;
    }
}
