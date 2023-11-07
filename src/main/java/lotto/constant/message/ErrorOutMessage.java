package lotto.constant.message;

import lotto.constant.LottoNumber;

public class ErrorOutMessage {

    public static final String ERROR="[ERROR]";


    public static final String PURCHASE
            = ERROR +  "금액은 " + LottoNumber.PURCHASE_AMOUNT_COND.getNumber() + "으로 나누어 떨어져야 합니다.";

    public static final String WINNING_TYPE
            = ERROR + "당첨 번호는 ,(쉼포)로 구분하여 " + LottoNumber.MAX_COUNT.getNumber() + "개를 입력해야 합니다.";

    public static final String WINNING_DUPLICATE
            = ERROR + "당첨 번호는 중복될 수 없습니다.";

    public static final String LOTTO_NUM
            = ERROR + "로또 번호는 " + LottoNumber.FIRST_RANGE.getNumber() + "부터 " + LottoNumber.LAST_RANGE + " 사이의 숫자여야 합니다.";


}
