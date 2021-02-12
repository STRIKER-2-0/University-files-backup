package ind2;

public class Main {
    public static void main(String ags[]) {
        Ship ship=new Ship(7,8,'x',4);
        ship.printCoord();
        System.out.println(ship.turn('x', 2));
        ship.printCoord();
    }
}
 