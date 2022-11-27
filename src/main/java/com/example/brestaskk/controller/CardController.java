package com.example.brestaskk.controller;

import com.example.brestaskk.dto.request.CardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public ResponseModel<List<CardResponse>> getAllCard(){
        return cardService.getAllCard();
    }
    @GetMapping("/{cardId}")
    public ResponseModel<CardResponse> getCardById(@PathVariable Long cardId){
        return cardService.getCardById(cardId);
    }
    @PostMapping("/add")
    public ResponseModel<CardResponse> addCard(@RequestBody @Valid CardRequest cardRequest){
        return cardService.addCard(cardRequest);
    }
    @PatchMapping("/{cardId}")
    public ResponseModel<CardResponse>updateCard(@PathVariable Long cardId,@Valid @RequestBody CardRequest cardRequest){
        return cardService.updateCard(cardId,cardRequest);
    }
    @DeleteMapping("/{cardId}")
    public ResponseModel<CardResponse> deleteCard(@PathVariable Long cardId){
        return cardService.deleteCard(cardId);
    }

}
