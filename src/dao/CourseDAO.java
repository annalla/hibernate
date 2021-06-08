package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.ClazzEntity;
import pojo.CourseEntity;
import pojo.SubjectEntity;
import util.HibernateUtil;

public class CourseDAO {
    public static CourseEntity getCoursebyId(int id) {
        CourseEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            //int studentId = Integer.parseInt(student);
            sach = (CourseEntity) session.get(CourseEntity.class, id);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }
    public static CourseEntity getCoursebyClass(String cl) {
        CourseEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from CourseEntity m where m.coursename =:cl";
            Query query = session.createQuery(hql);
            query.setString("cl",cl);
            st=(CourseEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }
    public static boolean deleteCourse(CourseEntity co) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CourseDAO.getCoursebyId(co.getCourseId())==null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(co);
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
    public static boolean addCourse(CourseEntity co) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (CourseDAO.getCoursebyClass(co.getCoursename())!=null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(co);
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
