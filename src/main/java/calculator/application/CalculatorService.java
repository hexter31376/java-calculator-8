package calculator.application;

import calculator.application.dto.CalculatorRequest;
import calculator.application.dto.CalculatorResponse;
import calculator.application.service.CalculatorTokenizer;
import calculator.application.service.OperationalCollectionCalculator;
import calculator.domain.token.MeanToken;

import java.util.List;

public class CalculatorService {

        private final CalculatorTokenizer calculatortokenizer;
        private final OperationalCollectionCalculator operationalCollectionCalculator;

        public CalculatorService (CalculatorTokenizer calculatorTokenizer, OperationalCollectionCalculator operationalCollectionCalculator) {
            this.calculatortokenizer = calculatorTokenizer;
            this.operationalCollectionCalculator = operationalCollectionCalculator;
        }

        public CalculatorResponse run (String userInput) {
            CalculatorRequest calculatorRequest = new CalculatorRequest(userInput);

            List<MeanToken> meanTokens = calculatortokenizer.doTokenize(calculatorRequest); // 유효하지 않은 조건 필터링, 커스텀 구분자 사전 필터링 및 등록, 커스텀 구분자 필터링이 완료된 '순수한' 구문을 토크나이징 해서 의미를 가진 구문으로 래핑한 리스트 반환
            CalculatorResponse calculatorResponse = operationalCollectionCalculator.doOperate(meanTokens); // 의미 단위 토큰리스트를 받아들여 실제 연산 진행

            return calculatorResponse;
        }


}
