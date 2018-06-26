package javaschool.dao.impl;

import javaschool.dao.api.UserDAO;
import javaschool.entity.User;
import javaschool.entity.User_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends GenericAbstractDAO<User, Integer> implements UserDAO {
    @Override
    public User findByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> userRoot = query.from(User.class);
        Predicate usernameEqual = builder.equal(userRoot.get(User_.username), username);

        return entityManager.createQuery(query.select(userRoot).where(usernameEqual)).getSingleResult();
    }
}
