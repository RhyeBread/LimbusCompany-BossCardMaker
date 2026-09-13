/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker.assets;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.jhlabs.image.HSBAdjustFilter;
import limbusbossmaker.Types;

import javax.swing.*;


/**
 *
 * @author Ryan
 */
public class ColorizeMask {
    float hue;
    float saturation = 1f;
    float lightness = .1f;

    public BufferedImage applyHSBFiler(BufferedImage image){
        HSBAdjustFilter filter = new HSBAdjustFilter(hue, saturation, lightness);
        BufferedImage destImage = filter.createCompatibleDestImage(image, null);
        filter.filter(image, destImage);

        return destImage;
    }

    public BufferedImage colorizeWithSin(BufferedImage image, Types.sin sin){

        
        switch(sin){
            case ENVY:
                setHue(288);
                break;

            case GLOOM:
                setHue(180);
                break;
                
            case GLUTTONY:
                setHue(90);
                break;
                
            case LUST:
                setHue(35);
                break;
                
            case PRIDE:
                setHue(240);
                break;
                
            case SLOTH:
                setHue(60);
                break;
                
            case WRATH:
                setHue(360);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + sin);
        }

        return applyHSBFiler(image);
    }

    public BufferedImage colorizeWithPassive(BufferedImage image, Types.passive passive, JLabel text){
        switch(passive){
            case NORMAL_PASSIVE:
                setHue(30);
                this.saturation = .65f;
                this.lightness = -.2f;
                text.setForeground(new Color(238, 206, 164));
                break;
                
            case ALLY_WARNING_PASSIVE :
                setHue(75);
                text.setForeground(new Color(243, 252, 7));
                break;
                
            case ENEMY_SMALL_WARNING_PASSIVE:
                setHue(29);
                text.setForeground(new Color(247, 199, 41));
                break;

            case ENEMY_MEDIUM_WARNING_PASSIVE:
                this.hue = 0;
                text.setForeground(new Color(247, 199, 41));
                break;
        }

        return applyHSBFiler(image);
        
    }

    public void setHue(int hue){
        this.hue = hue / 360f;
    }

}
