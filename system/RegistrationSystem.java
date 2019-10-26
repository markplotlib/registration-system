package system;

import registration.Course;
import registration.Section;
import person.Person;
import person.Faculty;
import person.Student;
import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.SubjectCode;
import enums.StudentProgram;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import exception.DuplicateSectionException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The <strong>RegistrationSystem</strong> class stores information about the school,
 * including the ability to add students, add faculty, add courses, and add prerequisite(s).</p>
 *
 * @author ohsh
 */
public class RegistrationSystem {

    /**
     *
     */
    public RegistrationSystem() {

        // SU ID number generator


        // initialize collections (of faculty, students,
        // courses, sections)
        facultyList = new ArrayList<Faculty>();
        studentList = new ArrayList<Student>();

        // TODO: implement WITHIN RegistrationSystem constructor:
            // initialize courseList
            // initialize sectionList

    }


/**
 * TEMPORARY CONSTRUCTOR CALL
 */
public void addFaculty(String firstName, String lastName, RegistrationSystem system) throws DuplicatePersonException {
	facultyList.add(new Faculty(firstName, lastName, system));
}
/**
 * TEMPORARY CONSTRUCTOR CALL
 */
public void addStudent(String firstName, String lastName, RegistrationSystem system) throws DuplicatePersonException {
	studentList.add(new Student(firstName, lastName, system));
}



    /**
     * Add a student to the student list collection.
     *
     * @param firstName  The first name of the student
     * @param lastName   The last name of the student
     * @param type       The student type
     * @param program    The student program
     * @param quarter    The start quarter of the student
     * @param year       The start year of the student
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addStudent(String firstName, String lastName,
                            StudentType type, StudentProgram program,
                            Quarter quarter, int year)
                            throws DuplicatePersonException {

        // TODO: implement addStudent method

    }

    /**
     * Add a faculty to the faculty list collection.
     *     * @param firstName   The first name of the faculty
     * @param lastName    The last name of the faculty
     * @param type        The faculty type
     * @param bldg        The building of the faculty office
     * @param room        The (building) room of the faculty office
     * @param email       The email of the faculty
     * @throws DuplicatePersonException The person is already in the system
     */
    public void addFaculty(String firstName, String lastName,
                            FacultyType type, Building bldg, int room, String email)
                            throws DuplicatePersonException {

        // TODO: implement addFaculty method

    }

    /**
     * Adds a subject to the subject list collection.
     * (hint: use a Map instead of creating a class)
     *
     * @param code    The subject code
     * @param desc    The subject description
     *
     * @throws DuplicateSubjectException The subject is already in the system
     */
    public void addSubject(SubjectCode code, String desc)
                            throws DuplicateSubjectException {

        // TODO: implement addSubject method

    }

    /**
     * Adds a course to the course list collection.
     *
     * @param code       The subject code of the course
     * @param num        The course number of the course
     * @param name       The course name
     * @param creditNum  The number of the credits of the course
     * @throws DuplicateCourseException    The course is already in the system
     */
    public void addCourse(SubjectCode code, int num, String name,
                            int creditNum) throws DuplicateCourseException {

        // TODO: implement addCourse method

    }

    /**
     * Adds a prerequisite to an existing course in the course
     * list collection.
     *
     * @param code          The subject code of the course
     * @param num           The course number of the course
     * @param prereqCode    The subject code of the prerequisite
     *                      to add to the course
     * @param prereqNum     The course number of the prerequisite
     *                      to add to the course
     * @throws CourseNotFoundException The course was not found in the system
     */
    public void addPrerequisite(SubjectCode code, int num,
                            SubjectCode prereqCode, int prereqNum)
                            throws CourseNotFoundException {

        // TODO: implement addPrerequisite method

    }

    /**
     * Adds a section to the section list collection.
     *
     * @param code       The subject code of the course
     * @param courseNum  The course number of the course
     * @param sectionNum The section number for the course
     * @param firstName  The first name for the faculty teaching the course
     * @param lastName   The last name for the faculty teaching the course
     * @param quarter    The quarter that the course section is held
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     * @throws CourseNotFoundException   The course was not found in the system
     * @throws PersonNotFoundException   The person was not found in the system
     * @throws DuplicateSectionException The section is already in the system
     */
    public void addSection(SubjectCode code, int courseNum, int sectionNum,
                            String firstName, String lastName, Quarter quarter, int year,
                            int cap, Building bldg, int room)
                            throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {


        // TODO: implement addSection method

    }

    /**
     *
     * @return
     */
     public int assignSuId() {
         return ++nextUnassignedSuId;
     }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(generateList("FACULTY", facultyList));
        sb.append(generateList("STUDENT", studentList));
        // TODO: implement printing for course list
        // TODO: implement printing for section list

        return sb.toString();
    }

    /**
     *
     * @return
     */
    private String generateList(String listName, List<?> list) {
        StringBuilder sb = new StringBuilder();

        // list header
        sb.append("-- " + listName + " LIST --\r");

        for (int entry = 0; entry < list.size(); entry++) {
            sb.append(list.get(entry).toString());
        }
// sb.append("\r\r");
        return sb.toString();
    }

    private int nextUnassignedSuId = 100000;

    private List<Faculty> facultyList;
    private List<Student> studentList;
// private List<Course> courseList;
// private List<Section> sectionList;

    // TODO: add RegistrationSystem collections
    // - subject list
    // = course list
    // - section list
    //
    // Note -- there is no list for prerequisites - these should be included
    // as part of the course list

}
