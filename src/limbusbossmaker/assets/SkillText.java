package limbusbossmaker.assets;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import limbusbossmaker.Types;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class SkillText extends JLabel {
    public SkillText(String text) throws IOException, FontFormatException {

        setFont(GetAsset.getFont("roboto.ttf", 16f));
        setText("<html><p color = #FFFFFF style = 'align-items: bottom'>" + checkForSpecialText(text) + "</p></html>");
    }

    public String checkForSpecialText(String text) {

        try {
            File textColor = new File(GetAsset.getJsonURI("textColor.json").toURI());

            JsonElement fileElement = JsonParser.parseReader(new FileReader(textColor));
            JsonObject fileObject = fileElement.getAsJsonObject();
            JsonArray colorElements = fileObject.get("colors").getAsJsonArray();

            for(int i = 0; i < colorElements.size(); i++){
                JsonObject wrapper = colorElements.get(i).getAsJsonObject();

                for(Map.Entry<String, JsonElement> entry: wrapper.entrySet()){
                    JsonObject colorObject = entry.getValue().getAsJsonObject();
                    List<JsonElement> values = colorObject.get("values").getAsJsonArray().asList();
                    String color = colorObject.get("color").getAsString();

                    for(JsonElement value: values){
                        String word = value.getAsString();
                        if(text.contains(word)){
                            text = text.replace(
                                    word,
                                    "<font color = \"%s\">%s</font>".formatted(color, word));
                        }
                    }

                }
            }

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
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

        for(Types.neutralEffect effect: Types.neutralEffect.values()){
            if(text.contains(effect.toString())){
                text = text.replaceAll(effect.toString(),
                        addInlineImage(icon.getNeutralIcon(effect))
                        + setNeutralTextColor(capitalizeString(effect.toString()
                        )));
            }
        }
        return text;
    }

    public String capitalizeString(String string){
        String[] words = string.split("_");
        StringBuilder result = new StringBuilder();

        for(String word: words){
            result.append(Character.toTitleCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase())
                    .append(" ");
        }
        return result.toString().trim();
    }

    public String addInlineImage(BufferedImage image) throws IOException{
        String imagePath = GetIcons.makeTempFile(image);
        String html = "<img src=%s width='23' height='23' style='margin-top:-5px'>"
                .formatted(new File(imagePath).toURI());
        return html;
    }

    public String setDebuffTextColor(String text){
        return "<font color = #e20000> <u>%s</u> </font>".formatted(text);
    }

    public String setBuffTextColor(String text){
        return "<font color = #fac400> <u>%s</u> </font>".formatted(text);
    }

    public String setNeutralTextColor(String text){
        return "<font color = #9f6a3a><u>%s</u></font>".formatted(text);
    }
}
