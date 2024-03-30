package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private FileReaderImpl fileReader = new FileReaderImpl();
    private OperationStrategy strategy = new OperationStrategy();

    @Override
    public void fruitTransaction(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            TransactionHandler transactionHandler = strategy
                    .getOperationHandler(fruitTransaction.getOperation());
            transactionHandler.process(fruitTransaction);
        }
    }
}
