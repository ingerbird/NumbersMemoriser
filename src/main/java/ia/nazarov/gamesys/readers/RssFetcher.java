package ia.nazarov.gamesys.readers;

import com.apptastic.rssreader.Item;
import com.apptastic.rssreader.RssReader;
import ia.nazarov.gamesys.models.Article;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class RssFetcher implements ArticleFetcher {
    @Override
    public List<Article> fetch(String resource) {
        RssReader rssReader = new RssReader();
        Stream<Item> rssFeed = null;
        try {
            rssFeed = rssReader.read(resource);
        } catch (IOException e) {
            log.error(String.format("Exception during getting rss [%s]: %s", resource, e.getMessage()));
            e.printStackTrace();
        }
        if (rssFeed != null) {
            return rssFeed
                    .map(item ->
                            new Article(
                                item.getGuid().isPresent() ? item.getGuid().get() : "",
                                resource,
                                item.getDescription().isPresent() ? item.getDescription().get() : ""
                            )
                    )
                    .filter(article -> !article.getData().isEmpty())
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
