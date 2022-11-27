package com.example.brestaskk.service.impl;

import com.example.brestaskk.dto.request.CardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.entity.Account;
import com.example.brestaskk.entity.Card;
import com.example.brestaskk.enums.EnumStatus;
import com.example.brestaskk.enums.ExceptionEnum;
import com.example.brestaskk.exception.MyException;
import com.example.brestaskk.repository.AccountRepository;
import com.example.brestaskk.repository.CardRepository;
import com.example.brestaskk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private static final Long THREE_YEARS = (long) (3 * 365 * 24 * 60 * 60);
    private final CardRepository cardRepository;
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;
    @Override
    public ResponseModel<List<CardResponse>> getAllCard() {
        List<Card> cardList=cardRepository.findAllByActive(EnumStatus.ONLINE.getCode());
        if (cardList.isEmpty()){
            throw new MyException(ExceptionEnum.CARD_NOT_FOUND);
        }
        List<CardResponse> cardResponseList=cardList.stream().map(card -> convertToResponse(card)).collect(Collectors.toList());
        return ResponseModel.<List<CardResponse>>builder().result(cardResponseList).status(ExceptionEnum.SUCCESS.getMessage())
                .code(ExceptionEnum.SUCCESS.getCode()).error(false).build();
    }

    @Override
    public Card convertToEntity(CardRequest cardRequest) {
        Card card=modelMapper.map(cardRequest,Card.class);
        return card;
    }

    @Override
    public CardResponse convertToResponse(Card card) {
        CardResponse cardResponse=modelMapper.map(card,CardResponse.class);
        return cardResponse;
    }

    @Override
    public ResponseModel<CardResponse> getCardById(Long cardId) {
        checkCardById(cardId);
        Card card=cardRepository.findByIdAndActive(cardId,EnumStatus.ONLINE.getCode()).get();
        CardResponse cardResponse=convertToResponse(card);
        return ResponseModel.<CardResponse>builder().result(cardResponse).status(ExceptionEnum.SUCCESS.getMessage())
                .code(ExceptionEnum.SUCCESS.getCode()).error(false).build();
    }

    @Override
    public boolean checkCardById(Long cardId) {
        Card card=cardRepository.findByIdAndActive(cardId,EnumStatus.ONLINE.getCode())
                .orElseThrow(()->new MyException(ExceptionEnum.CARD_NOT_FOUND));
        return true;
    }

    @Override
    public ResponseModel<CardResponse> addCard(CardRequest cardRequest) {
        Card card=convertToEntity(cardRequest);
        checkAccountById(cardRequest.getAccountId());
        Account account=accountRepository.findByIdAndActive(cardRequest.getAccountId(),EnumStatus.ONLINE.getCode()).get();
        if (cardRequest.getBalance().compareTo(account.getBalance())==1){
            throw new MyException(ExceptionEnum.BALANCE_NOT_FOUND);
        }
        card.setExpireDate(Date.from(Instant.now().plusSeconds(THREE_YEARS)));
        Card savedCard=cardRepository.save(card);
        CardResponse cardResponse=convertToResponse(savedCard);
        return ResponseModel.<CardResponse>builder().result(cardResponse).status(ExceptionEnum.SUCCESS.getMessage())
                .code(ExceptionEnum.SUCCESS.getCode()).error(false).build();
    }

    @Override
    public boolean checkAccountById(Long accountId) {
        Account account=accountRepository.findByIdAndActive(accountId,EnumStatus.ONLINE.getCode())
                .orElseThrow(()->new MyException(ExceptionEnum.ACCOUNT_NOT_FOUND));
        return true;
    }

    @Override
    public ResponseModel<CardResponse> updateCard(Long cardId, CardRequest cardRequest) {
        checkCardById(cardId);
        Card card=cardRepository.findByIdAndActive(cardId,EnumStatus.ONLINE.getCode()).get();
        card=modelMapper.map(cardRequest,Card.class);
        Account account=accountRepository.findByIdAndActive(cardRequest.getAccountId(),EnumStatus.ONLINE.getCode()).get();
        if (cardRequest.getBalance().compareTo(account.getBalance())==1){
            throw new MyException(ExceptionEnum.BALANCE_NOT_FOUND);
        }
        card.setId(cardId);
        Card updatedCard=cardRepository.save(card);
        CardResponse cardResponse=convertToResponse(updatedCard);
        return ResponseModel.<CardResponse>builder().result(cardResponse).status(ExceptionEnum.SUCCESS.getMessage())
                .code(ExceptionEnum.SUCCESS.getCode()).error(false).build();
    }

    @Override
    public ResponseModel<CardResponse> deleteCard(Long cardId) {
        checkCardById(cardId);
        Card card=cardRepository.findByIdAndActive(cardId,EnumStatus.ONLINE.getCode()).get();
        card.setActive(EnumStatus.OFFLINE.getCode());
        Card deletedCard=cardRepository.save(card);
        CardResponse cardResponse=convertToResponse(deletedCard);
        return ResponseModel.<CardResponse>builder().result(cardResponse).status(ExceptionEnum.SUCCESS.getMessage())
                .code(ExceptionEnum.SUCCESS.getCode()).error(false).build();
    }
}
