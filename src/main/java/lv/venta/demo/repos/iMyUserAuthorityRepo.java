package lv.venta.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import lv.venta.demo.models.MyUserAuthority;

public interface iMyUserAuthorityRepo extends JpaRepository<MyUserAuthority, Long> {

}
