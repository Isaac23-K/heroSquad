import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void initiatesWithHeroName() throws Exception{
        Hero testHero = new Hero("flash",22,"speed","people");
        Hero testHero2 = new Hero("flash", 22, "speed", "people");
        assertTrue(testHero.equals(testHero2));
    }

    @Test
    void getHeroName_personStartsWith_Hero() {
        Hero testHero = new Hero ("flash",22,"speed","people");
        assertEquals("flash", testHero.getHero_name());
    }
}