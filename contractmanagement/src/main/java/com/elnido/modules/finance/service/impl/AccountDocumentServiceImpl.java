package com.elnido.modules.finance.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.elnido.modules.finance.entity.AccountDocument;
import com.elnido.modules.finance.mapper.AccountDocumentMapper;
import com.elnido.modules.finance.service.AccountDocumentService;
import org.springframework.stereotype.Service;

/**
 * @author Jack
 */
@Service
public class AccountDocumentServiceImpl extends ServiceImpl<AccountDocumentMapper, AccountDocument> implements AccountDocumentService {


    @Override
    public void postAccountDocument(AccountDocument accountDocument) {

    }
}