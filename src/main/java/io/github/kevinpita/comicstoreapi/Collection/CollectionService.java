package io.github.kevinpita.comicstoreapi.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public Collection createCollection(Collection collection) {
        if (collection.getPublisher() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        }
        return collectionRepository.save(collection);
    }

    public Collection getCollection(Long id) {
        return collectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Collection Not Found"));
    }

    public Collection updateCollection(Collection collection) {
        return collectionRepository.save(collection);
    }

    public List<Collection> getCollections() {
        return collectionRepository.findAll();
    }
}