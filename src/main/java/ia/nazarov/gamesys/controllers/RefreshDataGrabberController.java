package ia.nazarov.gamesys.controllers;

import ia.nazarov.gamesys.models.BasicResponse;
import ia.nazarov.gamesys.repositories.ArticleRepository;
import ia.nazarov.gamesys.services.RefreshService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("grabber")
public class RefreshDataGrabberController
{
    final RefreshService refreshService;
    final ArticleRepository articleRepository;

    @Autowired
    public RefreshDataGrabberController(RefreshService refreshService, ArticleRepository articleRepository) {
        this.refreshService = refreshService;
        this.articleRepository = articleRepository;
    }
    /**
     * Forcibly refresh all sources
     */
    @GetMapping(value = "refresh")
    public ResponseEntity<BasicResponse> refresh() {
        refreshService.refresh();
        articleRepository.findArticleByGUID("");
        return new ResponseEntity<>(new BasicResponse("Request processed successfully"), HttpStatus.OK);
    }
}
