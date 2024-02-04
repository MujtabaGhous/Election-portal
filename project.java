import java.util.*;
import java.io.*;

public class project {


    static Scanner console = new Scanner(System.in);
    static String[][] votersData = {
            {"3364663946884", "Babar","Azam", "18"},
            {"7845630286648", "Virat","Kholi", "20"},
            {"1357908642148", "Leo","Messi", "21"},
            {"7743630288648", "Ronaldo","CR7", "20"}
            // Add more voters as needed
    };
    static String[][] adminData = {
            {"3520284603151", "Asghar","Raza", "pakistan"},
            {"2130315714193", "Hassan","Raza", "hassan999"},
            {"3420351057259", "Ghulam","Mujtaba", "mujtaba397"},
            {"1730127003003", "Sheriyar","Khalil", "sheri123"},
            {"1560404169467", "Naeem","ud-din", "naeem246"}
            // Add more admins as needed
    };
    static String[][] candidateData = {
            {"3440293280786", "Malaika","Tariq", "Panda","26","FEMALE"},
            {"4240173367213", "Syed","Hamza", "Foot Ball","30","MALE"},
            {"3130339635864", "Momina","Javed", "Eagle","28","FEMALE"},
            {"8220338983880", "Erha","Rafiq","Witch","27","MALE"}
            // Add more candidiates as needed
    };
    static String[][] votingList = {
            {"3440293280786", "Malaika","Traiq","0"},
            {"4240173367213", "Syed","Hamza","0"},
            {"3130339635864", "Momina","Javed","0"},
            {"8220338983880","Erha"," Rafiq","0"}
    };

    public static void main(String[] args) {
        mainScreen();
    }
    public static void mainScreen(){
        System.out.println("       WELCOME TO ELECTION PORTAL       ");
        System.out.println("----------------------------------------");
        System.out.println("    PRESS THE FOLLWING OPTIONS          ");
        System.out.println(" 1: TO SIGN UP AS AN ADMIN              ");
        System.out.println(" 2: TO LOGIN UP AS AN ADMIN             ");
        int value = getInt(1, 2);
        switch (value) {
            case 1:
                addNewadmin();
                printadminData(adminData);
                mainScreen();
                break;
            case 2:
                adminlogin();
                break;

            default:
                break;
        }
    }

    private static void adminlogin() {
        String Q = getCNIC();
        boolean xa ;
        if(booleanSearch(adminData, Q , 0)){
            xa=true;
        }else{
            xa=false;
        }
        if(xa==true)
        {
            int ix =linearSearch(adminData, Q, 0);
            System.out.print("Enter your Password :");
            String p = console.nextLine();
            if(p.equals(adminData[ix][3])){
                System.out.println("Welcome "+adminData[ix][1]+" "+adminData[ix][2]);
                adminscreen();
            }else{
                System.out.println("Password is incorrect");
                System.out.println(" PRESS ");
                System.out.println(" 1:To try again");
                System.out.println(" 2:To go back  ");
                int q2 = getInt(1, 2);
                switch (q2) {
                    case 1:
                        adminlogin();
                        break;
                    case 2:
                        mainScreen();
                        break;

                    default:
                        break;
                }
            }

        }else{
            System.out.println("This CNIC is not registered");
            System.out.println(" PRESS ");
            System.out.println(" 1:To try again");
            System.out.println(" 2:To go back  ");
            int q1 = getInt(1, 2);
            switch (q1) {
                case 1:
                    adminlogin();
                    break;
                case 2:
                    mainScreen();
                    break;

                default:
                    break;
            }
        }
    }

