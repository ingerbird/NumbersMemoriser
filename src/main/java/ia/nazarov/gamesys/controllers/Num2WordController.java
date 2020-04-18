package ia.nazarov.gamesys.controllers;

import ia.nazarov.gamesys.models.Num2WordResponse;
import ia.nazarov.gamesys.services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("num2word")
public class Num2WordController {
    final WordsService wordsService;

    @Autowired
    public Num2WordController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @GetMapping("query")
    public ResponseEntity<Num2WordResponse> queryWordByNum(@RequestParam String num) {
        return new ResponseEntity<>(
                new Num2WordResponse("Request successfully processed",
                        wordsService.findWordsByNum(num)),
                HttpStatus.OK);
    }
}
