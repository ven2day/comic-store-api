package io.github.kevinpita.comicstoreapi.ComicCopy;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicCopyController {
    private final ComicCopyService comicCopyService;

    public ComicCopyController(ComicCopyService comicCopyService) {
        this.comicCopyService = comicCopyService;
    }
}
