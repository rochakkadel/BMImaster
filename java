import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BMI_Master_RochakKadel
{

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        mainRun();

    }


    //Main Method
    static void mainRun()
    {
        String userInput = "";

        while(true)
        {
            System.out.println("""
                        My BMI Calculator Projects:\s
                         1. BMI, English\s
                         2. BMI, \
                        Metric\s
                        """);
            System.out.println("[ USER MANUAL ] Enter an exclamation mark ! to end. " );
            System.out.print("Please enter the version you want to try: " );
            userInput = input.nextLine().trim();
            System.out.println();

            if (Character.toLowerCase(userInput.charAt(0)) == 'e')
            {
                engVersion();
                break;
            }
            else if (Character.toLowerCase(userInput.charAt(0)) == 'm')
            {
                metVersion();
                break;
            }
            else if (userInput.equals("!"))
            {
                System.out.println("Bye!");
                break;
            }
            else
            {
                System.out.println("Please enter a valid option!");
            }

        }

    }

//------------------------------------------------------------------------------------------

    //Both Version can use

    //get name
    static String getName()
    {
        System.out.print("Please enter your full name: " );
        return input.nextLine();
    }


    //calculate weight status
    static String weightStatus(double bmi)
    {
        return (bmi < 18.5) ? "Underweight" :
                (bmi <= 24.9) ? "Healthy Weight" :
                (bmi <= 29.9) ? "Overweight" : "Obesity";
    }


    //summary report
    static void summaryReport(String name, double bmi, String weightStatus)
    {
        System.out.println();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"));

        System.out.printf("-- SUMMARY REPORT for %s\n", name.toUpperCase());
        System.out.printf("-- Date and Time: %25s \n", time);

        int rounded = (int) Math.round(bmi);
        System.out.printf("-- BMI: %21.2f (or %d if rounded) \n", bmi, rounded);

        System.out.printf("-- %-20s %s \n","Weight Status: ", weightStatus);
        System.out.println();
    }

    //ending message
    static void endingMessage()
    {
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------");
        System.out.println("-- Thank you for using my program");
        System.out.println(
                "-------------------------------------------------------------------------");
        System.out.println();
    }


//------------------------------------------------------------------------------------------


    //English Version MAIN
    static void engVersion()
    {
        engWelcomeMessage();

        String name = getName();

        int[] height = engGetHeight(name);
        int feet = height[0];
        int inches = height[1];

        double currentWeight = engGetCurrentWeight(name);

        double bmi = engBmiCalculation(feet, inches, currentWeight);

        String weightStatus = weightStatus(bmi);

        summaryReport(name, bmi, weightStatus);

        double[] lowHighWeight = engGetLowHighWeight(name);
        double lowWeight = lowHighWeight[0];
        double highWeight = lowHighWeight[1];

        engTableReport(feet, inches, currentWeight, lowWeight, highWeight);

        endingMessage();
    }

    //welcome message English Version
    static void engWelcomeMessage()
    {
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------" );
        System.out.println("-- Wellcome to:" );
        System.out.printf("-- %32s Computation, Rochak Kadel English Version \n", "BODY MASS " +
                "INDEX" +
                "(BMI)" );
        System.out.println(
                "-------------------------------------------------------------------------" );
        System.out.println();
    }


    //get height English Version
    static int[] engGetHeight(String name)
    {
        int[] height = new int[2];

        System.out.printf("Please enter height in feet and inches for %s: ", name);
        height[0] = input.nextInt(); //feet
        height[1] = input.nextInt(); //inches

        return height;
    }


    //get weight English Version
    static double engGetCurrentWeight(String name)
    {
        System.out.printf("Please enter weight in pounds for %s: ", name);
        return input.nextDouble();
    }


    // get high or low weight English Version
    static double[] engGetLowHighWeight(String name)
    {
        double[] weight = new double[2];

        System.out.printf("Please enter LOW weight in pounds for %s: ", name);
        weight[0] = input.nextDouble();

        System.out.printf("Please enter HIGH weight in pounds for %s: ", name);
        weight[1] = input.nextDouble();

        return weight;
    }


    //calculate BMI English Version
    static double engBmiCalculation(int feet, int inches, double weight)
    {
        int totalInches = (feet * 12) + inches;
        return (weight / Math.pow(totalInches, 2)) * 703;
    }


    //form table English Version
    static void engTableReport(int feet, int inches, double currentWeight, double lowWeight,
                             double highWeight)
    {
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-8s | %-35s | \n", "Weight", "BMI", "WEIGHT");
        System.out.println("-------------------------------------------------------------");

        String yellowHighlight = "\u001B[43;30m";
        String reset = "\u001B[0m";

        double bmi = engBmiCalculation(feet, inches, lowWeight);
        String status = weightStatus(bmi);
        System.out.printf("%-10.2f | %-8.3f | %-20s %s(LOW)%s %10s \n", lowWeight, bmi, status,
                yellowHighlight,reset, "|");

        for(double weight = lowWeight + 5.5; weight <= highWeight; weight += 5.50)
        {
            bmi = engBmiCalculation(feet, inches, weight);
            status = weightStatus(bmi);
            System.out.printf("%-10.2f | %-8.3f | %-35s | \n", weight, bmi, status);

            if(weight < currentWeight && weight + 6 > currentWeight)
            {
                bmi = engBmiCalculation(feet, inches, currentWeight);
                String currentWeightStatus = weightStatus(bmi);
                System.out.printf("%-10.2f | %-8.3f | %-35s | \n",
                        currentWeight, bmi, currentWeightStatus + " (this)");
                weight = currentWeight;
            }
        }

        bmi = engBmiCalculation(feet, inches, highWeight);
        status = weightStatus(bmi);
        System.out.printf("%-10.2f | %-8.3f | %-20s %s(HIGH)%s %9s \n",
                highWeight, bmi, status, yellowHighlight, reset, "|");

        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }


