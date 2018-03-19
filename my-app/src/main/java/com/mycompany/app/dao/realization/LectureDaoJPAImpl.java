package com.mycompany.app.dao.realization;

import com.mycompany.app.dao.interfaces.LecturesDao;
import com.mycompany.app.entities.Lecture;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LectureDaoJPAImpl implements LecturesDao {
    @PersistenceContext
    private EntityManager em;

    public Lecture addLecture(Lecture lecture) {
        em.persist(lecture);
        return lecture;
    }

    public Lecture getLecture(int id) {
        return em.find(Lecture.class,id);
    }

    public void saveLecture(Lecture lecture) {
        em.merge(lecture);
    }

    public List<Lecture> getAll()
    {
        Query query = em.createNamedQuery("findAll");
        List<Lecture> lectures = query.getResultList();
        return lectures;
    }

    public List<Lecture> getLectureWithName()
    {
        Query query = em.createNamedQuery("findName");
        List<Lecture> lectures = query.getResultList();
        return lectures;
    }

    public List<Lecture> getLectureByName(String name)
    {
        Query query = em.createNamedQuery("findWithNameParam");
        query.setParameter("fname", name);
        List<Lecture> lectures = query.getResultList();
        return lectures;
    }

    public List<Lecture> getLectureById(int id)
    {
        Query query = em.createNamedQuery("findWithIdParam");
        query.setParameter("fid", id);
        List<Lecture> lectures = query.getResultList();
        return lectures;
    }
}
