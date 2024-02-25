package restaurant.back.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import restaurant.back.models.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long>{

}
