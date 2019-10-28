package person;

import enums.*;

/**
 * <p>The <strong>Person</strong> class holds information about a person
 * (e.g., a student, a faculty member, etc.).</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 *
 * @author Mark Chesney
 */
public class Person {

    /**
     * Constructor for creating a new person and generating a unique ID number
     * @param firstName   The first name
     * @param lastName    The last name
     * @param suid        unique Seattle University identification number
     */
    public Person(String firstName, String lastName, int suid) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.suid = suid;
        // default status for new people: ACTIVE
        this.status = PersonStatus.ACTIVE;
    }

    /**
     * Constructor for creating a new person
     * @param firstName   The first name
     * @param lastName    The last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Set the status of the person
     * (e.g., to deactivate at a later time)
     * @param status    status of the person (ACTIVE, INACTIVE)
     */
    public void setStatus(PersonStatus status) {
        this.status = status;
    }

    /**
     * Get the first name
	 * @return     the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
    * Get the last name
	 * @return     the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
     * Get the SU ID
	 * @return the SU ID
	 */
	public int getSuId() {
		return suid;
	}

	/**
     * Get the person's status
	 * @return     status of the person (ACTIVE, INACTIVE)
	 */
	public PersonStatus getStatus() {
		return status;
	}

    /**
     * Get person's full name
	 * @return the status
	 */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // member fields
    private String firstName;
	private String lastName;
    private int suid;
    private PersonStatus status;
}
