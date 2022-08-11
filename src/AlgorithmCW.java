import java.util.Scanner;
import java.util.Set;

public class AlgorithmCW {
        private static Set<NodeWeighted> nodes;
        private static boolean shouldSkipLoad;
        private final static Scanner inputReader = new Scanner(System.in);


    public static void main(String[] args) throws Exception {
            System.out.println("\nSajeewa's Algorithm Coursework\n");

            while (true) {
                shouldSkipLoad = false;

                System.out.println("Press 1 to find the fastest journey time route between any 2 stations in a specified section of the TfL tube network.");
                System.out.println("Press 0 to Quit the application");

                System.out.print("\nchoice: ");
                String loopChoice = inputReader.nextLine();

                switch (loopChoice) {
                    case "0":
                        System.exit(0);
                        break;
                    case "1":
                        System.out.println("Enter your station :");
                        String stationA = inputReader.nextLine();
                        System.out.println("Enter the station you want to go :");
                        String stationB = inputReader.nextLine();
                        Dataset.x(stationA.toUpperCase().replace(" ","_"), stationB.toUpperCase().replace(" ","_"));
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }


        }

    }