package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pojo.ClazzEntity;
import pojo.RegistrationEntity;
import pojo.StudentEntity;
import util.HibernateUtil;

import java.util.List;

public class RegistrationDAO {
    public static List<RegistrationEntity>listRegistration(String username,int semester){
        List<RegistrationEntity> ds=null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from RegistrationEntity m where m.course.semester.semesterId =:semester and m.student.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            query.setInteger("semester", semester);
            ds=query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    public static RegistrationEntity getRegistbyId(int id) {
        RegistrationEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            //int studentId=Integer.parseInt(student);
            sach = (RegistrationEntity) session.get(RegistrationEntity.class, id);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }

    public static RegistrationEntity getRegistByCourseAndUser(String username,int course) {
        RegistrationEntity st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select m from RegistrationEntity m where m.course.courseId =:course and m.student.username=:username";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            query.setInteger("course", course);
            st = (RegistrationEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }

    public static boolean addRegistration(RegistrationEntity re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistrationDAO.getRegistByCourseAndUser(re.getStudent().getUsername(),re.getCourse().getCourseId()) != null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(re);
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
    public  static  boolean checkisOk(String username,int day, int period){
        RegistrationEntity st = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //System.out.println(username+String.valueOf(day)+String.valueOf(period));
            String hql = "select m from RegistrationEntity m where m.student.username=:username and m.course.day=:day and m.course.period=:period";
            Query query = session.createQuery(hql);
            query.setString("username", username);
            query.setInteger("day", day);
            query.setInteger("period", period);
            st = (RegistrationEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        if(st==null){
            return true;
        }
        return false;
    }
    public static boolean deleteRegistration(RegistrationEntity re) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (RegistrationDAO.getRegistByCourseAndUser(re.getStudent().getUsername(),re.getCourse().getCourseId()) == null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(re);
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
