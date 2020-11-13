package com.pers.guofucheng.pojo;

/**
 * 课程
 *
 * @author guofucheng
 * @date 2020/08/25
 */
public class Course {
    /**
     * 课程id
     */
    private int courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 分数
     */
    private String courseFraction;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseFraction() {
        return courseFraction;
    }

    public void setCourseFraction(String courseFraction) {
        this.courseFraction = courseFraction;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseFraction='" + courseFraction + '\'' +
                '}';
    }
}
