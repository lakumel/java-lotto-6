package lotto.domain;

import lotto.Lotto;
import lotto.util.MessageUtil;

import java.util.List;

public class LottoPlay {

    private final MessageUtil messageUtil = new MessageUtil();
    private final LottoPurchase lottoPurchase = new LottoPurchase();

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();


    public void play() {
        messageUtil.printPurchaseInput();
        LottoPurchase purchaseInfo =lottoPurchase.getPurchaseInfo();
        LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();
        LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);

        lottoPrize.getLottoStats(purchaseInfo.getUserLottos
        ,purchaseInfo.getPurchaseAmount());

    }

}
