package registration;

import enums.SubjectCode;
import exception.CourseNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>The <strong>Course</strong> class holds information about a course.</p>
 * <ul>
 * <li><strong>subject code:</strong> subject code of the course (see SubjectCode enum)</li>
 * <li><strong>course number:</strong> course number</li>
 * <li><strong>course name:</strong> course name</li>
 * <li><strong>credit number:</strong> number of credits associated with the course</li>
 * <li><strong>prerequisites:</strong> courses that are prerequisites of this course; may
 *   have multiple or none</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011: Object-Oriented Concepts</strong></p>
 * <ul>
 * <li><strong>subject code:</strong> CPSC</li>
 * <li><strong>course number:</strong> 5011</li>
 * <li><strong>course name:</strong> Object-Oriented Concepts</li>
 * <li><strong>credit number:</strong> 3</li>
 * <li><strong>prerequisite(s):</strong> CPSC 5003</li>
 * </ul>
 *
 * @author
 */
public class Course {

    /**
     * Constructor for creating a new course
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
     public Course(SubjectCode code, int courseNum, String name,
                     int creditNum) {

    	this.code = code;
    	this.courseNum = courseNum;
    	this.name = name;
    	this.creditNum = creditNum;
        this.prerequisites = new ArrayList<>();
    }

    /**
     * Constructor for a course
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     */
    public Course(SubjectCode code, int courseNum) {
    	this.code = code;
    	this.courseNum = courseNum;
    }

    /**
     * Adds a prereq to a course
     * @param prereqCode      The subject code of the prereq
     * @param prereqNum       The course number of the prereq
     */
    public void addPrereq(SubjectCode prereqCode, int prereqNum)
                                throws CourseNotFoundException {

    	Course course = new Course(prereqCode, prereqNum);
        prerequisites.add(course);
    }

    /**
     * Gets course subject code and course number
     * @return      subject code and course number
     */
    public String getCourseSubjectCodeNum() {
        return code + "-" + courseNum;
    }

    /**
     * Gets course number
     * @return      course number
     */
    public int getCourseNum() {
        return courseNum;
    }

    /**
     * Gets course name
     * @return  course name
     */
    public String getCourseName() {
        return name;
    }

    /**
     * Sets course name
     * @param  course name
     */
    public void setCourseName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course: Name=" + getCourseSubjectCodeNum() +
        ": " + name +
        ", Credits=" + creditNum +
        ", Prerequisites=[" + getAllPrerequisites() + "]" + "\r";
    }

    /**
     *
     * @param other
     * @return
     */
    public boolean equals(Course other) {
    	return (this.courseNum == other.courseNum);
    }

    private String getAllPrerequisites() {
        StringBuilder sb = new StringBuilder();
        if (prerequisites != null) {
            for (int prereq = 0; prereq < prerequisites.size(); prereq++) {
            	sb.append(prerequisites.get(prereq).getPrereqFormat());
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private String getPrereqFormat() {
        return "Name=" + getCourseSubjectCodeNum();
    }

    private SubjectCode code;
    private int courseNum;
    private String name;
    private int creditNum;
    private List<Course> prerequisites;
}
