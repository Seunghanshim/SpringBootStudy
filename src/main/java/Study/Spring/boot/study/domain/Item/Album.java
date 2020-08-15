package Study.Spring.boot.study.domain.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item{
    private String director;
    private String actor;
}
