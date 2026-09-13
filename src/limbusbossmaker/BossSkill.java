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
public class BossSkill{
    Types.sin sin;
    Types.attack attackType;
    Types.skillFrame skillIcon;
    Types.coin coinType;
    Types.skill skillType;
    
    int attackWeight;
    int coins;
    int basePower;
    int coinPower;
    
    String skillDescription;
    String skillName;
    String lore;
    
    //coin, coinDescription
    Map<Integer, String> coin = new HashMap<>();
    List<String> coinDescriptions;
    
    /**
     *
     * skillName -> Name of the skill <br>
     * Types.skill skillType -> ATTACK, GUARD, EVADE <br>
     * skillDescription -> For things like [On Use] <br>
     * Types.sin -> What sin it is <br>
     * Types.attack -> What type of attack is it? (Blunt, Slash, Pierce, Guard) <br>
     * coins -> The amount of coins in this skill <br>
     * basePower -> The number to the left of a skill <br>
     * Types.skillFrame -> The intensity of the skill frame like in a sinner's kit <br>
     * coinDescriptions -> The list of all the descriptions of each individual coin. <br>
     * lore -> Some skills have flavor text at the foot of their skill/ passive. <br>
     *
    */
    public BossSkill(
            String skillName, Types.skill skillType, String skillDescription,
            Types.sin sin, Types.attack attackType,
            
            Types.coin coinType, int attackWeight, int coins, int basePower, int coinPower,
            Types.skillFrame skillFrame, List<String> coinDescriptions,
            
            String lore
            ){
        
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillDescription = skillDescription;
        this.sin = sin;
        this.attackType = attackType;
        
        this.coinType = coinType;
        this.attackWeight = attackWeight;
        this.coins = coins;
        this.basePower = basePower;
        this.coinPower = coinPower;
        
        this.skillIcon = skillFrame;
        this.coinDescriptions = coinDescriptions;
        
        this.lore = lore;
        
        
        for(int i = 0; i < this.coins; i++){
            this.coin.put(i, this.coinDescriptions.get(i));
        }
    }
    
    
    public void displayCoinDescriptions(){
        System.out.printf("""
                          (%s) %s (%s)
                          %s
                          """,
                this.sin,
                this.skillName,
                this.skillType,
                this.skillDescription);
        
        
        this.coin.forEach((coin, coinDescription) ->{
            System.out.printf("""
                              Coin #%d
                              --------------------------
                              %s
                              
                              """, coin + 1,
                              coinDescription);
        });
        
        if(this.lore != null){
            System.out.printf("""
                              \033[3m\033[1m%s\033[0m
                              """, this.lore);
        }
    }
    
    public void setCoinDescription(int coinNum, String coinDescription){
        coin.put(coinNum, coinDescription);
    }
    
}
