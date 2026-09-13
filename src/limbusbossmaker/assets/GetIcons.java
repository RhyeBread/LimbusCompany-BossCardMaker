/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import javax.imageio.ImageIO;
import limbusbossmaker.Types;


/**
 *
 * @author Ryan
 */
public class GetIcons {
    
    public final BufferedImage baseSkillFrameSheet = ImageIO.read(GetAsset.getImageURL("SkillFrame_1.png"));
    public final BufferedImage strongestSkillFrameSheet = ImageIO.read(GetAsset.getImageURL("SkillFrame_2.png"));
    public final BufferedImage statusIconSheet = ImageIO.read(GetAsset.getImageURL("Icon_buf_3.png"));
    public final BufferedImage coinIconSheet = ImageIO.read(GetAsset.getImageURL("coin_icons.png"));

    //  Size / Icons per row
    int skillIconDimensions = 512;
    int statusIconDimensions = 1024 / 8;
    int coinIconDimensions = 2048 / 8;


    public GetIcons() throws IOException{}

    public BufferedImage getCoinIcon(Types.coin coin){
        BufferedImage tile = null;

        switch(coin){
            case REGULAR -> {tile = getTile(coinIconSheet, coinIconDimensions, 0, 0);}
            case UNBREAKABLE -> {tile = getTile(coinIconSheet, coinIconDimensions, 3, 0);}
            case EXCISION -> {tile = getTile(coinIconSheet, coinIconDimensions, 1, 1);}
            case PURPLE -> {tile = getTile(coinIconSheet, coinIconDimensions, 3, 0);}
        }
        return tile;
    }

    public BufferedImage getSkillIcon(Types.skillFrame skillFrame, Types.sin sin){
        BufferedImage tile = null;
        
        switch(sin){
            case WRATH:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 0, 0);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 0, 2);
                    break;
                }
                
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet, skillIconDimensions, 0, 0);
                    break;
                }

            case LUST:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 1, 0);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 1, 2);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet, skillIconDimensions, 1, 0);
                    break;
                }

            case SLOTH:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet,skillIconDimensions, 2, 0);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 2, 2);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet,  skillIconDimensions, 2, 0);
                    break;
                }

            case GLUTTONY:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 3, 0);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 3, 3);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet, skillIconDimensions, 3, 0);
                    break;
                }

            case GLOOM:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 0, 1);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 0, 3);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet,  skillIconDimensions, 0, 1);
                    break;
                }
                
            case PRIDE:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 1, 1);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 1, 3);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet,  skillIconDimensions, 1, 1);
                    break;
                }

            case ENVY:
                if(skillFrame == Types.skillFrame.NORMAL){
                    tile = getTile(baseSkillFrameSheet,  skillIconDimensions, 2, 1);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGER){
                    tile = getTile(baseSkillFrameSheet, skillIconDimensions, 2, 3);
                    break;
                }
                else if (skillFrame == Types.skillFrame.STRONGEST){
                    tile = getTile(strongestSkillFrameSheet, skillIconDimensions, 2, 1);
                    break;
                }

        }
        return tile;
    }

    public BufferedImage getDebuffIcon(Types.debuffEffect statusEffect){
        BufferedImage tile = null;

        switch(statusEffect){
            case BLEED -> {tile = getTile(statusIconSheet, statusIconDimensions, 2, 1);}
            case BURN -> {tile = getTile(statusIconSheet, statusIconDimensions, 2, 0);}
            case RUPTURE -> {tile = getTile(statusIconSheet, statusIconDimensions, 0, 1);}
            case SINKING -> {tile = getTile(statusIconSheet, statusIconDimensions, 1, 0);}
            case TREMOR -> {tile = getTile(statusIconSheet, statusIconDimensions, 0, 0);}
        }
        return tile;
    }

    public BufferedImage getBuffIcon(Types.buffEffect statusEffect){
        BufferedImage tile = null;

        switch (statusEffect){
            case CHARGE -> {tile = getTile(statusIconSheet, statusIconDimensions, 3, 0);}
            case POISE -> {tile = getTile(statusIconSheet, statusIconDimensions, 1, 1);}
        }
        
        return tile;
    }

    private BufferedImage getTile(
            BufferedImage sheet,
            int dimensions,
            int x,
            int y){

        return sheet.getSubimage(
                x * dimensions,
                y  * dimensions,
                dimensions,
                dimensions
        );
    }

    public static String makeTempFile(BufferedImage image) throws IOException {
        Path projectPath = Paths.get(System.getProperty("user.dir"),
                "src", "limbusbossmaker", "assets", "images", "temp");

        Path tempPath = Files.createTempFile(projectPath, "temp", ".png");

        ImageIO.write(image, "png", tempPath.toFile());
        tempPath.toFile().deleteOnExit();
        return tempPath.toAbsolutePath().toString();
    }

            
}
