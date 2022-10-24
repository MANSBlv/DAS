package lv.venta.demo.repos;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;


import lv.venta.demo.models.MyUser;

public interface iUserRepo extends JpaRepository<MyUser, Long> {
	MyUser findByEmail(String username);

	boolean existsByEmail(@NotNull String email);
}
