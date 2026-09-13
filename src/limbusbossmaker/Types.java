/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker;

/**
 *
 * @author Ryan
 */
public class Types {
    public enum sin{
        ENVY,
        GLUTTONY,
        GLOOM,
        LUST,
        PRIDE,
        SLOTH,
        WRATH,
        SINLESS
    }
    
    public enum affinities{
        NORMAL,
        ENDURE,
        FATAL
    }
    
    public enum attack{
        SLASH,
        PIERCE,
        BLUNT,
        GUARD
    }
    
    public enum passive{
        NORMAL_PASSIVE,
        ALLY_WARNING_PASSIVE,
        ENEMY_SMALL_WARNING_PASSIVE,
        ENEMY_MEDIUM_WARNING_PASSIVE,
        ENEMY_HIGH_WARNING_PASSIVE
    }
    
    public enum skillFrame{
        NORMAL,
        STRONGER,
        STRONGEST
    }
    
    public enum skill{
        OFFENSIVE,
        GUARD,
        EVADE,
        COUNTER
    }
    
    public enum coin{
        REGULAR,
        UNBREAKABLE,
        EXCISION,
        PURPLE
    }
    
    public enum debuffEffect {
        BLEED,
        BURN,
        RUPTURE,
        SINKING,
        TREMOR,
    }

    public enum buffEffect {
        POISE,
        CHARGE,
    }



}
