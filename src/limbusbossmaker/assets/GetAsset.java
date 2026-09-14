/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker.assets;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;

/**
 *
 * @author Ryan
 */
public class GetAsset {
    public static URL getImageURL(String fileName){
        return(GetAsset.class.getResource("/limbusbossmaker/assets/images/"+ fileName));
    }

    public static Font getFont(String fileName, float fontSize) throws FontFormatException, IOException{
        InputStream inputStream = GetAsset.class.getResourceAsStream("/limbusbossmaker/assets/fonts/"+ fileName);
        Font customFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
        return(customFont.deriveFont(fontSize));
    }

    public static URL getJsonURI(String fileName){
        return(GetAsset.class.getResource("/limbusbossmaker/assets/json/"+fileName));
    }
}
