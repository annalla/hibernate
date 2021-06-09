package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.ClazzEntity;
import util.HibernateUtil;

import java.util.List;

public class ClassDAO {
    public static List<ClazzEntity> getClassList() {
        List<ClazzEntity> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from ClazzEntity m";
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

    public static ClazzEntity getClassbyId(int id) {
        ClazzEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            //int studentId=Integer.parseInt(student);
            sach = (ClazzEntity) session.get(ClazzEntity.class, id);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }

    public static ClazzEntity getClassbyClassname(String username) {
        ClazzEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from ClazzEntity m where m.classname =:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            st = (ClazzEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean addClass(ClazzEntity cl) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassDAO.getClassbyClassname(cl.getClassname()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cl);
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

    public static boolean deleteClass(ClazzEntity cl) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (ClassDAO.getClassbyId(cl.getClassId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(cl);
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
