package ia.nazarov.gamesys.services;

import ia.nazarov.gamesys.enums.FetcherType;
import ia.nazarov.gamesys.models.Article;
import ia.nazarov.gamesys.models.ResourceToGrab;
import ia.nazarov.gamesys.processors.ArticleProcessor;
import ia.nazarov.gamesys.repositories.ArticleRepository;
import ia.nazarov.gamesys.repositories.GrabberResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RefreshServiceImpl implements RefreshService {
    final GrabberResourceRepository grabberResourceRepository;
    final FetchServiceImpl fetchService;
    final ArticleRepository articleRepository;
    final ArticleProcessor articleProcessor;

    @Autowired
    public RefreshServiceImpl(GrabberResourceRepository grabberResourceRepository,
                              FetchServiceImpl fetchService,
                              ArticleRepository articleRepository,
                              ArticleProcessor articleProcessor) {
        this.grabberResourceRepository = grabberResourceRepository;
        this.fetchService = fetchService;
        this.articleRepository = articleRepository;
        this.articleProcessor = articleProcessor;
    }

    @Override
    public void refresh() {
        Set<ResourceToGrab> resourcesToGrabList = grabberResourceRepository.getResourcesToGrab(FetcherType.RSS);
        resourcesToGrabList.stream()
                /*  TODO: by default it will spawn as much threads as many cores the system has minus 1.
                    Consider increasing due to lot of low-latency network IO. Or use custom thread pool (instead of default ForkJoinPool here)
                    -Djava.util.concurrent.ForkJoinPool.common.parallelism=20 (?!) */
                .parallel()
                .forEach(resource -> {
                    Set<Article> newArticles = fetchService.fetchNew(resource);
                    newArticles.forEach(articleRepository::save);
                    newArticles.forEach(articleProcessor::process);
                });
    }
}
