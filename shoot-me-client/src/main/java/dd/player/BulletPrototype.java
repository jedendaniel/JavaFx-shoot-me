package dd.player;

public enum BulletPrototype {
    TEST(5,5);

    int x;
    int y;

    BulletPrototype(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