    public static void adminscreen(){
        System.out.println("PRESS");
        System.out.println(" 1 : Register candidate");
        System.out.println(" 2 : Remove candidate");
        System.out.println(" 3 : All candidates list");
        System.out.println(" 4 : Search candidate");
        System.out.println(" 5 : Register voter");
        System.out.println(" 6 : Remove voter");
        System.out.println(" 7 : All voters list");
        System.out.println(" 8 : Search voter ");
        System.out.println(" 9 : Voter list ");
        System.out.println(" 10: Start voting");
        System.out.println(" 11: view Result and show previous ones ");
        System.out.println(" 0 : LOG OUT TO MAIN SCREEN");
        int q1 = getInt(0, 11);
        switch (q1) {
            case 1:
                addNewcandidate();
                backBuffer();
                break;
            case 2:
                backBuffer();
                break;
            case 3:
                printcandidateData(candidateData);
                backBuffer();
                break;
            case 4:
                String x = getCNIC();
                int ix = linearSearch(candidateData, x, 0);
                if(ix==-1){
                    System.out.println("Enter a valid CNIC");
                    backBuffer();
                }
                int j=0;
                String id =   candidateData[ix][j];
                j++;
                String nameFirst =   candidateData[ix][j];
                j++;
                String nameSecond =   candidateData[ix][j];
                j++;
                String logo =   candidateData[ix][j];
                j++;
                String age =   candidateData[ix][j];
                j++;
                String gender =   candidateData[ix][j];
                System.out.println("ID: " + id + ", Name: " + nameFirst+" "+nameSecond+", logo: "+ logo +", age: "+ age +", gender: "+ gender);
                backBuffer();
                break;
            case 5:
                addNewvoters();
                backBuffer();
                break;
            case 6:
                backBuffer();
                break;
            case 7:
                printvotersData(votersData);
                backBuffer();
                break;
            case 8:
                String x1 = getCNIC();
                int ix1 = linearSearch(votersData, x1, 0);
                if(ix1==-1){
                    System.out.println("Enter a valid CNIC");
                    backBuffer();
                }
                int j1=0;
                String id1 =   votersData[ix1][j1];
                j1++;
                String nameFirst1 =   votersData[ix1][j1];
                j1++;
                String nameSecond1 =   votersData[ix1][j1];
                j1++;
                String logo1 =   votersData[ix1][j1];
                j1++;
                String age1 =   votersData[ix1][j1];
                j1++;
                String gender1 =   votersData[ix1][j1];
                System.out.println("ID: " + id1 + ", Name: " + nameFirst1+" "+nameSecond1+", logo: "+ logo1 +", age: "+ age1 +", gender: "+ gender1);
                backBuffer();
                break;
            case 9:
                printVotinglist(votingList);
                backBuffer();
                break;
            case 10:

                String vc = "stop";
                String ic ;

                do {
                    castVote();
                    console.nextLine();  // Consume newline after casting the vote
                    System.out.println("Enter 'stop' to finish voting or press Enter to continue:");
                    ic = console.nextLine();
                } while (!ic.equals(vc));
                break;

            case 11:

                declareWinner(); // provides a String and an int

                displayPreviousResults();


                break;
            case 0:
                mainScreen();
                break;

            default:
                break;
        }
        backBuffer();
    }
    private static void backBuffer() {
        System.out.println(" PRESS ");
        System.out.println(" 1:To go back to admin screen ");

        int q2 = getInt(1, 1);
        switch (q2) {
            case 1:

                adminscreen();
                break;
        }
    }

    private static String[][] addNewvoters() {
        try {
            System.out.println("Adding a new voters:");
            System.out.print("Enter CNIC: ");
            String newId = console.nextLine() ;
            while (newId.length()!= 13) {
                System.out.print("Enter a 13 digit CNIC:");
                newId= console.nextLine();
            }
            System.out.print("Enter First Name: ");
            String newNameFirst = getString();

            System.out.print("Enter Last Name: ");
            String newNameLast = getString();

            System.out.print("Enter age: ");
            String newAge = console.nextLine();
            int x = Integer.parseInt(newAge);
            while (x<=18) {
                System.out.print("Age must be above 18:");
                x = console.nextInt();
            }
            newAge = Integer.toString(x);
            // Create an array for the new voters
            String[] newvoters = {newId, newNameFirst,newNameLast,newAge};

            // Add the new voters to the votersData array
            votersData = addvoters(votersData, newvoters);
        }catch(Exception e){
            addNewvoters();
        }

        System.out.println("New voter added successfully!");
        return votersData;
    }

