package io.github.kevinpita.comicstoreapi.ComicCreator;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicCreatorController {
    private final ComicCreatorService comicCreatorService;

    public ComicCreatorController(ComicCreatorService comicCreatorService) {
        this.comicCreatorService = comicCreatorService;
    }
}
