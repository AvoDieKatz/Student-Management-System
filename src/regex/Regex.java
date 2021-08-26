/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.regex.Pattern;

/**
 *
 * @author anhtung
 */
public class Regex {

    public boolean validateNumberInput(String string) {
        return Pattern.matches("^[0-9]+$", string);
    }

    
    
    public boolean validateNameInput(String string) {
//        Pattern p = Pattern.compile("^[A-Za-z]+$");
//        Matcher m = p.matcher(name);
//        boolean matchFound = m.find();
//        return matchFound;
        
        return Pattern.matches("^[A-Za-z ]+$", string);
    }
    
    public boolean validateAddressInput(String string) {
        return Pattern.matches("^[0-9 A-Za-z]+$", string);
    }
}
