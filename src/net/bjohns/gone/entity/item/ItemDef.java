package net.bjohns.gone.entity.item;

/**
 * Created by bjohns on 9/13/16.
 */
public interface ItemDef
{
  public enum ConsumableType
  {
    FOOD, ALCHEMICAL
  }

  public enum EquipType
  {
    LEGS("Chaps"), CHEST("Tunic"), WEAPON("weapon");

    public String name;

    EquipType(String name)
    {
      this.name = name;
    }
  }

  public enum ItemTier
  {
    FIRST_WAR(1, 2, "First War"), GOBLIN_METAL(2, 4, "Goblin Metal"),
    MOON_STEEL(3, 8, "Moon Steel"),
    DRAGON_FORGE(4, 10, "Dragon Forged");

    public int tier, baseDamage;
    public String name;

    ItemTier(int tier, int base, String name)
    {
      this.tier = tier;
      this.baseDamage = base;
      this.name = name;
    }

  }
}
