package person;

import enums.*;
import system.RegistrationSystem;

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
    public Person(String firstName, String lastName) {

        // TODO: implement Person constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.suid = generateSuId();
        // default status for new people: ACTIVE
        this.status = PersonStatus.ACTIVE;
    }

    /**
     *
     * @return
     */
    public int generateSuId() {
        return ++newSuId;
    }

    /**
     *
     * @param status
     */
    public void setStatus(PersonStatus status) {
        this.status = status;
    }

    // SU ID generator
    protected int newSuId = 100000;

    protected String firstName;
    protected String lastName;
    protected int suid;
    protected PersonStatus status;
}
