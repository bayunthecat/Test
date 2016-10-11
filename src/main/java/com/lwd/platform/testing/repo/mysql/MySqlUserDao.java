package com.lwd.platform.testing.repo.mysql;

import com.lwd.platform.testing.model.User;
import com.lwd.platform.testing.repo.UserDao;
import com.lwd.platform.testing.util.constant.Const;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

//TODO retarded
@Repository(Const.Bean.USER_DETAILS_SERVICE)
public class MySqlUserDao extends AbstractCrudDao<User> implements UserDao, UserDetailsService {

    @Autowired
    private Session session;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return new CustomUserDetails(read(new User(), Integer.parseInt(id)));
    }

    private class CustomUserDetails implements UserDetails {

        private User user;

        private CustomUserDetails(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public String getUsername() {
            return user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}