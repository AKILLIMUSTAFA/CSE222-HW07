package tr.edu.gtu.mustafa.akilli.cse222.exceptions;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   WrongArrivalTimeException
 *
 * Description:
 *
 * WrongArrivalTimeException
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class WrongArrivalTimeException extends  RuntimeException{

    /**
     * Constructs a new WrongArrivalTimeException
     */
    public WrongArrivalTimeException() {
        System.err.println("Wrong Argument for Arrival Time.");
    }
}
