package com.elnido.modules.finance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.elnido.modules.finance.entity.AccountDocument;
import com.elnido.modules.purchasecontract.entity.PurchaseContractItem;
import org.apache.shiro.authc.Account;

/**
 * @author Jack
 */
public interface AccountDocumentService extends IService<AccountDocument> {

    void postAccountDocument(final AccountDocument accountDocument);

}
