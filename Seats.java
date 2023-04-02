/**
 * @Unit 8
 * @author Andre Dorsey
 * @version 03-20-2016
 * @professor Than Maung
 * a program to assign passengers seats in an airplane
 */
import java.util.Scanner;

public class Seats 
{
    private static Scanner a;

	public static void main(String[] args) 
    {
		//creates the seating chart will all available seats
        Plane airPlane = new Plane(); 
        
        //scans the user input
        a = new Scanner(System.in);
        String input; 
        
        //Starts the loop false until true when available seats are filled
        boolean finish=false;
        
        // do while loop
        do 
        {
            // Displays the seating chart 
            System.out.println(airPlane.toString());

            // Checks for all unavailable seats.
            if (airPlane.fullPlane()) 
            {
                System.out.println("All seats are taken... Exiting.");
                finish=true;
            }
            
            else 
            {
                // prompts the user for input to assign the seating
                System.out.print("Please enter the seat passenger is requesting "
                		+ "or press 'Q' to quit:");
                
                input = (a.nextLine()).toUpperCase();
                  if (input.charAt(0)=='Q') 
                  {
                      finish=true;
                  }
                  else 
                  {
                      airPlane.assignSeat(input);
                  }; // ends program

            }
        } while (!finish);
    }
}

        
               
     
    