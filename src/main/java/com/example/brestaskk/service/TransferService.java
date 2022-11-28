package com.example.brestaskk.service;

import com.example.brestaskk.dto.request.CardToCardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.dto.response.TransferResponse;

public interface TransferService {
    ResponseModel<TransferResponse> cardToCardTransfer(CardToCardRequest cardToCardRequest);

    public boolean checkCardDetails(CardToCardRequest cardToCardRequest);
}
