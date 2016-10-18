package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.util.constant.Const;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlUserDao extends AbstractCrudDao<User> implements UserDao {

    @Autowired
    private Session session;

    @Override
    public User getUserByEmail(String email) {
        Criteria criteria = session.createCriteria(User.class)
                .add(Restrictions.eq(Const.Tables.User.USER_EMAIL, email));
        return (User) criteria.uniqueResult();
    }

}