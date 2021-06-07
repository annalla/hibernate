package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.SemesterEntity;
import pojo.SubjectEntity;
import util.HibernateUtil;

import java.util.List;

public class SemesterDAO {
    public static List<SemesterEntity> getSemesterList() {
        List<SemesterEntity> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from SemesterEntity m";
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

    public static SemesterEntity getSemester(int semesterId) {
        SemesterEntity sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SemesterEntity) session.get(SemesterEntity.class, semesterId);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }

    public static SemesterEntity getSemesterbyYearandName(String name, String year) {
        SemesterEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from SemesterEntity m where m.year =:year and m.term=:name";
            Query query = session.createQuery(hql);
            query.setString("year", year);
            query.setString("name", name);
            st = (SemesterEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean addSesmester(SemesterEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.getSemesterbyYearandName(sv.getTerm(), sv.getYear()) != null) {
            return false;
        }
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

    public static boolean updateSemester(SemesterEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.getSemester(sv.getSemesterId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(sv);
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

    public static boolean deleteSemester(SemesterEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SemesterDAO.getSemester(sv.getSemesterId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(sv);
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