    private static String[][] addvoters(String[][] array, String[] voters) {
        // Create a new array with increased size to accommodate the new voters
        String[][] newArray = new String[array.length + 1][4];

        // Copy existing data to the new array

        System.arraycopy(array, 0, newArray, 0, array.length);

        // Add the new voters to the last row
        newArray[array.length] = voters;
        return newArray;
    }

    private static void printvotersData(String[][] votersData) {
        System.out.println("voters Information:");
        int j ;
        for (int i = 0 ; i< votersData.length; i++) {
            j=0;
            String id = votersData[i][j];
            j++;
            String nameFirst = votersData[i][j];
            j++;
            String namelast = votersData[i][j];
            j++;
            String age = votersData[i][j];

            System.out.println("ID: " + id + ", Name: " + nameFirst +" "+namelast+ ", age : "+age );
        }
    }

    private static String[][]  addNewcandidate() {
        try {
            System.out.println("Adding a new candidiate:");
            String newId = getCNIC(candidateData);

            System.out.print("Enter First Name: ");
            String newNameFirst = getString();

            System.out.print("Enter Last Name: ");
            String newNameLast = getString();

            System.out.print("Enter Logo: ");
            String newLogo = getString();

            System.out.print("Enter age: ");
            String newAge = console.nextLine();
            int x = Integer.parseInt(newAge);
            while (x<=25) {
                System.out.print("Age must be above 25:");
                x = console.nextInt();
            }
            newAge = Integer.toString(x);

            String newGen = getNewGen();

            // Create an array to add to the voting list
            String[] newCandiateVotinglist ={newId,newNameFirst,newNameLast,"0"};
            // Create an array for the new candidiate
            String[] newcandidiate = {newId, newNameFirst,newNameLast, newLogo,newAge,newGen};

            // Add the new candidiate to the   candidateData array
            candidateData = addcandidiate(  candidateData, newcandidiate);
            // Add the new candidatae to the voting list
            votingList = addcandidiateVotinglist(votingList, newCandiateVotinglist);
        }catch(Exception e){
            addNewcandidate();
        }

        System.out.println("New candidiate added successfully!");
        return   candidateData;
    }
    private static String[][] addcandidiateVotinglist(String[][] array, String[] candidiate) {
        // Create a new array with increased size to accommodate the new candidiate
        String[][] newArray = new String[array.length + 1][4];

        // Copy existing data to the new array

        System.arraycopy(array, 0, newArray, 0, array.length);


        // Add the new candidiate to the last row
        newArray[array.length] = candidiate;

        return newArray;
    }

    private static String[][] addcandidiate(String[][] array, String[] candidiate) {
        // Create a new array with increased size to accommodate the new candidiate
        String[][] newArray = new String[array.length + 1][6];

        // Copy existing data to the new array

        System.arraycopy(array, 0, newArray, 0, array.length);


        // Add the new candidiate to the last row
        newArray[array.length] = candidiate;

        return newArray;
    }
    private static void printVotinglist(String[][] raggedArray){

        for (int i = 0; i < raggedArray.length; i++) {
            for (int j = 0; j < raggedArray[i].length; j++) {
                System.out.printf("%-16s",raggedArray[i][j]);
            }
            System.out.println(); // Move to the next line after each row
        }
    }

