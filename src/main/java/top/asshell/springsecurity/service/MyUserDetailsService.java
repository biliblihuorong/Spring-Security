package top.asshell.springsecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import top.asshell.springsecurity.DAO.UsersDAO;
import top.asshell.springsecurity.entity.Users;

import java.util.List;

@Service("UserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UsersDAO usersDAO;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        LambdaQueryWrapper<Users> wrapper =new LambdaQueryWrapper<>();
        wrapper.eq(Users::getUserName,name);
        Users users = usersDAO.selectOne(wrapper);
        if (users==null)
            new UsernameNotFoundException("账号有问题");
        List<GrantedAuthority> authorities= AuthorityUtils.commaSeparatedStringToAuthorityList("role");

        return new User("shell",new BCryptPasswordEncoder().encode(users.getPasswd()),authorities);
    }
}
