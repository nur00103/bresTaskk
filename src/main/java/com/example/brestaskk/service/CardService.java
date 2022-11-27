package com.example.brestaskk.service;

import com.example.brestaskk.dto.request.CardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.entity.Card;

import java.util.List;

public interface CardService {
    ResponseModel<List<CardResponse>> getAllCard();

    public Card convertToEntity(CardRequest cardRequest);
    public CardResponse convertToResponse(Card card);

    ResponseModel<CardResponse> getCardById(Long cardId);
    public boolean checkCardById(Long cardId);

    ResponseModel<CardResponse> addCard(CardRequest cardRequest);

    public boolean checkAccountById(Long accountId);

    ResponseModel<CardResponse> updateCard(Long cardId, CardRequest cardRequest);

    ResponseModel<CardResponse> deleteCard(Long cardId);
}
