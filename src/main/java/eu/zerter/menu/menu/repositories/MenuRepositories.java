package eu.zerter.menu.menu.repositories;

import eu.zerter.menu.menu.entities.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepositories extends MongoRepository<Menu, String> {
}
