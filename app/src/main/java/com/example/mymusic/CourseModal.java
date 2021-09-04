package com.example.mymusic;

public class CourseModal {

    private  String genere;
    private  String artist;
    // variables for our course
    // name and description.
    private String courseName;
    private String courseDescription;

    // creating constructor for our variables.
    public CourseModal(String courseName, String courseDescription,String genere,String artist) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.genere = genere;
        this.artist = artist;
    }

    // creating getter and setter methods.
    public String getCourseName() {
        return courseName;
    }

    public String getartist() {
        return genere;
    }
    public String getgenere() {
        return artist;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}