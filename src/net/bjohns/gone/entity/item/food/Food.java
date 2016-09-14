package net.bjohns.gone.entity.item.food;

import net.bjohns.gone.entity.item.Item;
import net.bjohns.gone.util.Maths;

import static net.bjohns.gone.Constant.ascii;

/**
 * Created by bjohns on 9/13/16.
 *
 * Gone - GNU License
 */
public class Food extends Item
{
    private FoodType foodType;
    private Effect effect;
    private int healing;


    public Food()
    {
        foodType = Maths.randomIndex(FoodType.values());
        icon = ascii[10];
    }

    public Food(FoodType foodType)
    {
        this.foodType = foodType;
        icon = ascii[10];
    }

    public Food createItem(int level)
    {
        setItemLevel(level);
        int h = Maths.random(3);

        switch (foodType)
        {
            case POTION:
                healing = h + level;
                effect = Effect.HEAL;
                info = "a murky red potion.";
                //info = effect.tag + " " + foodType.tag;
                break;
            case FOOD:
                healing = h + level;
                effect = Effect.HEAL;
                // info = effect.tag + " " + foodType.tag;
                info = "a tasty sandwich.";

        }
        return this;
    }

    public Effect getEffect()
    {
        return effect;
    }

    public int getHealing()
    {
        return healing;
    }

    public String toString()
    {
        return info + " [+" + healing + "hp]";
    }
}
