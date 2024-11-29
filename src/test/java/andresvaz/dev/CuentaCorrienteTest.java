package andresvaz.dev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CuentaCorrienteTest {
    private CuentaCorriente cuentaCorriente;

    @Before
    public void setUp() {
        // Crear una cuenta corriente con saldo inicial de 5000 y tasa anual de 5%
        cuentaCorriente = new CuentaCorriente(5000f, 5f);
    }

    @Test
    public void testRetirar() {
        // Realizar un retiro que cause un sobregiro
        cuentaCorriente.retirar(6000f); 
        // Verificar que el saldo es 0
        assertEquals(0f, cuentaCorriente.saldo, 0.01); 
        // Verificar que el sobregiro es 1000
        assertEquals(1000f, cuentaCorriente.getSobregiro(), 0.01); 
    }

    @Test
    public void testConsignarConSobregiro() {
        // Realizar un retiro para generar sobregiro de 6000
        cuentaCorriente.retirar(6000f);
        // Consignar 3000 para reducir el sobregiro
        cuentaCorriente.consignar(3000f); 
        // Verificar que el saldo ahora es 3000
        assertEquals(3000f, cuentaCorriente.saldo, 0.01); 
        // Verificar que el sobregiro ha sido reducido a 3000
        assertEquals(3000f, cuentaCorriente.getSobregiro(), 0.01); 
    }

    @Test
    public void testConsignarSinSobregiro() {
        // Consignar 2000 sin sobregiro previo
        cuentaCorriente.consignar(2000f);
        // Verificar que el saldo es ahora 7000
        assertEquals(7000f, cuentaCorriente.saldo, 0.01); 
        // Verificar que el sobregiro sigue siendo 0
        assertEquals(0f, cuentaCorriente.getSobregiro(), 0.01); 
    }

    @Test
    public void testExtractoMensual() {
        // Realizar el extracto mensual
        cuentaCorriente.extractoMensual();
        // Calcular el interés mensual (5% anual, dividido entre 12 meses)
        float interesMensual = 5000f * 5f / 100 / 12;
        // Verificar que el saldo refleja el interés mensual
        assertEquals(5000f + interesMensual, cuentaCorriente.saldo, 0.01); 
    }

    @Test
    public void testImprimir() {
        // Realizar un retiro y luego una consignación
        cuentaCorriente.retirar(6000f); 
        cuentaCorriente.consignar(3000f); 
        // Verificar que los valores de saldo, sobregiro, transacciones sean correctos al imprimir
        cuentaCorriente.imprimir(); // Esto imprimirá el estado de la cuenta
    }
}
