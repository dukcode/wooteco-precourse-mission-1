package baseball.baseball;

import baseball.game.turn.TurnBasedGameService;
import baseball.game.turn.TurnInput;

public class BaseballGameService implements TurnBasedGameService {

    private final BaseballNumberGenerator numberGenerator;
    private BaseballNumber answer;

    public BaseballGameService(BaseballNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void init() {
        answer = numberGenerator.generate();
    }

    @Override
    public BaseballGameTurnResult playTurn(TurnInput turnInput) {
        BaseballGameTurnInput baseballGameTurnInput = (BaseballGameTurnInput) turnInput;
        return baseballGameTurnInput.calculateResult(this);
    }

    public BaseballNumber getAnswer() {
        return answer;
    }
}
