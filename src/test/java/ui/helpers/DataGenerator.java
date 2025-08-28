package ui.helpers;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataGenerator {

    private static final Random random = new Random();

    // Genera un nombre aleatorio
    public static String randomFirstName() {
        String[] names = {"Andrea", "Felipe", "María", "Juan", "Sofía"};
        return names[random.nextInt(names.length)];
    }

    // Genera un apellido aleatorio
    public static String randomLastName() {
        String[] lastNames = {"Tijerina", "Pérez", "García", "Wong", "Martínez"};
        return lastNames[random.nextInt(lastNames.length)];
    }

    // Genera un email aleatorio
    public static String randomEmail() {
        return "test" + random.nextInt(10000) + "@mail.com";
    }

    // Genera un teléfono aleatorio
    public static String randomPhone() {
        int number = 100000000 + random.nextInt(900000000);
        return "55" + number;
    }

}
