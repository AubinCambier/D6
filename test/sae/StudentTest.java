package sae;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    Student student1, student2, student3, student4, student5;

    @BeforeEach
    public void initialisation() {

        student1 = new Student("Matthieu", "A", "02-05-2006", "France", "M", "M", "no", "no", "no", "no", "lalala");
        student2 = new Student("Mathéo", "Lelong", "01-01-2007", "France", "M", "F", "no", "no", "no", "no",
                "histoire");
        student3 = new Student("Lucie", "Martin", "15-08-2005", "France", "F", "M", "yes", "no", "végétarien", "aucune",
                "danse");
        student4 = new Student("Carlos", "Gomez", "23-03-2006", "Espagne", "M", "F", "no", "yes", "aucune", "halal",
                "musique");
        student5 = new Student("Aya", "Tanaka", "12-12-2007", "Japon", "F", "M", "yes", "yes", "sans gluten",
                "végétarien", "dessin");
    }

    @Test
    public void calculAffiniteTest() {

        // modifier les valeurs en fonction des varables

        assertEquals(0, student1.calculAffinite(student2));
        assertEquals(0, student1.calculAffinite(student3));
        assertEquals(0, student1.calculAffinite(student4));
        assertEquals(0, student3.calculAffinite(student2));
        assertEquals(0, student4.calculAffinite(student2));
        assertEquals(0, student5.calculAffinite(student2));
    }
}
