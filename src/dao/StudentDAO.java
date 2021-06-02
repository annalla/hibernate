package dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.StudentEntity;
import util.HibernateUtil;

public class StudentDAO {
    public static StudentEntity getStudentbyId(String student) {
        StudentEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            int studentId=Integer.parseInt(student);
            sach = (StudentEntity) session.get(StudentEntity.class, studentId);
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
            query.setString("username",username);
            st=(StudentEntity) query.uniqueResult();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }
}
