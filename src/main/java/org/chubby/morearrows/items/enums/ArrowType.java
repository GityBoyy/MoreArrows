package org.chubby.morearrows.items.enums;

public enum ArrowType
{
    WOOD("wood",10f),
    IRON("iron",10.5f),
    COPPER("copper",10.2f),
    GOLD("gold",8.6f),
    DIAMOND("diamond",11.7f),
    AMETHYST("amethyst",12.3f),
    ENDER_PEARL("ender_pearl",13.5f),
    EXPLOSION("explosion",15.0f);

    String name;
    float damage;
    ArrowType(String name, float damage)
    {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public float getDamage() {
        return damage;
    }
}
