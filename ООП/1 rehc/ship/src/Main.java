public class Main {
    public static void main(String ags[]) {
        Ship ship=new Ship(8,1,'x',4);
        ship.printCoord();
        ship.printLife();
        System.out.println(ship.shoot(7,1));
        ship.printLife();
        ship.printCoord();
        System.out.println(ship.turn('x',-2));
        ship.printCoord();
        System.out.println(ship.rotate());
        ship.printCoord();
        System.out.println(ship.getX(1)+" "+ship.getY(1)+" "+ship.getAxis());
        System.out.println(ship.getLifeCell(3,1));
        System.out.println(ship.getLife());
        System.out.println(ship.isAlive());
        
        /*
        ship.printLife();
        System.out.println(ship.rotate());
        ship.printCoord();
        System.out.println(ship.getAxis());
        ship.shoot(7,1);
        ship.printLife();*/
    }
}
