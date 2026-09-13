/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limbusbossmaker;

/**
 *
 * @author Ryan
 */
public class Passives{
    
    String name;
    int type;
    String description;
    
    public Passives(int type, String name, String description){
        this.type = type;
        this.name = name;
        this.description = description;
    }
    
    
    
    public void printPassive(){
        System.out.printf("""
                          %s (%d)
                          --------------------------------
                          %s""", 
                name, type, description);
    }
}
