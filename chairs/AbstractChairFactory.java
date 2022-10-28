package chairs;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicanChair();
    FunctionalChair createFunctionalChair();
    VictorianChair createVictorianChair(int age);
}
