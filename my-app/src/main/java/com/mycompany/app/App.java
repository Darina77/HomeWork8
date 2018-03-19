package com.mycompany.app;


import com.mycompany.app.entities.*;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

        Lecture lecture = new Lecture();
        lecture.setName("Name");
        lecture.setCredits(2.5);
        LecturesWorker worker1 = (LecturesWorker)context.getBean("worker1");
        worker1.addLecture(lecture);
        worker1.saveLecture(lecture);
    }

}