    private static void  printcandidateData(String[][]   candidateData) {
        System.out.println("candidiate Information:");
        int j ;
        for (int i = 0 ; i<   candidateData.length; i++) {
            j=0;
            String id =   candidateData[i][j];
            j++;
            String nameFirst =   candidateData[i][j];
            j++;
            String nameSecond =   candidateData[i][j];
            j++;
            String logo =   candidateData[i][j];
            j++;
            String age =   candidateData[i][j];
            j++;
            String gender =   candidateData[i][j];
            System.out.println("ID: " + id + ", Name: " + nameFirst+" "+nameSecond+", logo: "+ logo +", age: "+ age +", gender: "+ gender);
        }
    }

    private static String getNewGen() {
        System.out.println("enter the gender ");
        String newGen = console.nextLine();
        newGen = newGen.toUpperCase();
        while (!(newGen.equals("MALE")||(newGen.equals("FEMALE")))) {
            System.out.print("enter male or female :");
            newGen = console.nextLine();
            newGen = newGen.toUpperCase();
        }
        return newGen;
    }

    public static int getInt(int l, int h) {
        int x = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("PRESS from the option : ");
                x = console.nextInt();
                if (x >= l && x <= h) {
                    isValidInput = true;
                } else {
                    System.out.println("Enter the options from " + l + " to " + h);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                console.nextLine(); // Clear the buffer
            }
        }

