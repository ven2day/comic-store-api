package io.github.kevinpita.comicstoreapi.Collection;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collection")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public List<Collection> getCollections() {
        return collectionService.getCollections();
    }

    // get by id
    @GetMapping("/{id}")
    public Collection getCollection(@PathVariable Long id) {
        return collectionService.getCollection(id);
    }

    @PostMapping
    public Collection createCollection(Collection collection) {
        return collectionService.createCollection(collection);
    }
}
