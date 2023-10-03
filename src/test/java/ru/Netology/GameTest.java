package ru.Netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testFirstPlayerWin() {
        Player kolya = new Player(1, "Kolya", 150);
        Player sasha = new Player(2, "Sasha", 130);
        Game game = new Game();
        game.register(kolya);
        game.register(sasha);
        int actual = game.round("Kolya", "Sasha");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testSecondPlayerWin() {
        Player kolya = new Player(1, "Kolya", 150);
        Player sasha = new Player(2, "Sasha", 160);
        Game game = new Game();
        game.register(kolya);
        game.register(sasha);
        int actual = game.round("Kolya", "Sasha");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testPowerPlayerEqual() {
        Player kolya = new Player(1, "Kolya", 150);
        Player sasha = new Player(2, "Sasha", 150);
        Game game = new Game();
        game.register(kolya);
        game.register(sasha);
        int actual = game.round("Kolya", "Sasha");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlaerNotExist() {
        Player kolya = new Player(1, "Kolya", 150);
        Player sasha = new Player(2, "Sasha", 150);
        Game game = new Game();
        game.register(kolya);
        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Pasha", "Sasha"));
    }
    @Test
    public void testWhenSecondPlaerNotExist() {
        Player kolya = new Player(1, "Kolya", 150);
        Player sasha = new Player(2, "Sasha", 150);
        Game game = new Game();
        game.register(kolya);
        game.register(sasha);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Kolya", "Pasha"));
    }

}
