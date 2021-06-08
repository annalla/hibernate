package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.StudentEntity;
import pojo.SubjectEntity;
import util.HibernateUtil;

import java.util.List;

public class SubjectDAO {
    public static List<SubjectEntity> getSubjectList() {
        List<SubjectEntity> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from SubjectEntity m";
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
    public static SubjectEntity getSubject(int subjectId) {
        SubjectEntity sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (SubjectEntity) session.get(SubjectEntity.class,subjectId);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }
    public static SubjectEntity getSujectbyID(String id) {
        SubjectEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from SubjectEntity m where m.subjectId =:id";
            Query query = session.createQuery(hql);
            query.setString("id",id);
            st=(SubjectEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }
    public static SubjectEntity getSujectbyName(String name) {
        SubjectEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from SubjectEntity m where m.subjectname =:name";
            Query query = session.createQuery(hql);
            query.setString("name",name);
            st=(SubjectEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean addSubject(SubjectEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.getSujectbyID(sv.getSubjectId()) != null) {
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

    public static boolean updateSubject(SubjectEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.getSubject(sv.getSubId()) == null) {
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

    public static boolean deleteSubject(SubjectEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SubjectDAO.getSubject(sv.getSubId()) == null) {
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
