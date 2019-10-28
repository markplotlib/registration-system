package person;

import enums.*;

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
 * @author Mark Chesney
 */
public class Faculty extends Person {

    /**
     * Constructor for creating a new faculty member
     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param suid        unique Seattle University identification number
     * @param type        The type of faculty (see FacultyType enum)
     * @param bldg        The building name
     * @param room        The room number
     * @param email       The school (i.e. SU) email address
     */
    public Faculty(String firstName, String lastName, int suid,
                    FacultyType type, Building bldg, int room, String email) {

        super(firstName, lastName, suid);
        this.email = email;
        this.type = type;
        this.office = bldg.toString() + " " + room;
    }

    /**
     * Constructor used to make full name of faculty member
     * @param firstName   The first name
     * @param lastName    The last name
     */
    public Faculty(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Faculty: Name=" + getFirstName() + " " + getLastName() +
        ", SUID=" + getSuId() +
        ", Email=" + email +
        ", Status=" + getStatus() +
        ", Type=" + type +
        ", Office=" + office + "\r";
    }

    // member fields
    private String email;
    private FacultyType type;
    private String office;
}