//------------------------------------------------------------------------------------------


    //Metric Version MAIN
    static void metVersion()
    {
        metWelcomeMessage();

        String name = getName();

        int height = metGetHeight(name);

        double currentWeight = metGetCurrentWeight(name);

        double bmi = metBmiCalculation(height, currentWeight);

        String weightStatus = weightStatus(bmi);

        summaryReport(name, bmi, weightStatus);

        double[] lowHighWeight = metGetLowHighWeight(name);
        double lowWeight = lowHighWeight[0];
        double highWeight = lowHighWeight[1];

        metTableReport(height, currentWeight, lowWeight, highWeight);

        endingMessage();
    }


    //welcome message Metric Version
    static void metWelcomeMessage() {
        System.out.println();
        System.out.println(
                "-------------------------------------------------------------------------" );
        System.out.println("-- Wellcome to:" );
        System.out.printf("-- %32s Computation, Rochak Kadel, Metric Version   \n", "BODY MASS " +
                "INDEX" +
                "(BMI)" );
        System.out.println(
                "-------------------------------------------------------------------------" );
        System.out.println();
    }


    //get height Metric Version
    static int metGetHeight(String name)
    {
        System.out.printf("Please enter height in centimeters for %s: ", name);
        return input.nextInt();
    }


    //get weight Metric Version
    static double metGetCurrentWeight(String name) {
        System.out.printf("Please enter weight in kilograms for %s: ", name);
        return input.nextDouble();
    }


    // get high or low weight Metric Version
    static double[] metGetLowHighWeight(String name)
    {
        double[] weight = new double[2];

        System.out.printf("Please enter LOW weight in kilograms for %s: ", name);
        weight[0] = input.nextDouble();

        System.out.printf("Please enter HIGH weight in kilograms for %s: ", name);
        weight[1] = input.nextDouble();

        return weight;
    }


    //calculate BMI Metric Version
    static double metBmiCalculation(int height, double weight)
    {
        return weight / Math.pow(height, 2) * 10000;
    }


    //form table Metric Version
    static void metTableReport(int height, double currentWeight, double lowWeight,
                              double highWeight)
    {
        System.out.println();
        System.out.println("-------------------------------------------------------------" );
        System.out.printf("%-10s | %-8s | %-35s | \n", "Weight", "BMI", "WEIGHT" );
        System.out.println("-------------------------------------------------------------" );

        String yellowHighlight = "\u001B[43;30m";
        String reset = "\u001B[0m";

        double bmi = metBmiCalculation(height, lowWeight);
        String status = weightStatus(bmi);
        System.out.printf("%-10.2f | %-8.3f | %-20s %s(LOW)%s %10s \n", lowWeight, bmi, status,
                yellowHighlight, reset, "|" );

        for (double weight = lowWeight + 2.5; weight <= highWeight; weight += 2.50) {
            bmi = metBmiCalculation(height, weight);
            status = weightStatus(bmi);
            System.out.printf("%-10.2f | %-8.3f | %-35s | \n", weight, bmi, status);


            if (weight < currentWeight && weight + 2.5 > currentWeight) {
                bmi = metBmiCalculation(height, currentWeight);
                String currentWeightStatus = weightStatus(bmi);
                System.out.printf("%-10.2f | %-8.3f | %-35s | \n",
                        currentWeight, bmi, currentWeightStatus + " (this)" );
                weight = currentWeight;
            }
        }

        bmi = metBmiCalculation(height, highWeight);
        status = weightStatus(bmi);
        System.out.printf("%-10.2f | %-8.3f | %-20s %s(HIGH)%s %9s \n",
                highWeight, bmi, status, yellowHighlight, reset, "|" );

        System.out.println("-------------------------------------------------------------" );
        System.out.println();
    }


}
