package com.example.brestaskk.service.impl;

import com.example.brestaskk.dto.request.CardToCardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.dto.response.TransferResponse;
import com.example.brestaskk.entity.Account;
import com.example.brestaskk.entity.Card;
import com.example.brestaskk.entity.Transfer;
import com.example.brestaskk.enums.*;
import com.example.brestaskk.exception.MyException;
import com.example.brestaskk.repository.AccountRepository;
import com.example.brestaskk.repository.CardRepository;
import com.example.brestaskk.repository.TransferRepository;
import com.example.brestaskk.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    private final ModelMapper modelMapper;

    @Override
    public ResponseModel<TransferResponse> cardToCardTransfer(CardToCardRequest cardToCardRequest) {
        checkCardDetails(cardToCardRequest);
        checkBalance(cardToCardRequest);
        Card creditorCard=cardRepository.findByIdAndActive(cardToCardRequest.getCreditorCardID(), EnumStatus.ONLINE.getCode()).get();
        Account creditorAccount=accountRepository.findByIdAndActive(creditorCard.getAccount().getId(),EnumStatus.ONLINE.getCode()).get();
        Card debitorCard=cardRepository.findByIdAndActive(cardToCardRequest.getCreditorCardID(), EnumStatus.ONLINE.getCode()).get();
        Account debitorAccount=accountRepository.findByIdAndActive(debitorCard.getAccount().getId(),EnumStatus.ONLINE.getCode()).get();
        creditorCard.setBalance(creditorCard.getBalance().subtract(cardToCardRequest.getAmount()));
        debitorCard.setBalance(debitorCard.getBalance().add(cardToCardRequest.getAmount()));
        creditorAccount.setBalance(creditorAccount.getBalance().subtract(cardToCardRequest.getAmount()));
        debitorAccount.setBalance(debitorAccount.getBalance().add(cardToCardRequest.getAmount()));
        cardRepository.save(creditorCard);
        cardRepository.save(debitorCard);
        accountRepository.save(creditorAccount);
        accountRepository.save(debitorAccount);
        Transfer transfer=new Transfer();
        transfer.setAmount(cardToCardRequest.getAmount());
        transfer.setCreditorCardID(creditorCard.getId());
        transfer.setDebitorCardID(debitorCard.getId());
        transfer.setDebitorAccountID(debitorAccount.getId());
        transfer.setCreditorAccountID(creditorAccount.getId());
        transfer.setCreditorCurrency(CurrencyEnum.AZN);
        transfer.setDebitorCurrency(CurrencyEnum.AZN);
        transfer.setStatus(TransferStatusEnum.CREATED);
        transfer.setTransferType(TransferTypeEnum.CART_TO_CART);
        Transfer savedTransfer=transferRepository.save(transfer);
        return ResponseModel.<TransferResponse>builder().result(
                modelMapper.map(savedTransfer,TransferResponse.class)).error(false)
                .status(ExceptionEnum.SUCCESS.getMessage()).code(ExceptionEnum.SUCCESS.getCode()).build();
    }

    @Override
    public boolean checkCardDetails(CardToCardRequest cardToCardRequest) {
        Card creditorCard=cardRepository.findByIdAndActive(cardToCardRequest.getCreditorCardID(), EnumStatus.ONLINE.getCode())
                .orElseThrow(()->new MyException(ExceptionEnum.CARD_NOT_FOUND));
        Card debitorCard=cardRepository.findByIdAndActive(cardToCardRequest.getCreditorCardID(), EnumStatus.ONLINE.getCode())
                .orElseThrow(()->new MyException(ExceptionEnum.CARD_NOT_FOUND));
        return true;
    }

    public boolean checkBalance(CardToCardRequest cardToCardRequest){
        Card creditorCard=cardRepository.findByIdAndActive(cardToCardRequest.getCreditorCardID(), EnumStatus.ONLINE.getCode())
                .orElseThrow(()->new MyException(ExceptionEnum.CARD_NOT_FOUND));
        if (cardToCardRequest.getAmount().compareTo(creditorCard.getBalance())==1){
            throw new MyException(ExceptionEnum.INSUFFICIENT_BALANCE);
        }
        return true;
    }


}
