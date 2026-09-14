/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker.bosses;

import java.util.List;
import java.util.Map;

import limbusbossmaker.Boss;
import limbusbossmaker.BossSkill;
import limbusbossmaker.Passives;
import limbusbossmaker.Types;

/**
 *
 * @author Ryan
 */
public class ExampleBoss extends Boss {
    float maxHealth = 1200;
    String name = "Ricardo";
    
    
    List<String> punchingCoinDescriptions = 
            List.of(
            "[On Hit] Deal 3 Blunt bonus damage",
            "[On Hit] Deal 3 Blunt bonus damage",
            "[On Hit] Inflict 3 Paralyze"
            );
    
    List<String> kickingCoinDescriptions = 
            List.of(
            "[On Hit] Deal 3 Blunt bonus damage",
            "[On Hit] Deal 3 Blunt bonus damage",
            "[On Hit] Inflict 3 Paralyze"
            );
    
    List<String> paybackCounterDescriptions =
            List.of(
                    "",
                    "[On Hit] Target loses 5 SP"
            );
    
    BossSkill punchingSkill = new BossSkill(
            "Punching", Types.skill.OFFENSIVE, "",
            Types.sin.ENVY, Types.attack.BLUNT,
            Types.coin.REGULAR, 1, 3, 3, 2,
            Types.skillFrame.NORMAL, punchingCoinDescriptions,
            ""
    );
    
    BossSkill kickingSkill = new BossSkill(
            "Kicking", Types.skill.OFFENSIVE, "",
            Types.sin.ENVY, Types.attack.BLUNT,
            Types.coin.REGULAR, 1, 3, 3, 2,
            Types.skillFrame.NORMAL, kickingCoinDescriptions,
            ""
    );
    
    BossSkill paybackCounter = new BossSkill(
            "Payback", Types.skill.COUNTER, "",
            Types.sin.WRATH, Types.attack.BLUNT,
            Types.coin.REGULAR, 1, 2, 12, -4,
            Types.skillFrame.NORMAL, paybackCounterDescriptions,
            ""
    );

    public ExampleBoss(String name,
                       float maxHealth,
                       Map<Integer, Integer> sinAffinities,
                       List<BossSkill> skills,
                       List<Passives> passives,
                       List<String> traits) {
        super(name, maxHealth, sinAffinities, skills, passives, traits);
    }
    
    
}
