package com.mycompany.app.dao.interfaces;

import com.mycompany.app.entities.Lecture;

import java.util.List;

public interface LecturesDao {
    Lecture addLecture(Lecture lecture);
    Lecture getLecture(int id);
    void saveLecture(Lecture lecture);
    List<Lecture> getAll();
    List<Lecture> getLectureWithName();
    List<Lecture> getLectureByName(String name);
    List<Lecture> getLectureById(int id);
}

