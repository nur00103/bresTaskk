package com.example.brestaskk.controller;

import com.example.brestaskk.dto.request.CardToCardRequest;
import com.example.brestaskk.dto.response.CardResponse;
import com.example.brestaskk.dto.response.ResponseModel;
import com.example.brestaskk.dto.response.TransferResponse;
import com.example.brestaskk.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/cardToCard")
    public ResponseModel<TransferResponse> cardToCardTransfer(@RequestBody @Valid CardToCardRequest cardToCardRequest){
        return transferService.cardToCardTransfer(cardToCardRequest);
    }


}
