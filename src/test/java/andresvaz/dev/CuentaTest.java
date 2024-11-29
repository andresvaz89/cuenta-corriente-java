package andresvaz.dev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaTest {
    private Cuenta cuenta;

    @Before
    public void setUp() {
        cuenta = new Cuenta(10000f, 5f); // saldo inicial de 10000 y tasa anual de 5%
    }

    @Test
    public void testConsignar() {
        cuenta.consignar(5000f);
        assertEquals(15000f, cuenta.saldo, 0.01); // El saldo debe ser 15000
        assertEquals(1, cuenta.numConsignaciones); // Debe haber 1 consignación
    }

    @Test
    public void testRetirar() {
        cuenta.retirar(3000f);
        assertEquals(7000f, cuenta.saldo, 0.01); // El saldo debe ser 7000 después de retirar
        assertEquals(1, cuenta.numRetiros); // Debe haber 1 retiro
    }

    @Test
    public void testRetirarSaldoInsuficiente() {
        cuenta.retirar(11000f);
        assertEquals(10000f, cuenta.saldo, 0.01); // El saldo no cambia
    }

    @Test
    public void testCalcularInteresMensual() {
        cuenta.calcularInteresMensual();
        assertEquals(10000f * 5f / 100 / 12, cuenta.saldo - 10000f, 0.01); // El interés mensual debe ser calculado correctamente
    }

    @Test
    public void testExtractoMensual() {
        cuenta.comisionMensual = 500f;
        cuenta.extractoMensual();
        assertEquals(10000f * 5f / 100 / 12 - 500f, cuenta.saldo - 10000f, 0.01); // El saldo debe reflejar la comisión y el interés
    }
}
