import java.io.*;

public class Main {
    public static void main(String[] args) {
        Plane airPlane = new Plane(); /* new chart, all seats are free */
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String inputStr; /* User input */
        boolean finish=false;
        
        /* Now the logic */
        do {
            /* Display chart */
            System.out.println(airPlane.toString());

            /* Check if all seats are taken, that's why we need a public fullPlane */
            if (airPlane.fullPlane()) {
                System.out.println("All seats are taken... Exiting.");
                finish=true;
            }
            else {
                /* Show prompt */
                System.out.print("Please enter the seat to take or 'Q' to quit:");
                try {
                  inputStr = (d.readLine()).toUpperCase();
                  if (inputStr.charAt(0)=='Q') {
                      finish=true;
                  }
                  else {
                      /* try to assign. All messages are already printed there */
                      airPlane.assignSeat(inputStr);
                  }
                } catch (IOException e){ finish=true;}; // quit

            }
        } while (!finish);

               
    }

}
