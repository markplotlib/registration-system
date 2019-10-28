package person;

import enums.*;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at
 *   a point of time, but can switch from one program to another (i.e. when
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 *
 * @author Mark Chesney
 */
public class Student extends Person {

    /**
     * Constructor for creating a new student
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     * @param suid        unique Seattle University identification number
     * @param type        The type of student (see StudentType enum)
     * @param program     The
     * @param quarter     The
     * @param year        The

// TODO: generate this in RegistrationSystem, then pass it in
//         this.email = firstName.toLowerCase() + lastName.toLowerCase() +
            "@seattleu.edu";

     * @param email       The school (i.e. SU) email address

     */
    public Student(String firstName, String lastName, int suid,
                    StudentType type, StudentProgram program,
                    Quarter quarter, int year) {

    	super(firstName, lastName, suid);
        this.email = firstName.toLowerCase() + lastName.toLowerCase() +
            "@seattleu.edu";
        this.type = type;
        this.program = program;
        this.quarter = quarter;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student: Name=" + getFirstName() + " " + getLastName() +
        ", SUID=" + getSuId() +
        ", Email=" + email +
        ", Status=" + getStatus() +
        ", Type=" + type +
        ", Program=" + program +
        ", Term=" + quarter + " " + year + "\r";
    }

    /**
     * Set student's program, see StudentProgram enum
     */
    public void setProgram(StudentProgram pgrm) {
        this.program = pgrm;
    }

    private String email;
    private StudentType type;
    private StudentProgram program;
// TEMPORARY FIELD
private Quarter quarter;
private int year;
// FINAL SOLUTION
    // private Quarter startTerm;
    // private StudentYear year;

// private Faculty advisor;

    // TODO: add Student fields
    // - student year (see StudentYear; only if undergrad––default to freshman)
    // - start term (see Quarter)
    // - faculty advisor

}
