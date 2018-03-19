package com.mycompany.app;

import com.mycompany.app.dao.interfaces.LecturesDao;
import com.mycompany.app.entities.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(propagation= Propagation.SUPPORTS, readOnly = true)
public class LecturesWorker {
    @Autowired
    private TransactionTemplate transactionTemplate;
    @Autowired
    LecturesDao lecturesDao;

    public Lecture addLecture(final Lecture lecture){
        transactionTemplate.execute(new TransactionCallback<Void>(){
            public Void doInTransaction(TransactionStatus txStatus){
                try{
                    lecturesDao.addLecture(lecture);
                    System.out.println("Lecture has been added "+lecture);
                }catch (RuntimeException e){
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return lecture;
    }

    @Transactional(propagation=Propagation.REQUIRED, readOnly=true)
    public void saveLecture(Lecture lecture){
        lecturesDao.saveLecture(lecture);
        System.out.println("Lecture has been saved "+lecture);
    }


}

