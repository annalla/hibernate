package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.RegistrationsessionEntity;
import pojo.SemesterEntity;
import util.HibernateUtil;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class RegistrationSessionDAO {
    public static List<RegistrationsessionEntity> getRegistrationSessionList() {
        List<RegistrationsessionEntity>ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from RegistrationsessionEntity m";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }


    public static boolean addRegistrationSession(RegistrationsessionEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sv);
            transaction.commit();
        } catch (HibernateException ex) {
//Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
