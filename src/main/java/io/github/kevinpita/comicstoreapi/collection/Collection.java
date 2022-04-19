package io.github.kevinpita.comicstoreapi.collection;

import io.github.kevinpita.comicstoreapi.comic.Comic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String publisher;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
    private List<Comic> comics;
}
