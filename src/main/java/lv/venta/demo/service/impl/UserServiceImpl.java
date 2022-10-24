package lv.venta.demo.service.impl;

import java.nio.file.attribute.UserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lv.venta.demo.models.MyUser;
import lv.venta.demo.models.MyUserPrinciple;
import lv.venta.demo.repos.iUserRepo;
import lv.venta.demo.service.iUserService;
@Service
public class UserServiceImpl implements iUserService {

	@Autowired
	iUserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser users = userRepo.findByEmail(username);
		if(users==null) {
			throw new UsernameNotFoundException("User does not exist");
		}
		return new MyUserPrinciple(users);
	}

}
