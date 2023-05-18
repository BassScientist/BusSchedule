package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@ManagedBean
@RequestScoped
public class BusScheduleBean implements BusScheduleService, Serializable {

    private String from;
    private String to;
    private List<BusSchedule> schedules;

    public BusScheduleBean() {
        schedules = new ArrayList<>();
    }

    @Override
    public void search() {
        try {
            Configuration cfg = new Configuration().configure();
            SessionFactory factory = cfg.buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();

            String hql = "FROM BusSchedule b WHERE b.originCity = :from AND b.destinationCity = :to";
            List<BusSchedule> results = session.createQuery(hql)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
            
            schedules.clear();
            schedules.addAll(results);
            tx.commit();
            session.close();
        } catch(Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exception: " + e.getMessage()));
        }
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public List<BusSchedule> getSchedules() {
        return schedules;
    }
}




