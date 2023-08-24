package com.manyPieces.wordGame.word;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WordService {
    @Value("${korn.openapi.key}")
    private String KornDictKey;
    @Value("${naver.clientId}")
    private String ClientId;
    @Value("${naver.clientSecret}")
    private String ClientSecret;

    /**
     * 단어검증(1)
     * 표준국립국어원 Api를 사용하여 단어의 존재여부 확인
     */
    public boolean verifyWord(String word) {
        String KornDictBaseUrl = "https://stdict.korean.go.kr/api/search.do";

        WebClient webClient = WebClient.builder()
                .baseUrl(KornDictBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        KornResponseDto response = webClient.get()
                .uri(uri -> uri.queryParam("key", KornDictKey)
                        .queryParam("q", word)
                        .queryParam("req_type", "json").build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                // TODO : DTO로 변경 예정
                 .bodyToMono(KornResponseDto.class)
//                .bodyToMono(String.class)
                .block();
        System.out.println("response.toString() = " + response.toString());
        return response != null;
    }

//    /**
//     * 단어검증(2)
//     * 네이버 백과사전 Api를 사용하여 단어의 존재여부 확인
//     */
//    public void verifyWord(String word) {
//        String NaverDictBaseUrl = "https://openapi.naver.com/v1/search/encyc.json";
//        WebClient webClient = WebClient.builder()
//                .baseUrl(NaverDictBaseUrl)
//                .defaultHeaders(header ->
//                        {
//                            header.add("X-Naver-Client-Id", ClientId);
//                            header.add("X-Naver-Client-Secret", ClientSecret);
//                        }
//                )
//                .build();
//
//        String response = webClient.get()
//                .uri(uri -> uri.queryParam("query", word).build())
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//
//        System.out.println("response = " + response);
//    }

    public boolean checkAnswer(String word, String answer) {
        char wordLst = word.charAt(word.length() - 1);
        char answerFst = answer.charAt(0);

        boolean isExistWord = verifyWord(answer);
        return wordLst == answerFst && isExistWord;
    }
}
