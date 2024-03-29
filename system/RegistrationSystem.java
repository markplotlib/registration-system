package system;

import registration.Course;
import registration.Section;
import person.Faculty;
import person.Student;
import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.StudentYear;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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

        // SU ID generator: always incrementing a new SU ID
        // for each newly constructed person
        suIdCounter = 100000;

        // initialize collections
        facultyList = new ArrayList<Faculty>();
        studentList = new ArrayList<Student>();
        subjectMap = new HashMap<String, SubjectCode>();
        courseList = new ArrayList<Course>();
        sectionList = new ArrayList<Section>();
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

        studentList.add(new Student(firstName, lastName, generateSuId(), type,
                                    program, quarter, year));

        // match students to advisors
        matchAdvisors(facultyList, studentList);

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
                            FacultyType type, Building bldg, int room,
                            String email) throws DuplicatePersonException {
        facultyList.add(new Faculty(firstName, lastName, generateSuId(), type,
                        bldg, room, email));
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

        subjectMap.put(desc, code);
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

        courseList.add(new Course(code, num, name, creditNum));

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

		Course course = new Course(code, num);

        boolean courseFound = false;
        for (int courseNum = 0; courseNum < courseList.size(); courseNum++) {
            Course c = courseList.get(courseNum);
            if (c.equals(course)) {
                c.addPrereq(prereqCode, prereqNum);
                courseFound = true;
            }
        }
        if (!courseFound)
            throw new CourseNotFoundException();
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

        Course course = new Course(code, courseNum, null, room);
        for (int i = 0; i < courseList.size(); i++) {
            Course c = courseList.get(i);
            if (c.equals(course)) {
                course.setCourseName(c.getCourseName());
            }
        }

        Faculty faculty = new Faculty(firstName, lastName);

        sectionList.add(new Section(course, sectionNum, faculty, quarter, year,
                                    cap, bldg, room));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(generateStringFromList("FACULTY", facultyList));
        sb.append(generateStringFromList("STUDENT", studentList));
        sb.append(generateStringFromMap("SUBJECT", subjectMap));
        sb.append(generateStringFromList("COURSE", courseList));
        sb.append(generateStringFromList("SECTION", sectionList));

        return sb.toString();
    }

    /**
     * generates a screen display of list objects
     * @param 	listName  name of list to be displayed
     * @param 	list      list object
     * @return   screen display of list objects
     */
    private String generateStringFromList(String listName, List<?> list) {
        StringBuilder sb = new StringBuilder();

        // list header
        sb.append("-- " + listName + " LIST --\r");

        for (int entry = 0; entry < list.size(); entry++) {
            sb.append(list.get(entry).toString());
        }
        sb.append("\r\r");
        return sb.toString();
    }

    /**
     * generates a screen display of map objects
     * @param 	mapName  name of map to be displayed
     * @param 	map      map object
     * @return   screen display of map objects
     */
    private String generateStringFromMap(String mapName, Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();

        // list header
        sb.append("-- " + mapName + " LIST --\r");

        for (Entry<?, ?> entry : map.entrySet()) {
            sb.append("Subject: " + entry.getKey() +
            		  " (" + entry.getValue() + ")\r");
        }

        sb.append("\r\r");
        return sb.toString();
    }

    /**
     * Generate an SU ID for each newly created person
     * @return  unique SU ID
     */
    private int generateSuId() {
        ++suIdCounter;
        return suIdCounter;
    }

    /**
     * Arbitrarily match faculty advisors to all students
     */
    private void matchAdvisors(List<Faculty> facultyList,
                              List<Student> studentList) {
        Faculty advisor;
        int facultyNum;
        for (int student = 0; student < studentList.size(); student++) {
            facultyNum = student % facultyList.size();
            advisor = facultyList.get(facultyNum);
            studentList.get(student).assign(advisor);
        }
    }

    // Registration System collections
    private List<Faculty> facultyList;
    private List<Student> studentList;
    private Map<String, SubjectCode> subjectMap;
    private List<Course> courseList;
    private List<Section> sectionList;
    // SU ID generator
    private int suIdCounter;

}
