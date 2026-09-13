/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ryan
 */
public class Boss {
    String name;
    int level;
    int speedSlots;
    float maxHealth;
    
    //Maps each sin and boss' affinity to it.
    Map<Integer, Integer> sinAffinities;
    List<BossSkill> skills;
    List<Passives> passives;
    List<String> traits;
    
    public Boss(String name,
            float maxHealth,
            Map<Integer, Integer> sinAffinities,
            List<BossSkill> skills,
            List<Passives> passives,
            List<String> traits){
        this.name = name;
        this.maxHealth = maxHealth;
    }
    
    public String getName(){return this.name;}
    
    public int getLevel(){return this.level;}
    
    public int getSpeedSlots(){return this.speedSlots;}
    
    public float getMaxHealth(){return this.maxHealth;}
    
    public Map<Integer, Integer> getSinAffinities(){return this.sinAffinities;}
    
    public List<BossSkill> getSkills(){return this.skills;}
    
    public List<Passives> getPassives(){return this.passives;}
    
    public List<String> getTraits(){return this.traits;}
    
    
    
}
