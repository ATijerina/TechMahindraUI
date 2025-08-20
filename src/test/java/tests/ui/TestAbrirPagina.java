package tests.ui;

import org.testng.annotations.Test;
import tests.base.BaseUITest;

public class TestAbrirPagina extends BaseUITest {

    @Test
    public void abrirPaginaPrincipal() throws InterruptedException {
        driver.get("https://automationintesting.online/");
        System.out.println("Título: " + driver.getTitle());

        // Esperar 5 segundos para ver la página
        Thread.sleep(5000);


        // Mostrar título en la consola para ver que se abrió
        System.out.println("Página abierta: " + driver.getTitle());
    }
}

