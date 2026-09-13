package limbusbossmaker.assets;

import limbusbossmaker.Types;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

public class SkillText extends JLabel {
    public SkillText(String text) throws IOException, FontFormatException {

        setFont(GetAsset.getFont("roboto.ttf", 16f));
        setForeground(Color.WHITE);

        setText(checkForSpecialText("<html>" + text + "</html>"));
    }

    public String checkForSpecialText(String text){
        List<String> specialWordsGreen = List.of(
                "[Attack End]",
                "[On Hit]",
                "[On Hit without Cracking]",
                "[On Kill]",
                "[On Crit]",
                "[On Evade]",
                "[Failed Evade]",
                "[Target Fixed]",
                "[Combat Start]",
                "[Turn End]"
        );

        List<String> specialWordsBlue = List.of("[On Use]");
        List<String> specialWordsOrange = List.of("[Clash Win]");
        List<String> specialWordsRed = List.of("[Clash Lose]");


        List<String> specialSkillWords = List.of();

        for(String word : specialWordsRed){
            text = text.replace(word, "<font color = #e20000>%s</font>".formatted(word));
        }

        for(String word : specialWordsGreen) {
            text = text.replace(word, "<font color = #94f140>%s</font>".formatted(word));
        }

        for(String word : specialWordsBlue){
            text = text.replace(word, "<font color = #26cfff>%s</font>".formatted(word));
        }

        for(String word : specialWordsOrange){
            text = text.replace(word, "<font color = #ff7e00>%s</font>".formatted(word));
        }

        try {
            text = applyStatusEffectImage(text);
        } catch (IOException e) {
            System.out.println("Text has no status effect; skipping");
        }

        text = text.replace("\n", "<br>");

        return text;
    }

    public String applyStatusEffectImage(String text) throws IOException {
        GetIcons icon = new GetIcons();

        for(Types.debuffEffect effect: Types.debuffEffect.values()){
            if(text.contains(effect.toString())){
                text = text.replaceAll(effect.toString(),
                        addInlineImage(icon.getDebuffIcon(effect))
                                + setDebuffTextColor(capitalizeString(effect.toString()
                        )));
            }
        }

        for(Types.buffEffect effect: Types.buffEffect.values()){
            if (text.contains(effect.toString())){
                text = text.replaceAll(effect.toString(),
                        addInlineImage(icon.getBuffIcon(effect))
                                + setBuffTextColor(capitalizeString(effect.toString()
                        )));
            }
        }
        return text;
    }

    public String capitalizeString(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public String addInlineImage(BufferedImage image) throws IOException{
        String imagePath = GetIcons.makeTempFile(image);
        String html = "<img src=%s width='23' height='23' style='vertical-align: -5px;'/>".formatted(new File(imagePath).toURI());
        return html;
    }

    public String setDebuffTextColor(String text){
        return "<font color = #e20000 text-decoration: underline> <u>%s</u></font>".formatted(text);
    }

    public String setBuffTextColor(String text){
        return "<font color = #fac400; text-decoration = underline> <u>%s</u> </font>".formatted(text);
    }
}
