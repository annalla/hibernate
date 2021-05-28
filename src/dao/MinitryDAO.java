package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.MinitryEntity;
import util.HibernateUtil;

import java.util.List;

public class MinitryDAO {
    public static List<MinitryEntity> getMinitryList() {
        List<MinitryEntity> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from MinitryEntity m";
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
    public static MinitryEntity getInforMinitry(String minitryId) {
        MinitryEntity sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            sv = (MinitryEntity) session.get(MinitryEntity.class,minitryId);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sv;
    }
    public static boolean addMinitry(MinitryEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MinitryDAO.getInforMinitry(sv.getUsername())!=null) {
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
    public static boolean updateMinitry(MinitryEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MinitryDAO.getInforMinitry(sv.getUsername()) == null) {
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
    public static boolean deleteMinitry(MinitryEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MinitryDAO.getInforMinitry(sv.getUsername()) == null) {
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

