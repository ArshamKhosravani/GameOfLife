package character;

import map.Map;
import map.Tile;

public abstract class Character {

    int health;
    int attackDamage;
    int maxHealth;
    Tile position;
    Map map;

    public Tile getPosition() {
        return position;
    }

    public Character(Map map) {
        this.map = map;
        health = 5;
    }

    public void jump(int direction) {
        if (Math.abs(direction) > 1) {
            throw new ArithmeticException();
        }
        Tile target = map.getNextTile(position, direction * 2);
        if (!target.occupied) {
            position.occupied = false;
            position = target;
        }
    }

    public void move(int direction) {
        if (Math.abs(direction) > 1) {
            throw new ArithmeticException();
        }
        Tile target = map.getNextTile(position, direction);
        if (!target.occupied) {
            position.occupied = false;
            position = target;
        }
    }

    public void attack(int i) {

    }

    public abstract String getStat();
}
