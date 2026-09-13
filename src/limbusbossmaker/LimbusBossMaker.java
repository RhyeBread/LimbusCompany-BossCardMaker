/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package limbusbossmaker;

import limbusbossmaker.templates.SkillTemplate;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Ryan
 */
public class LimbusBossMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FontFormatException {
        
        List<String> skill1CoinDescriptions =
                List.of(
                        """
                        [On Hit] Deal 20 Envy damage
                        """,
                        "[Heads] Deal 10 Blunt damage");
        
        String skill1Description =
                """
                [On use] Start the music
                """;
        
        String skill1Lore = "\"This is a test\"";
        
        BossSkill skill_1 = new BossSkill(
                "Gotcha!", Types.skill.OFFENSIVE, skill1Description, Types.sin.ENVY,
                Types.attack.BLUNT, Types.coin.REGULAR, 1, 2, 20, 2,
                Types.skillFrame.STRONGEST, skill1CoinDescriptions,
                skill1Lore);
        
        mainJFrame main = new mainJFrame();
        main.setSize(1200,900);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            SkillTemplate skillImg = new SkillTemplate();
            main.addSkillTemplate(skillImg);
        } catch (IOException ex) {
            System.getLogger(LimbusBossMaker.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        main.setVisible(true);

    }
    
    
}
