/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker.templates;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import limbusbossmaker.Types;
import limbusbossmaker.assets.SkillText;
import limbusbossmaker.assets.GetAsset;
import limbusbossmaker.assets.ColorizeMask;
import limbusbossmaker.assets.GetIcons;

/**
 *
 * @author Ryan
 */
public class SkillTemplate extends JPanel {
    public SkillTemplate() throws IOException, FontFormatException {
        String skillName = "I'll Gladly Blast a Hole in You";
        int bannerX = 105;
        int bannerY = 40;
        
        setOpaque(false);

        //Icons
        GetIcons icon = new GetIcons();
        JLabel skillIconContainer = new JLabel(new ImageIcon(
                icon.getSkillIcon(
                        Types.skillFrame.STRONGEST, Types.sin.ENVY
)                        .getScaledInstance(125, 125, Image.SCALE_SMOOTH)
        ));
        
        skillIconContainer.setBounds(0, 0, 100, 115);
        
        //TODO Make Y scale with text Y
        JLayeredPane skillLayeredPane = new JLayeredPane();
        skillLayeredPane.setPreferredSize(new Dimension(600, 300));
        
        
        
        //Adding coins
        JPanel coinPanel = new JPanel(
        new FlowLayout(FlowLayout.RIGHT, 1, 0)
        );
        
        
        Image coin = ImageIO.read(GetAsset.getImageURL("regular_coin.png"));
        for (int i = 0; i < 5; i++){ //TODO CHANGE '5' TO COIN COUNT!!!!!!!!!!!!!!!!!!!
            JLabel coinContainer = new JLabel(new ImageIcon(
                    coin.getScaledInstance(30, 30, Image.SCALE_SMOOTH)
            ));
            coinPanel.add(coinContainer);
            coinPanel.setOpaque(false);
        }

        //TODO Make sure width scales with coin count
        coinPanel.setBounds(60, 5, 200, 35);
        
        
        //Text for Skills
        JLabel skillLabel = new JLabel();
        skillLabel.setText("MY HAIR COUPOOOOOOOOOOONS!!!");
        try {
            skillLabel.setFont(GetAsset.getFont("mikodacs.ttf", 16f));
        } catch (FontFormatException ex) {
            System.getLogger(SkillTemplate.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        skillLabel.setBounds(bannerX + 10, 7, skillLabel.getText().length() * 10, 100);
        skillLabel.setOpaque(false);
        skillLabel.setForeground(new Color(238, 206, 164));
        
        
        //Banner for skills
        JPanel skillBannerPanel = new JPanel(
        new FlowLayout(FlowLayout.LEFT,1, 1));

        BufferedImage banner = new ColorizeMask().colorizeWithSin(
                ImageIO.read(GetAsset.getImageURL("skill_or_passive_label.png")),
                Types.sin.ENVY
        );

        JLabel bannerContainer = new JLabel(new ImageIcon(
                banner.getScaledInstance(216, 38, Image.SCALE_SMOOTH)));
        
        //TODO Make sure X scales with txt length
        skillBannerPanel.add(bannerContainer);
        skillBannerPanel.setOpaque(false);
        skillBannerPanel.setBounds(bannerX, bannerY, 216, 38);
        

        JPanel skillDescriptionPanel = new JPanel(
                new FlowLayout(FlowLayout.LEFT, 1, 1)
        );

        //Skill pretext
        String skillPretext = """
               If the main target has less than 0 SP, Final Power +5
               [On Use] All enemies on field gain +10 CHARGE count
               [On Hit] Raise Stagger Threshold by 30
               [On Hit] Inflict 1 TREMOR next turn
               [On Kill] Lose the encounter
               [Clash Win] Die
               """;
        SkillText skillDescriptionLabel = new SkillText(skillPretext);

        int pretextLines = Math.toIntExact(skillPretext.lines().count()) * 35;
        System.out.println(pretextLines);
        skillDescriptionPanel.setOpaque(false);
        skillDescriptionPanel.setBounds(bannerX,
                bannerY + 50,
                skillDescriptionLabel.getText().length() * 10,
                pretextLines);
        skillDescriptionPanel.add(skillDescriptionLabel);






        //Coin descriptions
        
        
        
        //Adding to frame
        skillLayeredPane.add(
                skillIconContainer,
                JLayeredPane.DEFAULT_LAYER
        );
        
        skillLayeredPane.add(
                coinPanel,
                JLayeredPane.PALETTE_LAYER
        );
        
        skillLayeredPane.add(
                skillLabel,
                JLayeredPane.PALETTE_LAYER
        );
        
        skillLayeredPane.add(
                skillBannerPanel,
                JLayeredPane.PALETTE_LAYER
        );

        skillLayeredPane.add(
                skillDescriptionPanel,
                JLayeredPane.PALETTE_LAYER
        );

        
        
        
        
        //Adding everything to main panel
        add(skillLayeredPane);
//        add(skillBannerPanel);
        
    }
}
