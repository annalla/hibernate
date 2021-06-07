package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.MinitryEntity;
import pojo.StudentEntity;
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

    public static MinitryEntity getMinitrybyUsername(String username) {
        MinitryEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from MinitryEntity m where m.username =:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            st = (MinitryEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static MinitryEntity getInforMinitry(int minitryId) {
        MinitryEntity sv = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //int minitry=Integer.parseInt(minitryId);
            sv = (MinitryEntity) session.get(MinitryEntity.class, minitryId);
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
        if (MinitryDAO.getMinitrybyUsername(sv.getUsername()) != null) {
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
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean updateMinitry(MinitryEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MinitryDAO.getInforMinitry(sv.getMinitryId()) == null) {
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
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    public static boolean deleteMinitry(MinitryEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MinitryDAO.getInforMinitry(sv.getMinitryId()) == null) {
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
            return false;
        } finally {
            session.close();
        }
        return true;
    }
}

