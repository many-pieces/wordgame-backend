package com.manyPieces.wordGame.word;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/word")
public class WordController {
    private final WordService wordService;

    @GetMapping("/verify")
    public void verifyWord(@RequestParam String word) {
        wordService.verifyWord(word);
    }

    @GetMapping("")
    public boolean checkAnswer(@RequestParam String word, @RequestParam String answer) {
        return wordService.checkAnswer(word, answer);
    }
}
