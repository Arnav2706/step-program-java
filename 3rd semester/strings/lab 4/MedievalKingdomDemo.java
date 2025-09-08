abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    // Constructor overloading with this() chaining
    public MagicalStructure(String structureName) {
        this(structureName, 50, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower) {
        this(structureName, magicPower, "Unknown", true);
    }

    public MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

// WizardTower class
class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower(String name) {
        super(name, 100, "Hilltop", true);
        this.spellCapacity = 5;
        this.knownSpells = new String[]{"Fireball", "Shield"};
    }

    public WizardTower(String name, int spellCapacity, String[] spells) {
        super(name, 150, "Mountain", true);
        this.spellCapacity = spellCapacity;
        this.knownSpells = spells;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " casts a powerful wizard spell!");
    }
}

// EnchantedCastle class
class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String name) {
        super(name, 80, "Plains", true);
        this.defenseRating = 200;
        this.hasDrawbridge = true;
    }

    public EnchantedCastle(String name, int defenseRating, boolean hasDrawbridge) {
        super(name, 120, "Valley", true);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = hasDrawbridge;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " casts a defensive barrier spell!");
    }
}

// MysticLibrary class
class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String name) {
        super(name, 90, "Forest", true);
        this.bookCount = 500;
        this.ancientLanguage = "ElderTongue";
    }

    public MysticLibrary(String name, int bookCount, String language) {
        super(name, 120, "Sacred Grove", true);
        this.bookCount = bookCount;
        this.ancientLanguage = language;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " casts a knowledge-enhancing spell!");
    }
}

// DragonLair class
class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String name) {
        super(name, 200, "Cave", true);
        this.dragonType = "Fire Dragon";
        this.treasureValue = 1000;
    }

    public DragonLair(String name, String dragonType, int treasureValue) {
        super(name, 250, "Mountain Peak", true);
        this.dragonType = dragonType;
        this.treasureValue = treasureValue;
    }

    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fury!");
    }
}

// Kingdom Manager
class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            return true; // Knowledge boost combo
        }
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            return true; // Dragon guard combo
        }
        return false;
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int totalPower = 0;
        for (MagicalStructure s : structures) {
            totalPower += s.magicPower;
        }
        return totalPower;
    }
}

public class MedievalKingdomDemo {
    public static void main(String[] args) {
        MagicalStructure[] kingdom = {
            new WizardTower("Tower of Elders"),
            new EnchantedCastle("Royal Fortress"),
            new MysticLibrary("Ancient Library"),
            new DragonLair("Smaug's Lair")
        };

        for (MagicalStructure s : kingdom) {
            s.castMagicSpell();
        }

        System.out.println("Total Kingdom Magic Power: " +
            KingdomManager.calculateKingdomMagicPower(kingdom));

        System.out.println("Can Tower and Library interact? " +
            KingdomManager.canStructuresInteract(kingdom[0], kingdom[2]));
    }
}
