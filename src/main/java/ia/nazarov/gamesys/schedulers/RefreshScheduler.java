package ia.nazarov.gamesys.schedulers;

import ia.nazarov.gamesys.services.RefreshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RefreshScheduler {
    private RefreshService refreshService;

    @Autowired
    public RefreshScheduler(RefreshService refreshService) {
        this.refreshService = refreshService;
    }

    // TODO: Just hardcoding delay. It is better to use TaskScheduler to dynamically manage scheduled task
    //@Scheduled(fixedDelay = 60 * 10 * 1000)
    private void refresh() {
        refreshService.refresh();
    }
}