        return x;
    }

    private static String[][] addNewadmin() {
        try {
            String newId = getCNIC(adminData);

            System.out.print("Enter First Name: ");
            String newNamefirst = getString();

            System.out.print("Enter Last Name: ");
            String newNameLast = getString();

            System.out.print("Enter Password: ");
            String newPassword = console.nextLine();

            // Create an array for the new admin
            String[] newadmin = {newId, newNamefirst,newNameLast, newPassword};

            // Add the new admin to the adminData array
            adminData = addadmin(adminData, newadmin);
        }catch(Exception e){
            addNewadmin();
        }

        System.out.println("New admin added successfully!");
        return adminData;
    }

    private static String getCNIC(String[][] data) {
        System.out.print("Enter CNIC: ");
        String newId = console.nextLine();
        newId = console.nextLine();
        while (!isValidCNIC(newId,data)) {
            System.out.print("Enter a valid 13-digit CNIC: ");
            newId = console.nextLine();
        }

        return newId;
    }
    private static String getCNIC(){
        System.out.print("Enter CNIC: ");
        String newId = console.nextLine();
        newId = console.nextLine();
        while (!isValidCNIC(newId)) {
            System.out.print("Enter a valid 13-digit CNIC: ");
            newId = console.nextLine();
        }

        return newId;
    }

    private static boolean isValidCNIC(String cnic,String[][] data) {
        boolean present = booleanSearch(data, cnic,0);
        return cnic.length() == 13 && cnic.matches("\\d+") && !present;
    }
    private static boolean isValidCNIC(String cnic) {
        return cnic.length() == 13 && cnic.matches("\\d+");
    }

    private static String[][] addadmin(String[][] array, String[] admin) {
        // Create a new array with increased size to accommodate the new admin
        String[][] newArray = new String[array.length + 1][4];

        // Copy existing data to the new array

        System.arraycopy(array, 0, newArray, 0, array.length);


        // Add the new admin to the last row
        newArray[array.length] = admin;

        return newArray;
    }

    private static void printadminData(String[][] adminData) {
        System.out.println("admin Information:");
        int j ;
        for (int i = 0 ; i< adminData.length; i++) {
            j=0;
            String id = adminData[i][j];
            j++;
            String nameFirst = adminData[i][j];
            j++;
            String nameLast = adminData[i][j];

            System.out.println("ID: " + id + ", Name: " + nameFirst+" "+nameLast );
        }
    }

    public static String getString(){
        String newString = console.nextLine();
        while (!newString.matches("[a-zA-Z]+")) {
            System.out.print("enter only alphabets: ");
            newString = console.nextLine();
        }
        return newString;
    }
    public static boolean booleanSearch(String[][] array, String target,int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][n].equals(target)) {
                return true; // Element found, return its index
            }
        }
        return false; // Element not found
    }
    public static int linearSearch(String[][] array, String target,int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][n].equals(target)) {
                return i; // Element found, return its index
            }
        }
        return -1; // Element not found
    }

    static String[] votedData ={"0"};
    public static void castVote() {
        System.out.println("ENTER THE VOTERS INFO");
        String CNIC = getCNIC();

        if (booleanSearch(votersData, CNIC, 0)&& !isStringInArray(votedData, CNIC)){
            votedData = addNewvoted(votedData,CNIC);
            System.out.println("PRESS THE NUMBER TO VOTE :");
            int i = 0;
            for( i = 0; i<candidateData.length;i++){
                System.out.println((i+1)+" :"+candidateData[i][1]+" "+candidateData[i][2]+"   "+candidateData[i][3]);
            }
            int x = getInt(1, (i+1));
            String candi = candidateData[x-1][0];
            votingList[x-1] = addVote(votingList, candi, CNIC);
            int votes = Integer.parseInt(votingList[x-1][3])+1;
            votingList[x-1][3] = String.valueOf(votes);
            System.out.println("the vote has been casted: ");
        }else if(isStringInArray(votedData, CNIC)){
            System.out.println("the voter has already casted the vote");
        }else{
            System.out.println("the voter is not registered");
        }

    }
    private static boolean isStringInArray(String[] array, String target) {
        for (String element : array) {
            if (element.equals(target)) {
                return true; // String found in the array
            }
        }
        return false; // String not found in the array
    }
    private static String[] addNewvoted(String[] votedData1, String newId) {
        String[] newvoted = null; // Initialize outside of try block

        try {
            // Create an array for the new voted
            newvoted = new String[votedData1.length + 1];

            // Copy elements from votedData1 to newvoted
            System.arraycopy(votedData1, 0, newvoted, 0, votedData1.length);

            // Add the new voted to the newvoted array
            newvoted[votedData1.length] = newId;

        } catch (Exception e) {
            // Handle the exception appropriately, e.g., log or throw
            e.printStackTrace();
        }

        return newvoted;
    }

    public static String[] addVote(String[][] votinglist,String CID,String VID) {
        int ixC = linearSearch(votingList,CID , 0);
        String[] vin = votinglist[ixC];
        String[] newvin = new String[vin.length+1];

        System.arraycopy(vin, 0, newvin, 0, vin.length);
        newvin[vin.length] = VID;

        return newvin;

    }
    //for viwing a result and saving it to a file
    public static void declareWinner() {
        int maxVotes = -1;
        String winner = "";
        boolean draw = false;

        for (int i = 0; i < candidateData.length; i++) {
            int votes = Integer.parseInt(votingList[i][3]);

            if (votes > maxVotes) {
                maxVotes = votes;
                winner = candidateData[i][1] + " " + candidateData[i][2];
                draw = false; // Reset draw flag if a new leader is found
            } else if (votes == maxVotes) {
                draw = true; // Draw condition: More than one candidate has the same maximum votes
            }
        }

        if (maxVotes > 0 && !draw) {
            System.out.println("********** WINNER **********");
            System.out.println("Winner: " + winner);
            System.out.println("Votes: " + maxVotes);
            System.out.println("***************************");

            saveResultsToFile(winner, maxVotes);
        } else if (draw) {
            System.out.println("********** DRAW **********");
            System.out.println("No clear winner due to a draw.");
            System.out.println("***************************");
        } else {
            System.out.println("********** NO WINNER **********");
            System.out.println("No votes or all candidates have 0 votes.");
            System.out.println("********************************");
        }
    }


    public static void saveResultsToFile(String winner, int votes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("results.txt", true))) {
            writer.println("Winner: " + winner);
            writer.println("Votes: " + votes);
            writer.println("***************************");
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


    public static void displayPreviousResults() {
        try (Scanner fileScanner = new Scanner(new File("results.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous results found.");
 }
}
}