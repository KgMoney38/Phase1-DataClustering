//Kody Graham
//01/18/2026
//Phase 1
//For: Dr. Emre Celebi's Data Clustering Online Class - 4372

//Coding practices resource I have decided to primarily use: https://www.cs.cornell.edu/courses/JavaAndDS/JavaStyle.html

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class UniformRandomSelection {
    public static void main(String[] args) {

        Parameters parameters = parseUserArguments(args);
        Dataset dataset = readFromDataset(parameters.filename);



    }

    //This method reads data from the file specified by the first argument when running from the command line
    private static Dataset readFromDataset(String filename) {

        Scanner scanner = null;
        try {
            System.err.println("Madeit");
            scanner= new Scanner(new File(filename));

        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not read file.");
                    System.exit(1);
            throw new RuntimeException(e);
        }
        return null;
    }

    private static Parameters parseUserArguments(String[] args) {
        //Must take 5 parameters
        if(args.length != 5)
        {
            System.err.println("Incorrect Number of Arguments: Must have exactly 5 arguments");
            System.exit(1);
        }
        int numClusters = 0;
        int maxIteration = 0;
        float convergenceThreshold= 0.00F;
        int numRuns = 0;
        String filename= args[0];

        try{
            numClusters= Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("The format for number of clusters must be an integer.");
            System.exit(1);
        }

        try{
            maxIteration= Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("The format for the maximum number of iterations must be an integer.");
            System.exit(1);
        }

        try{
            convergenceThreshold = Float.parseFloat(args[3]);
        }catch (NumberFormatException e) {
            System.err.println("The format for the conversion threshold must be in float format.");
            System.exit(1);
        }

        try{
            numRuns= Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
            System.err.println("The format for number of runs must be an integer.");
            System.exit(1);
        }

        //Final parameter check to meet criteria
        if(numClusters <= 1){
            System.err.println("The number of clusters must be a positive integer greater than 1.");
            System.exit(1);
        }
        if(maxIteration<1){
            System.err.println("The maximum number of iterations must be a positive integer.");
            System.exit(1);
        }
        if(convergenceThreshold<=0){
            System.err.println("The convergence threshold must be a non negative real number.");
            System.exit(1);
        }
        if(numRuns<1){
            System.err.println("The minimum number of runs is 1.");
            System.exit(1);
        }

        //Only if we pass all the checks, return our parameters
        return new Parameters(filename,numClusters,maxIteration,convergenceThreshold,numRuns);
    }

    //Class to handle and protect my different arguments
    private static final class Parameters {
        //Indicated desired inputs for reference:
        //% F = iris_bezdek.txt (name of data file)
        final String filename;
        //% K = 3 (number of clusters)
        final int numOfClusters;
        //% I = 100 (maximum number of iterations in a run)
        final int maxNumOfIterations;
        //% T = 0.000001 (convergence threshold)
        final float convergenceThreshold;
        //% R = 100 (number of runs)
        final int numOfRuns;

        //Constructor params for Parameters class
        private Parameters(String filename, int numOfClusters, int maxNumOfIterations, float convergenceThreshold, int numOfRuns) {
            this.filename = filename;
            this.numOfClusters = numOfClusters;
            this.maxNumOfIterations = maxNumOfIterations;
            this.convergenceThreshold = convergenceThreshold;
            this.numOfRuns = numOfRuns;
        }
    }

    //Class will hold the number of points, dimensions, and the actual data values.
    private static final class Dataset{
        final int numberOfPoints;
        final int numOfDimensions;
        final float[][] data;

        //Constructor parameters for Dataset class
        private Dataset(int numPoints, int numDimensions, float[][] data) {
            this.numberOfPoints = numPoints;
            this.numOfDimensions = numDimensions;
            this.data = data;
        }


        //% test is the name of the executable file
            //% “>” indicates command-prompt, which is not part of the output


        }



        //Valid command prompt
        //test iris_bezdek.txt 3 100 0.000001 100

        //Example output format:
        //5.1 3.4 1.5 0.2
        //7.2 3.2 6 1.8
        //4.6 3.1 1.5 0.2

        //Four dimensions so 4 items in each row, 3 lines because k = 3

}



//Java Practices and Style Guide from my Google search: This one seems to cover a little more https://google.github.io/styleguide/javaguide.html
//However, I like the layout of the sections better on this one, so I will reference both (they should contain basically the same information as these practice are kind of industry standard I think)
//but I will primarily use https://www.cs.cornell.edu/courses/JavaAndDS/JavaStyle.html