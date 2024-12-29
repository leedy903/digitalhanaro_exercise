interface Movable {
    void moveUp();

    void moveDown();

    void moveLeft();

    void moveRight();
}

class MovablePoint implements Movable {
    int x, y;
    int xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        this.y -= ySpeed;
    }

    @Override
    public void moveDown() {
        this.y += ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x -= xSpeed;
    }

    @Override
    public void moveRight() {
        this.x += xSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint[" +
                "x=" + x +
                ", y=" + y +
                ", xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                "]";
    }
}

class MovableCircle implements Movable {
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public String toString() {
        return "MovableCircle[" +
                "center=" + center.toString() +
                ", radius=" + radius +
                "]";
    }
}

public class MoveEx {
    public static void main(String[] args) {
        MovablePoint mp = new MovablePoint(5, 6, 10, 15);
        System.out.println("포인트 이동 전");
        System.out.println(mp);

        System.out.println("포인트 아래로 이동");
        mp.moveDown();
        System.out.println(mp);

        System.out.println("포인트 위로 이동");
        mp.moveUp();
        System.out.println(mp);

        System.out.println("포인트 왼쪽으로 이동");
        mp.moveLeft();
        System.out.println(mp);


        System.out.println("포인트 오른쪽으로 이동");
        mp.moveRight();
        System.out.println(mp);

        MovableCircle mc = new MovableCircle(1, 2, 3, 4, 20);
        System.out.println("원 이동 전");
        System.out.println(mc);

        System.out.println("원 아래로 이동");
        mc.moveDown();
        System.out.println(mc);

        System.out.println("원 위로 이동");
        mc.moveUp();
        System.out.println(mc);

        System.out.println("원 왼쪽으로 이동");
        mc.moveLeft();
        System.out.println(mc);

        System.out.println("원 오른쪽으로 이동");
        mc.moveRight();
        System.out.println(mc);
    }
}
