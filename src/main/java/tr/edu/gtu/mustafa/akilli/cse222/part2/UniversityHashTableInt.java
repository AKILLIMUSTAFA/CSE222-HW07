package tr.edu.gtu.mustafa.akilli.cse222.part2;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   UniversityHashTableInt
 *
 * Description:
 *
 * This is UniversityHashTableInt Interface
 *
 * @author Mustafa_Akilli
 * @since Sunday 28 April 2016 by Mustafa_Akilli
 */
public interface UniversityHashTableInt {

    /**
     * This equals method that return true if two cards belongs to the same assistant
     *
     * @param studentBarcodeNumber student Barcode Number
     * @param academicBarcodeNumber academic Barcode Number
     * @return true if two cards belongs to the same assistant otherwise return false
     */
    boolean equals(int studentBarcodeNumber,  int academicBarcodeNumber);
}
