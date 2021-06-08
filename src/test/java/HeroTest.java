//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class HeroTest {
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//
//    @Test
//    void initiatesWithHeroName() throws Exception{
//        Hero testHero = new Hero("flash",22,"speed","people");
//        assertEquals(true, testHero instanceof Hero);
//    }
//
//    @Test
//    void getHeroName_personStartsWith_Hero() {
//        Hero testHero = new Hero ("flash",22,"speed","people");
//        assertEquals("flash", testHero.getHero_name());
//    }
//
//    @Test
//    void newHero_getName_String() {
//        Hero hero = Hero.setUPNewHero();
//        assertEquals ("flash", hero.getHero_name());
//    }
//    @Test
//    public void newHero_getAge_Int() {
//        Hero newHero = Hero.setUPNewHero();
//        assertEquals(22,newHero.getAge());
//    }
//}