package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * <p>The <strong>Section</strong> class holds information about a course section.</p>
 * <ul>
 * <li><strong>course:</strong> course associated with the section</li>
 * <li><strong>section:</strong> section number for the course</li>
 * <li><strong>instructor:</strong> instructor for the section (assume single instructor)</li>
 * <li><strong>term:</strong> quarter and year when the section is offered (see Quarter enum)</li>
 * <li><strong>capacity:</strong> capacity for the section</li>
 * <li><strong>location:</strong> building and room where the section is held (see Building enum)</li>
 * </ul>
 * <p>For example, <strong>CPSC 5011-02: Object-Oriented Concepts</strong>
 * <ul>
 * <li><strong>course:</strong> CPSC 5011</li>
 * <li><strong>section:</strong> 02</li>
 * <li><strong>instructor:</strong> Sheila Oh</li>
 * <li><strong>term (quarter/year):</strong> FQ18</li>
 * <li><strong>capacity:</strong> 30</li>
 * <li><strong>location (building/room):</strong> LEML 122</li>
 * </ul>
 *
 * @author
 */
public class Section {

    /**
     *
     * @param course     The course associated with the section
     * @param section    The section number for the course
     * @param instructor The faculty instructor teaching the course
     * @param quarter    The quarter that the course section is held
     * @param year       The year that the course section is held
     * @param cap        The capacity of the course section
     * @param bldg       The building that the course section is held
     * @param room       The room that the course section is held
     */
    public Section(Course course, int section, Faculty instructor, Quarter quarter,
                    int year, int cap, Building bldg, int room) {

        // TODO: implement Section constructor
        this.courseSubjectCodeNum = course.getCourseSubjectCodeNum();
        this.section = section;
        this.courseName = course.getCourseName() == null ? "___COURSE_NAME_PLACEHOLDER___" : course.getCourseName();
// this.instructor = instructor;
// this.quarter = quarter;
// this.year = year
// this.cap = cap;
// this.bldg = bldg;
// this.room = room;
    }

    // private Faculty instructor;
	@Override
	public String toString() {
		return "Section: Course=" + courseSubjectCodeNum +
		"-0" + section +
		": " + courseName +
		"\r";
	}

    // TODO: add Section fields including:
	private String courseName;
	private String courseSubjectCodeNum;
    private int section;

// hardcode

// - term (see Quarter)
//     private Quarter quarter;
//     private int year;
//
//     private int cap;
//
// // - location (see Building)
//     private Building bldg;
//     private int room;


}
