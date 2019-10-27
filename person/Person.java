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
 * <p>For example, <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 *
 * @author Mark Chesney
 */
public class Person {

    /**
     *
     * @param firstName   The first name
     * @param lastName    The last name
     */
    public Person(String firstName, String lastName, int suid) {

        // TODO: implement Person constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.suid = suid;
        // default status for new people: ACTIVE
        this.status = PersonStatus.ACTIVE;
    }

    /**
     *
     * @param status
     */
    public void setStatus(PersonStatus status) {
        this.status = status;
    }

    /**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the suid
	 */
	public int getSuId() {
		return suid;
	}

	/**
	 * @param suid the suid to set
	 */
	public void setSuid(int suid) {
		this.suid = suid;
	}

	/**
	 * @return the status
	 */
	public PersonStatus getStatus() {
		return status;
	}

    private String firstName;
	private String lastName;
    private int suid;
    private PersonStatus status;
}
