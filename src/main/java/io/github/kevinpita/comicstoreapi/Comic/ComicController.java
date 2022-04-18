package io.github.kevinpita.comicstoreapi.Comic;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicController {
    private final ComicService comicService;

    public ComicController(ComicService comicService) {
        this.comicService = comicService;
    }
}
