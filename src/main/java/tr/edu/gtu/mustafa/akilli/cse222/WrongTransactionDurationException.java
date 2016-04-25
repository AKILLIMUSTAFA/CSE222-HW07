package tr.edu.gtu.mustafa.akilli.cse222;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   WrongTransactionDurationException
 *
 * Description:
 *
 * WrongTransactionDurationException
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class WrongTransactionDurationException extends  RuntimeException{

    /**
     * Constructs a new WrongTransactionDurationException
     */
    public WrongTransactionDurationException() {
        System.err.println("Wrong Argument for Transaction Duration.");
    }
}
