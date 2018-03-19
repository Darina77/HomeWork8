package com.mycompany.app.entities;

import javax.persistence.*;

@Entity
@Table(name="lectures")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "findAll", query="select l from Lecture l"),
        @NamedQuery(name = "findName", query="select l from Lecture l where l.name = 'Name'"),
        @NamedQuery(name = "findWithNameParam", query="select l from Lecture l where l.name = :fname"),
        @NamedQuery(name = "findWithIdParam", query="select l from Lecture l where l.id = :fid")
})
public class Lecture
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    @Column(name = "name", length = 45, nullable = false)
    private String name;
    @Column(name = "credits")
    private double credits;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public boolean equals(Object o)
    {
        if(o == null) return false;
        if(this == o) return true;
        else if(o.getClass() == this.getClass())
        {
           if(this.id == ((Lecture) o).id) return true;
        }
        return false;
    }

    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + this.getId();
        return result;
    }

    public String toString()
    {
        return ("" + id + " " + name + " " + credits);
    }
}

