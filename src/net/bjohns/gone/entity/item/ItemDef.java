package net.bjohns.gone.entity.item;

/**
 * Created by bjohns on 9/13/16.
 *
 * Gone - GNU License
 */
public interface ItemDef
{

    enum ItemType
    {
        BOW("bow"), STAFF("staff"), AXE("axe"), CHEST("chest"), LEGS("pantaloon");

        public String tag;

        ItemType(String tag)
        {
            this.tag = tag;
        }
    }

    enum FoodType
    {
        POTION("potion"), FOOD("food");

        public String tag;

        FoodType(String tag)
        {
            this.tag = tag;
        }
    }

    enum ArmorType
    {
        CLOTH("cloth"), LEATHER("leather"), PLATE("plate");
        public String tag;

        ArmorType(String tag)
        {
            this.tag = tag;
        }
    }

    enum Effect
    {
        SHOOT("shoot"), MAGIC("magic"), SLASH("slash"), HEAL("heal");

        public String tag;

        Effect(String tag)
        {
            this.tag = tag;
        }
    }
}
