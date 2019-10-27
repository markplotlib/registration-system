package person;

import enums.*;
import system.RegistrationSystem;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 *
 * @author
 */
public class Faculty extends Person {

    /**
     *
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     */
    public Faculty(String firstName, String lastName, String email) {

        super(firstName, lastName);
        this.email = email;
        // TODO: implement Faculty constructor
    }

// QUESTION: CAN THIS CODE BE REUSED BETWEEN Student.java and Faculty.java?
    @Override
    public String toString() {
        return "Faculty: Name=" + firstName + " " + lastName +
        ", SUID=" + suid +
        ", Email=" + email +
        ", Status=" + status +
        "\r";
    }

    private String email;
// private PersonStatus status;
// private FacultyType type;
// private Building office;

    // TODO: add Faculty fields
    // - SUID
    // - status (see PersonStatus)
    // - faculty type (see FacultyType)
    // - office (see Building)
}
