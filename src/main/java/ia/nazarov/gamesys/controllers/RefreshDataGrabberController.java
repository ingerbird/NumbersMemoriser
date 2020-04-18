package ia.nazarov.gamesys.controllers;

import ia.nazarov.gamesys.enums.FetcherType;
import ia.nazarov.gamesys.models.ResourceToGrab;
import ia.nazarov.gamesys.repositories.GrabberResourceRepository;
import ia.nazarov.gamesys.services.FetchServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping("grabber")
public class RefreshDataGrabberController
{
    private GrabberResourceRepository grabberResourceRepository;
    private FetchServiceImpl fetchService;

    @Autowired
    public RefreshDataGrabberController(GrabberResourceRepository grabberResourceRepository,
                                        FetchServiceImpl fetchService) {
        this.grabberResourceRepository = grabberResourceRepository;
    }
    /**
     * Forcibly refresh all data grabber sources
     */
    @GetMapping(value = "refresh")
    public void refresh() {
        Set<ResourceToGrab> resourcesToGrabList = grabberResourceRepository.getResourcesToGrab(FetcherType.RSS);
        resourcesToGrabList.stream()
                /*  TODO: by default it will spawn as much threads as many cores the system has minus 1.
                    Should be increased in parameters because of the specific of low-latency network IO
                    -Djava.util.concurrent.ForkJoinPool.common.parallelism=20 (?!) */
                .parallel()
                .forEach(fetchService::fetchNew);
        System.out.println("Hello");
    }
}
