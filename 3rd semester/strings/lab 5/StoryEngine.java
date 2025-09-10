import java.util.*;

public final class StoryEngine {
    private static final StoryEngine INSTANCE = new StoryEngine();
    private final String[] narrativeRules = {"Heroes fight villains", "Mystery adds tension", "Comedy lightens mood"};
    private final Map<String, Object> activeCharacters = new HashMap<>();

    private StoryEngine() {}

    public static StoryEngine getInstance() {
        return INSTANCE;
    }

    public final String generateNarrative() {
        return "📖 Story Generated: A hero embarks on a quest!";
    }

    public void registerCharacter(String id, Object character) {
        activeCharacters.put(id, character);
    }

    public void showRegisteredCharacters() {
        System.out.println("Active Characters: " + activeCharacters.keySet());
    }

    // MAIN METHOD
    public static void main(String[] args) {
        StoryEngine engine = StoryEngine.getInstance();
        System.out.println(engine.generateNarrative());

        engine.registerCharacter("hero1", "HeroCharacter");
        engine.registerCharacter("villain1", "VillainCharacter");

        engine.showRegisteredCharacters();
    }
}
