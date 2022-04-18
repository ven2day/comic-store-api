package io.github.kevinpita.comicstoreapi.Collection;

import io.github.kevinpita.comicstoreapi.Comic.Comic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "collection", uniqueConstraints = {@UniqueConstraint(name = "collection_name_unique", columnNames = "name")})
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(nullable = false)
    private String publisher;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
    private List<Comic> comics;
}
