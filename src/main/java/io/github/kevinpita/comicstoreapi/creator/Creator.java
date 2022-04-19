/* Kevin Pita 2022 */
package io.github.kevinpita.comicstoreapi.creator;

import io.github.kevinpita.comicstoreapi.comiccreator.ComicCreator;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "creator",
        uniqueConstraints = {
            @UniqueConstraint(name = "creator_full_name_unique", columnNames = "full_name")
        })
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<ComicCreator> comicCreators;
}
