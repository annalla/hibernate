package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.MinitryEntity;
import pojo.StudentEntity;
import util.HibernateUtil;

import java.util.List;

public class StudentDAO {

    public static List<StudentEntity> getStudentList() {
        List<StudentEntity> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select m from StudentEntity m";
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

    public static StudentEntity getStudentbyId(int student) {
        StudentEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            //int studentId=Integer.parseInt(student);
            sach = (StudentEntity) session.get(StudentEntity.class, student);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }

    public static StudentEntity getStudentbyUsername(String username) {
        StudentEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from StudentEntity m where m.username =:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            st = (StudentEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean updateStudent(StudentEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.getStudentbyId(sv.getStudentId()) == null) {
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

    public static boolean deleteStudent(StudentEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.getStudentbyId(sv.getStudentId()) == null) {
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

    public static boolean addStudent(StudentEntity sv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (StudentDAO.getStudentbyUsername(sv.getUsername()) != null) {
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
}
