package com.xyzbank.auth;

import com.xyzbank.model.Customer;
import com.xyzbank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerDetailsManager implements UserDetailsService {

    @Autowired
    private CustomerRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customer = repository.findByEmail(username);

        if (customer.size() == 0) {
            throw new UsernameNotFoundException("User : "+ username + " not found");
        }

        String email = customer.get(0).getEmail();
        String password = customer.get(0).getPwd();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));

        return new User(email, password, authorities);
    }
}
