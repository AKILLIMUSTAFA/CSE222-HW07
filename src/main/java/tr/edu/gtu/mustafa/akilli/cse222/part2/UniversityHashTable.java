package tr.edu.gtu.mustafa.akilli.cse222.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   UniversityHashTable
 *
 * Description:
 *
 *  This is UniversityHashTable Class.
 *  I used Student's Version of the Source Code
 *  for "Data Structures: Abstraction and Design Using Java 2e" by
 *  Koffman and Wolfgang.
 *
 * @author Mustafa_Akilli
 * @since Sunday 25 April 2016 by Mustafa_Akilli
 */
public class UniversityHashTable implements UniversityHashTableInt{

    /* Hastable for The Cards */
    HashtableOpen<UniversityCard,Integer> hashtable;
    /* Data File Name */
    private String dataFileName;
    /* Current Card information*/
    String currentName;
    String currentStudentBarcodeNumber;
    String currentAcademicianBarcodeNumber;

    /**
     * One Parameter Constructor
     *
     * @param newDataFileName for the University
     * @throws FileNotFoundException if file not found
     */
    public UniversityHashTable(String newDataFileName) throws FileNotFoundException {
        setDataFileName(newDataFileName);
        setHashtable();
        addAllElement();
    }

    /**
     * This equals method that return true if two cards belongs to the same assistant
     *
     * @param studentBarcodeNumber  student Barcode Number
     * @param academicBarcodeNumber academic Barcode Number
     */
    public boolean equals(int studentBarcodeNumber, int academicBarcodeNumber) {
        if(studentBarcodeNumber < 1000 || studentBarcodeNumber > 4999 ||
                academicBarcodeNumber < 5000 || academicBarcodeNumber > 15000)
            return false;

        AssistantUniversityCard assistantUniversityCard =
                new AssistantUniversityCard("ignore","ignore",
                        studentBarcodeNumber,academicBarcodeNumber);

        try{
            return (getHashtable().get(assistantUniversityCard) == studentBarcodeNumber);
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Get Hashtable
     *
     * @return Hashtable
     */
    public HashtableOpen<UniversityCard, Integer> getHashtable() {
        return hashtable;
    }

    /**
     * Set Hashtable Open
     */
    public void setHashtable() {
        this.hashtable = new HashtableOpen<UniversityCard, Integer>();
    }

    /**
     * Get Data File Name
     *
     * @return Data File Name
     */
    private String getDataFileName() {
        return dataFileName;
    }

    /**
     * Set Data File Name
     *
     * @param newDataFileName for HashTable
     */
    private void setDataFileName(String newDataFileName) {
        this.dataFileName = newDataFileName;
    }

    /**
     * Get Current Name
     *
     * @return Current Name
     */
    public String getCurrentName() {
        return currentName;
    }

    /**
     * Set Current Name
     *
     * @param currentName for the currentName
     */
    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /**
     * Get Current Student Barcode Number
     *
     * @return Current Student Barcode Number
     */
    public String getCurrentStudentBarcodeNumber() {
        return currentStudentBarcodeNumber;
    }

    /**
     * Set Current Student Barcode Number
     *
     * @param currentStudentBarcodeNumber for the Current Student Barcode Number
     */
    public void setCurrentStudentBarcodeNumber(String currentStudentBarcodeNumber) {
        this.currentStudentBarcodeNumber = currentStudentBarcodeNumber;
    }

    /**
     * Get Current Academician Barcode Number
     *
     * @return Current Academician Barcode Number
     */
    public String getCurrentAcademicianBarcodeNumber() {
        return currentAcademicianBarcodeNumber;
    }

    /**
     * Set Current Academician Barcode Number
     *
     * @param currentAcademicianBarcodeNumber currentAcademicianBarcodeNumber
     */
    public void setCurrentAcademicianBarcodeNumber(String currentAcademicianBarcodeNumber) {
        this.currentAcademicianBarcodeNumber = currentAcademicianBarcodeNumber;
    }

    /**
     * Add All Element in the Hash Table
     *
     * @throws FileNotFoundException if file not found
     */
    public void addAllElement() throws FileNotFoundException {

        File inFile = new File(getDataFileName()); /* Txt */
        Scanner sc = new Scanner(inFile);
        String line = sc.nextLine();/*Pass the first line */

        while (sc.hasNextLine()){
            /* Take the line */
            line = sc.nextLine();

            /* Conntrol the card */
            boolean check;

            /* make A card */
            check = makeACard(line);

            /* if this assistant card */
            if(check){
                AssistantUniversityCard assistantUniversityCard =
                            new AssistantUniversityCard(getCurrentName(),getCurrentName(),
                                    Integer.parseInt(getCurrentStudentBarcodeNumber()),
                                    Integer.parseInt(getCurrentAcademicianBarcodeNumber()));

                getHashtable().put(assistantUniversityCard,
                assistantUniversityCard.getStudentBarcodeNumber());
            }

            /* if this academician card */
            else{
                AcademicianUniversityCard academicianUniversityCard =
                        new AcademicianUniversityCard(getCurrentName(),getCurrentName(),
                                Integer.parseInt(getCurrentAcademicianBarcodeNumber()));

                getHashtable().put(academicianUniversityCard,
                        academicianUniversityCard.getStudentBarcodeNumber());
            }
        }
    }

    /**
     * Make A Card
     *
     * @param line for the Card İnformation
     * @return if assistant card then return true, if academician card then return false.
     */
    private boolean makeACard(String line){

        mergeTheLine(line);

        try {
            Integer.parseInt(getCurrentStudentBarcodeNumber());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Merge The Line
     *
     * @param line for the merge
     */
    private void mergeTheLine(String line){

        int index,indexForStudentBarcode,indexForAcademicianBarcode; /* index for loops */

        /* For The Name */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line.charAt(0));
        stringBuilder.append(line.charAt(1));
        stringBuilder.append(line.charAt(2));
        stringBuilder.append(line.charAt(3));
        setCurrentName(stringBuilder.toString());

        /* Pass the spaces */
        for (index = 4; index < line.length(); ++index) {
            if (line.charAt(index) != '\t')
                break;
        }

        /* For The Student Number */
        StringBuilder stringBuilderForTheStudentNumber = new StringBuilder();
        for (indexForStudentBarcode = index; indexForStudentBarcode < (index + 4); ++indexForStudentBarcode) {
            if (line.charAt(indexForStudentBarcode) != ' ')
                stringBuilderForTheStudentNumber.append(line.charAt(indexForStudentBarcode));
        }
        setCurrentStudentBarcodeNumber(stringBuilderForTheStudentNumber.toString());


        /* Pass the spaces */
        for (index = indexForStudentBarcode; index < line.length(); ++index) {
            if (line.charAt(index) != '\t')
                break;
        }

        /* For The Academic Number */
        StringBuilder stringBuilderForTheAcademicNumber = new StringBuilder();
        for (indexForAcademicianBarcode = index; indexForAcademicianBarcode < line.length(); ++indexForAcademicianBarcode) {
            stringBuilderForTheAcademicNumber.append(line.charAt(indexForAcademicianBarcode));
        }
        setCurrentAcademicianBarcodeNumber(stringBuilderForTheAcademicNumber.toString());
    }

    /**
     * Average Collision Number
     *
     * @return Average Collision Number
     */
    public double averageCollisionNumber(){
        return (double)getHashtable().getCollusionNumber()/getHashtable().getNumKeys();
    }
}