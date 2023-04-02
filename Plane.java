/* Class to represent a plane seats chart */
public class Plane {
    char [][] chart; /* seats chart */

    /* Chart size */
    int ROWS=7; /* by row */
    int COLS=5; /* by column */

    /* Constructor. Allocates memory for chart.
     * @return Returns new plane chart with all seats marked free
     */
    Plane (){
        /* Allocate memory in constructor */
        chart=new char[ROWS][COLS]; // COLS+1 is for space between AB CD
        
        /* Setup default letter assignment */
        for (int i=0; i<ROWS; i++){
            chart[i][0]='A';
            chart[i][1]='B';
            chart[i][2]=' ';
            chart[i][3]='C';
            chart[i][4]='D';
        }
    }

    /* Try to assign seat. Print appropriate messages when impossible.
     *
     * @param str String entered by user. Expected format is "1A" .. "7D"
     * @return Returns true if the seat is successfully taken, otherwise false
     */
    public boolean assignSeat(String str){
        boolean result = false; /* true if the seat has been assigned */

        /* convert all to Upper */
        str=str.toUpperCase();

        if (!okRow(str.charAt(0)) || !okSeat(str.charAt(1))){
            System.out.println("Seat format is invalid\n");
        }
        else { /* format is OK, check if the seat is busy */
            result=markSeat(str.charAt(0), str.charAt(1));

            if (result) {
                System.out.println("The seat is taken\n");
            }
            else {
                System.out.println("The seat is busy, try another one\n");
            }
        }
        return result;
    }

    /* Convert chart to string
     * @return Returns string representation of the chart (with line breaks).
     */
    @Override
    public String toString(){
        String result="";
        for (int i=0; i<ROWS; i++){ /* for all rows */
            /* form an integer row + space */
            result+=Integer.toString(i+1);
            result+=" ";

            /* append all chars from the chart */
            for (int j=0; j<COLS; j++)
                result+=chart[i][j];
            
            result+="\n"; /* end of line */
        }
        return result;
    }

    /* Check if the entered row  char is correct
     * @param r Letter, representing row (expected '1'..'7')
     * @return Returns true if the row is within the range '1'..'7'
     */
    private boolean okRow(char r){
        if (r>='1' && r<='7') return true;
        else return false;
    }

    /* Check if the entered seat char is correct
     * @param s Character, representing seat. Already in UPPERCASE. Expected 'A'..'D'
     * @return Returns true if the seat is 'A'..'D' or false otherwise
     */
    /* s is already in the Upper Case */
    private boolean okSeat(char s){
        if (s>='A' && s<='D') return true;
        else return false;
    }

    /* Try to mark the seat as taken
     * @param row Character, represengint Row ('1'..'7'). Already valid.
     * @param seat Character, representing seat within the row ('A'..'D'). Already valid.
     * @return Returns true if the seat is successfully marked as taken.
     */
    private boolean markSeat(char row, char seat){
        int rowIndex, seatIndex;
        boolean result=false;

        rowIndex=row-'1';
        seatIndex=seat-'A'; // 'A' becomes 0, B - 1
        if (seatIndex>1) seatIndex++; // add 1 to add space between AB and CD

        if (chart[rowIndex][seatIndex]!='X') { // if not busy
            result=true;
            chart[rowIndex][seatIndex]='X'; // mark as taken
        }

        return result;
    }

    /* Check if the plane is full
     * @return Returns true if there are no free seats in the plane
     */
    public boolean fullPlane(){ /* we decided to make fullPlane() piblic */
        for (int i=0; i<ROWS; i++){
            for (int j=0; j<COLS; j++) { // if at least one is not ' ' and 'X'
              if (chart[i][j]!='X' && chart[i][j]!=' ') return false;
            }
        }
        return true;
    }
}
