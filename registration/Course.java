package registration;

import enums.SubjectCode;
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
     *
     * @param code      The subject code of the course
     * @param courseNum The course number of the course
     * @param name      The course name
     * @param creditNum The number of the credits of the course
     */
     public Course(SubjectCode code, int courseNum, String name,
                     int creditNum) {

        // TODO: implement Course constructor
    	this.code = code;
    	this.courseNum = courseNum;
    	this.name = name;
    	this.creditNum = creditNum;
    }

    /**
     *
     * @return
     */
    public String getCourse() {
        return code + "-" + courseNum;
    }

    /**
     *
     * @return
     */
    public String getCourseName() {
        return name;
    }


    @Override
    public String toString() {
        return "Course: Name=" + getCourse() +
        ": " + name +
        ", Credits=" + creditNum +
// ", Prerequisites=[]" +
        "\r";
    }

    private SubjectCode code;
    private int courseNum;
    private String name;
    private int creditNum;
    // private List prerequisites;

    // TODO: add Course fields
    // - subject code (see SubjectCode)
    // - a collection of prerequisite course(s)

}
