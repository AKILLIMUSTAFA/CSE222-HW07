package tr.edu.gtu.mustafa.akilli.cse222.exceptions;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   WrongTypeException
 *
 * Description:
 *
 * WrongTypeException
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class WrongTypeException extends  RuntimeException{

    /**
     * Constructs a new WrongTypeException
     */
    public WrongTypeException() {
        System.err.println("Wrong Argument for Customer Type.");
    }
}
