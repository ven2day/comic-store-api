/* Kevin Pita 2022 */
package io.github.kevinpita.comicstoreapi.comiccreator;

import io.github.kevinpita.comicstoreapi.comic.Comic;
import io.github.kevinpita.comicstoreapi.creator.Creator;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "comic_creator",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "comic_creator_role_creator_comic_unique",
                    columnNames = {"role", "creator_id", "comic_id"})
        })
public class ComicCreator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comic_id")
    private Comic comic;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private Creator creator;

    private String role;
}
