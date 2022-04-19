/* Kevin Pita 2022 */
package io.github.kevinpita.comicstoreapi.comic;

import io.github.kevinpita.comicstoreapi.collection.Collection;
import io.github.kevinpita.comicstoreapi.comiccopy.ComicCopy;
import io.github.kevinpita.comicstoreapi.comiccreator.ComicCreator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
        name = "comic",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "comic_collection_issue_number_unique",
                    columnNames = {"collection_id", "issue_number"})
        })
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(name = "issue_number")
    private int issueNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @OneToMany(mappedBy = "comic", fetch = FetchType.LAZY)
    private List<ComicCreator> comicCreators;

    @OneToMany(mappedBy = "comic", fetch = FetchType.LAZY)
    private List<ComicCopy> copies;
}
