package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojo.ClazzEntity;
import pojo.StudentEntity;
import util.HibernateUtil;

public class ClassDAO {
    public static ClazzEntity getClassbyId(String student) {
        ClazzEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            int studentId=Integer.parseInt(student);
            sach = (ClazzEntity) session.get(ClazzEntity.class, studentId);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }
}
