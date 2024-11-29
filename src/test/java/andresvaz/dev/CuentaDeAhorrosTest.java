package andresvaz.dev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaDeAhorrosTest {
    private CuentaDeAhorros cuentaAhorros;

    @Before
    public void setUp() {
        cuentaAhorros = new CuentaDeAhorros(15000f, 5f); // saldo inicial de 15000 y tasa anual de 5%
    }

    @Test
    public void testConsignar() {
        cuentaAhorros.consignar(5000f);
        assertEquals(20000f, cuentaAhorros.saldo, 0.01); // El saldo debe ser 20000
        assertEquals(1, cuentaAhorros.numConsignaciones); // Debe haber 1 consignación
    }

    @Test
    public void testRetirar() {
        cuentaAhorros.retirar(5000f);
        assertEquals(10000f, cuentaAhorros.saldo, 0.01); // El saldo debe ser 10000
        assertEquals(1, cuentaAhorros.numRetiros); // Debe haber 1 retiro
    }

    @Test
    public void testConsignarCuentaInactiva() {
        cuentaAhorros = new CuentaDeAhorros(5000f, 5f); // saldo menor a 10000, la cuenta se vuelve inactiva
        cuentaAhorros.consignar(2000f);
        assertEquals(5000f, cuentaAhorros.saldo, 0.01); // El saldo no debe cambiar, ya que la cuenta está inactiva
    }

    @Test
    public void testRetirarCuentaInactiva() {
        cuentaAhorros = new CuentaDeAhorros(5000f, 5f); // saldo menor a 10000, la cuenta se vuelve inactiva
        cuentaAhorros.retirar(1000f);
        assertEquals(5000f, cuentaAhorros.saldo, 0.01); // El saldo no debe cambiar, ya que la cuenta está inactiva
    }

    @Test
    public void testExtractoMensualConComision() {
        cuentaAhorros.numRetiros = 5;
        cuentaAhorros.extractoMensual();
        assertEquals(15000f - 1000f, cuentaAhorros.saldo, 0.01); // El saldo debe reflejar la comisión por retiros adicionales
    }
}
