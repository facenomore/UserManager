package net.facenomore.UserManager.dao;

import net.facenomore.UserManager.model.Page;
import net.facenomore.UserManager.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createCriteria(User.class).list();

        for (User user : userList) logger.info("User list: " + user);

        return userList;
    }

    @Override
    @Transactional
    public void addOrUpdateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        logger.info("Update User: " + user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user != null) {
            session.delete(user);
            session.flush();
        }

        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }

    @Override
    @Transactional
    public Page getPage(int pageNumber, int pageSize, String sortType, String sortField,  String nameFilter, Integer ageMoreFilter, Integer ageLessFilter, Boolean isAdminFilter) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(User.class);
        if (nameFilter != null) {
            criteria.add(Restrictions.like("name", nameFilter, MatchMode.ANYWHERE));
        }
        if (isAdminFilter != null) {
            criteria.add(Restrictions.eq("isAdmin", isAdminFilter));
        }
        if (ageMoreFilter != null) {
            criteria.add(Restrictions.gt("age", ageMoreFilter));
        }
        if (ageLessFilter != null) {
            criteria.add(Restrictions.lt("age", ageLessFilter));
        }
        if ((sortType != null) && (sortField != null)) {
            switch (sortType) {
                case "asc" : criteria.addOrder(Order.asc(sortField));
                    break;
                case "desc" : criteria.addOrder(Order.desc(sortField));
                    break;
            }
        }
        int count = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        criteria.setProjection(null);
        List<User> users = criteria.setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
        return new Page(count, users);
    }

}