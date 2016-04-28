package tr.edu.gtu.mustafa.akilli.cse222.part2;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   UniversityCardInt
 *
 * Description:
 *
 * UniversityCardInt for the People in the University
 *
 * @author Mustafa_Akilli
 * @since Sunday 27 April 2016 by Mustafa_Akilli
 */
public interface UniversityCard {

    /** Upper Limit for the student barcode number */
    int UPPER_LIMIT_STUDENT_BARCODE_NUMBER = 4999;
    /** Lower Limit for the student barcode number */
    int LOWER_LIMIT_STUDENT_BARCODE_NUMBER = 1000;
    /** Upper Limit for the academic barcode number */
    int UPPER_LIMIT_ACADEMIC_BARCODE_NUMBER = 15000;
    /** Lower Limit for the academic barcode number */
    int LOWER_LIMIT_ACADEMIC_BARCODE_NUMBER = 5000;

    /**
     * Get Name of barcode owner
     *
     * @return Name of barcode owner
     */
    String getName();

    /**
     * Set Name of barcode owner
     *
     * @param newName for barcode owner
     */
    void setName(String newName);

    /**
     * Get Surname of barcode owner
     *
     * @return Surname of barcode owner
     */
    String getSurname();

    /**
     * Set Surname of barcode owner
     *
     * @param newSurname for barcode owner
     */
    void setSurname(String newSurname);

    /**
     * Get Student Barcode Number
     *
     * @return Barcode Student Number of person
     */
    int getStudentBarcodeNumber();

    /**
     * Set Student Barcode Number
     *
     * @param newStudentBarcodeNumber for person
     */
    void setStudentBarcodeNumber(int newStudentBarcodeNumber);

    /**
     * Get Academic Barcode Number
     *
     * @return Barcode Academic Number of person
     */
    int getAcademicBarcodeNumber();

    /**
     * Set Academic Barcode Number
     *
     * @param newAcademicBarcodeNumber for person
     */
    void setAcademicBarcodeNumber(int newAcademicBarcodeNumber);
}
