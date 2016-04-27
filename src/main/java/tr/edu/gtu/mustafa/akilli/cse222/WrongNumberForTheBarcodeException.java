package tr.edu.gtu.mustafa.akilli.cse222;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   WrongNumberForTheBarcodeException
 *
 * Description:
 *
 * WrongNumberForTheBarcodeException
 *
 * @author Mustafa_Akilli
 * @since Sunday 27 April 2016 by Mustafa_Akilli
 */
public class WrongNumberForTheBarcodeException extends  RuntimeException{

    /**
     * Constructs a new WrongNumberForTheBarcodeException
     */
    public WrongNumberForTheBarcodeException() {
        System.err.println("Given Number don't between Barcode Numbers Range");
    }
}
