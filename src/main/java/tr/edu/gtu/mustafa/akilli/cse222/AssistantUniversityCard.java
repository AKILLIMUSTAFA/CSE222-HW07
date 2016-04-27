package tr.edu.gtu.mustafa.akilli.cse222;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   AssistantUniversityCard
 *
 * Description:
 *
 * Student University Card
 *
 * @author Mustafa_Akilli
 * @since Sunday 27 April 2016 by Mustafa_Akilli
 */
public class AssistantUniversityCard implements UniversityCard{

    private String name;
    private String surname;
    private int studentBorcodeNumber;
    private int academicBorcodeNumber;

    /**
     * Four Parameter Constructor
     *
     * @param newName for the Assistant
     * @param newSurName for the Assistant
     * @param newStudentBarcodeNumber for the Assistant
     * @param newAcademicBarcodeNumber for the Assistant
     */
    public AssistantUniversityCard(String newName, String newSurName, int newStudentBarcodeNumber, int newAcademicBarcodeNumber){
        /* set Name of Assistant */
        setName(newName);
        /* set Surname of Assistant */
        setSurname(newSurName);
        /* set Student Barcode Number of Assistant */
        setStudentBarcodeNumber(newStudentBarcodeNumber);
        /* set Academic Barcode Number of Assistant */
        setAcademicBarcodeNumber(newAcademicBarcodeNumber);
    }

    /**
     * Get Name of barcode owner
     *
     * @return Name of barcode owner
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name of barcode owner
     *
     * @param newName for barcode owner
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Get Surname of barcode owner
     *
     * @return Surname of barcode owner
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set Surname of barcode owner
     *
     * @param newSurname for barcode owner
     */
    public void setSurname(String newSurname) {
        surname = newSurname;
    }

    /**
     * Get Student Barcode Number
     *
     * @return Barcode Student Number of person
     */
    public int getStudentBarcodeNumber() {
        return studentBorcodeNumber;
    }

    /**
     * Set Student Barcode Number
     *
     * @param newStudentBarcodeNumber for person
     */
    public void setStudentBarcodeNumber(int newStudentBarcodeNumber) {
        if(newStudentBarcodeNumber <= UPPER_LIMIT_STUDENT_BARCODE_NUMBER &&
                newStudentBarcodeNumber >= LOWER_LIMIT_STUDENT_BARCODE_NUMBER)
            studentBorcodeNumber = newStudentBarcodeNumber;

        else
            throw new WrongNumberForTheBarcodeException();
    }

    /**
     * Get Academic Barcode Number
     *
     * @return Barcode Academic Number of person
     */
    public int getAcademicBarcodeNumber() {
        return academicBorcodeNumber;
    }

    /**
     * Set Academic Barcode Number
     *
     * @param newAcademicBarcodeNumber for person
     */
    public void setAcademicBarcodeNumber(int newAcademicBarcodeNumber) {
        if(newAcademicBarcodeNumber <= UPPER_LIMIT_ACADEMİC_BARCODE_NUMBER &&
                newAcademicBarcodeNumber >= LOWER_LIMIT_ACADEMİC_BARCODE_NUMBER)
            academicBorcodeNumber = newAcademicBarcodeNumber;

        else
            throw new WrongNumberForTheBarcodeException();
    }
}
