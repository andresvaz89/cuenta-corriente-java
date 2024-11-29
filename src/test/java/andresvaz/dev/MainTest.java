package andresvaz.dev;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        // Redirigir la salida estándar a nuestro ByteArrayOutputStream
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testMain() {
        // Ejecutar el main
        Main.main(null);

        // Verificar la salida de la cuenta de ahorros
        String expectedOutputAhorros = "Saldo: 18000.0\nComisión mensual: 0.0\nNúmero de transacciones: 2\nSobregiro: 0.0\n";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutputAhorros));

        // Verificar la salida de la cuenta corriente
        String expectedOutputCorriente = "Saldo: 500.0\nComisión mensual: 0.0\nNúmero de transacciones: 2\nSobregiro: 2000.0\n";
        assertTrue(outputStreamCaptor.toString().contains(expectedOutputCorriente));
    }
}
