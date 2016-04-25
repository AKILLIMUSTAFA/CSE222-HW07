package tr.edu.gtu.mustafa.akilli.cse222;

/**
 * HW07_131044017_Mustafa_Akilli
 *
 * File:   MyPriorityQueueInt
 *
 * Description:
 *
 * This is Customer Class for customers.
 * Customer have 3 Feature.
 * Arrival Time (Minute) , Transaction Duration (Minute) , Type.
 *
 * @author Mustafa_Akilli
 * @since Sunday 24 April 2016 by Mustafa_Akilli
 */
public class Customer {

    private int arrivalTime; /* Arrival Time of Customer (Minute) */
    private int transactionDuration; /* Transaction Duration of Customer (Minute) */
    private int type; /* Type of Customer. Customer Type can be 1,2 and 3. */
    private static final int MAX_MINUTE = 1439; /* MAX MINUTE its mean 23:59 */
    private static final int MIN_MINUTE = 0; /* MIN MINUTE */
    private static final int GOLDEN_CUSTOMER = 1;/*GOLDEN Customer Number */
    private static final int SILVER_CUSTOMER = 2;/*SILVER Customer Number */
    private static final int BRONZ_CUSTOMER = 3;/*BRONZ Customer Number */
    private int numberOfDay; /* number of Day */

    /**
     * Four parameter Constructor
     */
    public Customer(int newArrivalTime, int newTransactionDuration, int newType , int newNumberOfDay){

        /*Set Customers Informations  */
        setArrivalTime(newArrivalTime);
        setTransactionDuration(newTransactionDuration);
        setCustomerType(newType);
        setNumberOfDay(newNumberOfDay);
    }//end of the Three parameter Constructor

    /**
     * Get Arrival Time
     *
     * @return Arrival Time of Customer
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Set Arrival Time
     *
     * @param newArrivalTime of Customer
     * @throws WrongArrivalTimeException if newArrivalTime bigger than MAX_MINUTE or smaller than MIN_MINUTE
     */
    private void setArrivalTime(int newArrivalTime) throws WrongArrivalTimeException{
        if(newArrivalTime > MAX_MINUTE || newArrivalTime < MIN_MINUTE)
            throw new WrongArrivalTimeException();
        else
            this.arrivalTime = newArrivalTime;
    }

    /**
     * Get Transaction Duration
     *
     * @return Transaction Duration of Customer
     */
    public int getTransactionDuration() {
        return transactionDuration;
    }

    /**
     * Set Transaction Duration
     *
     * @param newTransactionDuration of Customer
     * @throws WrongArrivalTimeException if equals MIN_MINUTE or smaller than MIN_MINUTE
     */
    private void setTransactionDuration(int newTransactionDuration) {
        if(newTransactionDuration <= MIN_MINUTE)
            throw new WrongTransactionDurationException();
        else
            this.transactionDuration = newTransactionDuration;
    }

    /**
     * Get Customer Type
     *
     * @return Type of Customer
     */
    public int getCustomerType() {
        return type;
    }

    /**
     * Set Customer Type
     *
     * @param newType of Customer
     * @throws WrongTypeException if unexpected type
     */
    private void setCustomerType(int newType) {
        if(newType == GOLDEN_CUSTOMER || newType == SILVER_CUSTOMER || newType == BRONZ_CUSTOMER)
            this.type = newType;
        else
            throw new WrongTypeException();
    }

    /**
     * Get Number Of Day
     *
     * @return Number Of Day customer arrive
     */
    public int getNumberOfDay() {
        return numberOfDay;
    }

    /**
     * Set Number Of Day
     *
     * @param newNumberOfDay
     */
    private void setNumberOfDay(int newNumberOfDay) {
        this.numberOfDay = newNumberOfDay;
    }

    /**
     * Returns a string representation of the Customer
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder customerString = new StringBuilder();
        int minute;
        int hour;

        /* Add Arrivel Time, Transaction Duration , And Type of Customer. */
        hour = getArrivalTime() / 60;
        minute = getArrivalTime() % 60;
        customerString.append(hour);
        customerString.append(":");
        customerString.append(minute);
        customerString.append("           ");
        hour = getTransactionDuration() / 60;
        minute = getTransactionDuration() % 60;
        customerString.append(hour);
        customerString.append(":");
        customerString.append(minute);
        customerString.append("           ");
        customerString.append("Customer ");
        customerString.append(getCustomerType());

        return customerString.toString();
    }
}
