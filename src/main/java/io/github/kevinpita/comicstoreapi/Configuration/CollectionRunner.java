package io.github.kevinpita.comicstoreapi.Configuration;

import io.github.kevinpita.comicstoreapi.Collection.Collection;
import io.github.kevinpita.comicstoreapi.Collection.CollectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CollectionRunner implements CommandLineRunner {
    private final CollectionRepository repository;

    public CollectionRunner(CollectionRepository collectionRepository) {
        this.repository = collectionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        repository.save(new Collection(null, "abc", "Marvel", "Marvel Comics", null));

    }
}
