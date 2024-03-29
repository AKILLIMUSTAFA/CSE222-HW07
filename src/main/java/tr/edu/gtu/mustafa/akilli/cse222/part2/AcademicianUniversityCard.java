package tr.edu.gtu.mustafa.akilli.cse222.part2;

import tr.edu.gtu.mustafa.akilli.cse222.exceptions.WrongNumberForTheBarcodeException;

import java.util.HashMap;

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
public class AcademicianUniversityCard implements UniversityCard {

    private String name;
    private String surname;
    private int studentBorcodeNumber;
    private int academicBorcodeNumber;

    /**
     * Four Parameter Constructor
     *
     * @param newName for the Assistant
     * @param newSurName for the Assistant
     * @param newAcademicBarcodeNumber for the Assistant
     */
    public AcademicianUniversityCard(String newName, String newSurName, int newAcademicBarcodeNumber){
        /* set Name of Assistant */
        setName(newName);
        /* set Surname of Assistant */
        setSurname(newSurName);
        /* set Student Barcode Number of Assistant */
        setStudentBarcodeNumber(-1);
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
        studentBorcodeNumber = newStudentBarcodeNumber;
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
        if(newAcademicBarcodeNumber <= UPPER_LIMIT_ACADEMIC_BARCODE_NUMBER &&
                newAcademicBarcodeNumber >= LOWER_LIMIT_ACADEMIC_BARCODE_NUMBER)
            academicBorcodeNumber = newAcademicBarcodeNumber;

        else
            throw new WrongNumberForTheBarcodeException();
    }

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     *
     * The general contract of {@code hashCode} is:
     *
     * Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * It is not required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     *
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */
    @Override
    public int hashCode() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getAcademicBarcodeNumber());
        return stringBuilder.toString().hashCode();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     * {@code x}, {@code x.equals(x)} should return
     * {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     * {@code x} and {@code y}, {@code x.equals(y)}
     * should return {@code true} if and only if
     * {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     * {@code x}, {@code y}, and {@code z}, if
     * {@code x.equals(y)} returns {@code true} and
     * {@code y.equals(z)} returns {@code true}, then
     * {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     * {@code x} and {@code y}, multiple invocations of
     * {@code x.equals(y)} consistently return {@code true}
     * or consistently return {@code false}, provided no
     * information used in {@code equals} comparisons on the
     * objects is modified.
     * <li>For any non-null reference value {@code x},
     * {@code x.equals(null)} should return {@code false}.
     * </ul>
     * <p>
     * The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * Note that it is generally necessary to override the {@code hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        try{
            return (hashCode() == ((AcademicianUniversityCard) obj).hashCode());
        }
        catch (Exception e){
            return false;
        }
    }
}
