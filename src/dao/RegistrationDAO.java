package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import pojo.RegistrationEntity;
import pojo.StudentEntity;
import util.HibernateUtil;

import java.util.List;

public class RegistrationDAO {
    /*public static List<RegistrationEntity> getRegistrationbyIdStudent(String id) {
        List<RegistrationEntity> st = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            int idR=Integer.parseInt(id);
            String hql = "select m from RegistrationEntity m where m.student.studentId:=id";
            Query query = session.createQuery(hql);
            query.setInteger("id",idR);
            st=query.list();
        } catch (HibernateException ex) {
//Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return st;
    }*/
}
