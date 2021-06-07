package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import pojo.ClazzEntity;
import pojo.CourseEntity;
import util.HibernateUtil;

public class CourseDAO {
    public static CourseEntity getCoursebyId(String student) {
        CourseEntity sach = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            int studentId = Integer.parseInt(student);
            sach = (CourseEntity) session.get(CourseEntity.class, studentId);
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sach;
    }
}
