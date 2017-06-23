package com.hjj.ben.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ben on 6/22/17.
 */

@Repository
public class BaseDao implements IBaseDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Object entity) {
        getSession().saveOrUpdate(entity);
    }

    public void delete(Object entity) {
        getSession().delete(entity);
    }

    public List<?> getAll(Class clazz) {
        String simpleName = clazz.getSimpleName();
        String hql = "from " + clazz.getName() + " " + simpleName;
        return getSession().createQuery(hql).list();
    }

    public Object getById(Integer id, Class clazz) {
        return getSession().get(clazz, id);
    }

    public List<?> getCatalog(Integer novelDetailId, Class clazz) {
        String simpleName = clazz.getSimpleName();
        String noveldetailid = "novelDetailId";
        String resid = simpleName + ".resId";

        String idAndName = "(id, name)";

        String hql = "select new " + clazz.getName() + idAndName +
                     " from " + clazz.getName() + " " + simpleName +
                     " where " + noveldetailid + " = :novelDetailId " +
                     "order by " + resid;
        return getSession().createQuery(hql).setParameter(noveldetailid, novelDetailId).list();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
