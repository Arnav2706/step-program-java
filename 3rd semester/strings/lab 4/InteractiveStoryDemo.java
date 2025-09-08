abstract class StoryCharacter {
    protected final String characterId;
    protected final String backstory;
    protected final String corePersonality;

    protected String currentMood;
    protected String currentLocation;

    public StoryCharacter(String characterId, String backstory, String corePersonality) {
        this.characterId = characterId;
        this.backstory = backstory;
        this.corePersonality = corePersonality;
        this.currentMood = "Neutral";
        this.currentLocation = "Unknown";
    }

    public abstract void createDialogue();

    public String getCharacterInfo() {
        return "ID: " + characterId + ", Personality: " + corePersonality +
               ", Mood: " + currentMood + ", Location: " + currentLocation;
    }
}

// Hero class
class Hero extends StoryCharacter {
    private final String origin;

    public Hero(String id, String backstory, String personality, String origin) {
        super(id, backstory, personality);
        this.origin = origin;
    }

    public void createDialogue() {
        System.out.println("Hero (" + origin + "): 'I will save the day!'");
    }
}

// Villain class
class Villain extends StoryCharacter {
    private final String evilMotivation;

    public Villain(String id, String backstory, String personality, String motivation) {
        super(id, backstory, personality);
        this.evilMotivation = motivation;
    }

    public void createDialogue() {
        System.out.println("Villain (" + evilMotivation + "): 'You cannot stop me!'");
    }
}

// Mysterious Stranger
class MysteriousStranger extends StoryCharacter {
    public MysteriousStranger(String id, String backstory, String personality) {
        super(id, backstory, personality);
    }

    public void createDialogue() {
        System.out.println("Stranger: 'My secrets will be revealed in time...'");
    }
}

// Comic Relief
class ComicRelief extends StoryCharacter {
    private final String humorStyle;

    public ComicRelief(String id, String backstory, String personality, String humorStyle) {
        super(id, backstory, personality);
        this.humorStyle = humorStyle;
    }

    public void createDialogue() {
        System.out.println("Comic Relief (" + humorStyle + "): 'Oops! Did I do that?'");
    }
}

// Story Engine
class StoryEngine {
    public static void generateStoryArc(StoryCharacter c1, StoryCharacter c2) {
        if (c1 instanceof Hero && c2 instanceof Villain) {
            System.out.println("Epic battle begins between Hero and Villain!");
        } else if (c1 instanceof Hero && c2 instanceof ComicRelief) {
            System.out.println("Hero and Comic Relief embark on a funny adventure!");
        } else if (c1 instanceof Villain && c2 instanceof MysteriousStranger) {
            System.out.println("Villain tries to recruit the Stranger...");
        } else {
            System.out.println("An unusual story unfolds between characters...");
        }
    }
}

public class InteractiveStoryDemo {
    public static void main(String[] args) {
        StoryCharacter hero = new Hero("H001", "Raised in a village", "Brave", "Village Origin");
        StoryCharacter villain = new Villain("V001", "Dark childhood", "Cruel", "World Domination");
        StoryCharacter stranger = new MysteriousStranger("S001", "Unknown past", "Calm");
        StoryCharacter comic = new ComicRelief("C001", "Happy-go-lucky", "Cheerful", "Slapstick");

        hero.createDialogue();
        villain.createDialogue();
        stranger.createDialogue();
        comic.createDialogue();

        System.out.println("\n--- Story Arcs ---");
        StoryEngine.generateStoryArc(hero, villain);
        StoryEngine.generateStoryArc(hero, comic);
        StoryEngine.generateStoryArc(villain, stranger);
    }
}
