package siamese.todolist.model.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data //@Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String task;

    @Column
    Integer status;

    @Column
    String createTime;

    @Column
    String updateTime;
}
