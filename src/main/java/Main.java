import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many rooms are you painting today?");
        int numRooms = Integer.parseInt(scanner.next());

        double totalPaintNeeded = 0;

        System.out.println("Lets measure each room now...");

        for (int i = 1; i <= numRooms; i++) {
            System.out.println("Room " + i + ":");
            System.out.println("How many coats of paint does this room need?");
            int paintCoats = Integer.parseInt(scanner.next());
            System.out.println("How many walls are in this room?");
            int numWalls = Integer.parseInt(scanner.next());
            double roomArea = 0;
            double ceiling = 0;
            double ceilingWidth = 0;
            double ceilingHeight = 0;
            double window = 0;
            double windowWidth = 0;
            double windowHeight = 0;
            double door = 0;
            double doorWidth = 0;
            double doorHeight = 0;

            for (int j = 1; j <= numWalls; j++) {
                double wallWidth = 0;
                double wallHeight = 0;

                System.out.println("Please enter the width of wall " + j + " in millimetres: ");
                wallWidth = Double.parseDouble(scanner.next()) / 1000.0; //converting mm to metres
                System.out.println("Please enter the height of wall " + j + " in millimetres: ");
                wallHeight = Double.parseDouble(scanner.next()) / 1000.0;

                double wallArea = wallWidth * wallHeight;
                roomArea += wallArea * paintCoats;
            }

            System.out.println("Are you also painting the ceiling of this room? Type 1 for yes or 2 for no: ");
            int ceilingAnswer = Integer.parseInt(scanner.next());
            if (ceilingAnswer == 1) {
                System.out.println("Please enter the width of the ceiling in millimetres: ");
                ceilingWidth = Double.parseDouble(scanner.next()) / 1000.0;
                System.out.println("Please enter the height of the ceiling in millimetres: ");
                ceilingHeight = Double.parseDouble(scanner.next()) / 1000.0;
                ceiling = ceilingHeight * ceilingWidth;
                roomArea += ceiling;
            }

            System.out.println("Are there any windows in this room? Type 1 for yes or 2 for no: ");
            int windowAnswer = Integer.parseInt(scanner.next());
            if (windowAnswer == 1) {
                System.out.println("How many windows are in the room?");
                int windowNum = Integer.parseInt(scanner.next());
                for (int w = 1; w <= windowNum; w++) {
                    System.out.println("Please enter the width of window " + w + " in millimetres: ");
                    windowWidth = Double.parseDouble(scanner.next()) / 1000.0;
                    System.out.println("Please enter the height of window " + w + " in millimetres: ");
                    windowHeight = Double.parseDouble(scanner.next()) / 1000.0;
                    window = windowWidth * windowHeight;
                    roomArea -= window;
                }
            }

            System.out.println("Are there any doors in this room? Type 1 for yes or 2 for no: ");
            int doorAnswer = Integer.parseInt(scanner.next());
            if (doorAnswer == 1) {
                System.out.println("How many doors are in the room?");
                int doorNum = Integer.parseInt(scanner.next());
                for (int d = 1; d <= doorNum; d++) {
                    System.out.println("Please enter the width of door " + d + " in millimetres: ");
                    doorWidth = Double.parseDouble(scanner.next()) / 1000.0;
                    System.out.println("Please enter the height of door " + d + " in millimetres: ");
                    doorHeight = Double.parseDouble(scanner.next()) / 1000.0;
                    door = doorWidth * doorHeight;
                    roomArea -= door;
                }
            }

            //calc paint needed
            double paintNeededRoom = roomArea/13; //because a litre covers 13 sq metres
            totalPaintNeeded += Math.ceil(paintNeededRoom);

            System.out.println("You would need " + Math.ceil(paintNeededRoom) + " litres of paint for room " + i + ".");

        }

        System.out.println("You would need " + Math.ceil(totalPaintNeeded) + " litres of paint in total for all rooms.");

        //only cost of white matt paint
        int paint10L = 27;
        int paint5L = 18;
        int paint2p5L = 16;

        double remainingPaint = totalPaintNeeded;
        int tin10L = (int) (remainingPaint / 10); //(int) for type casting double to int
        remainingPaint -= tin10L * 10;
        int tin5L = (int) (remainingPaint / 5);
        remainingPaint -= tin5L * 5;
        int tin2p5L = (int) Math.ceil(remainingPaint / 2.5); //rounds up so if there's any remaining paint -> another tin

        System.out.println("For the total volume of paint needed, here is what we recommend you buy and the cost:");
        System.out.println("Buy " + tin10L + " 10L tins");
        System.out.println("Buy " + tin5L + " 5L tins");
        System.out.println("Buy " + tin2p5L + " 2.5L tins");

        //calc total cost
        double cost = (tin10L * paint10L) + (tin5L * paint5L) + (tin2p5L * paint2p5L);
        System.out.println("Total cost of paint: £" + cost);


        scanner.close();

    }
}