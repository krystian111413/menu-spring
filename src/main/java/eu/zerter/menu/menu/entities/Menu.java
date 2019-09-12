package eu.zerter.menu.menu.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("menu")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Menu {
    @Id
    private String id;
    private String name;
    private Date createdOn;
}
