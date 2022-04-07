package io.github.kevinpita.comicstoreapi.Comic;

import io.github.kevinpita.comicstoreapi.Collection.Collection;
import io.github.kevinpita.comicstoreapi.ComicCreator.ComicCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comic", uniqueConstraints = {@UniqueConstraint(name = "comic_collection_issue_number_unique", columnNames = {"collection_id", "issue_number"})})

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

    @OneToMany(mappedBy = "comic")
    private List<ComicCreator> comicCreators;

}
