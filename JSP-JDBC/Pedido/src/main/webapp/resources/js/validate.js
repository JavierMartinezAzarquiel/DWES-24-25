// function its_empty(string_value)
//
//     string_value    A string value.
//
// Returns: true if string_value is empty or null

function its_empty(string_value) {

    // Check for the empty string and null
    if (string_value == "" || string_value == null) {
    
        // If either, it's empty so return true
        return true;
    }
    
    // Otherwise, it's not empty so return false
    return false;
}

// function its_whitespace(string_value)
//
//     string_value    A string value.
//
// Returns: true if string_value contains only whitespace characters

function its_whitespace(string_value) {

    // These are the whitespace characters
    var whitespace = " \n\r\t";

    // Run through each character in the string
    for (var counter = 0; counter < string_value.length; counter++) {
        
        // Get the current character
        current_char = string_value.charAt(counter);
        
        // If it's not in the whitespace characters string,
        // return false because we found a non-whitespace character
        if (whitespace.indexOf(current_char) == -1) {
            return false;
        }
    }
    
    // Otherwise, the string has nothing but
    // whitespace characters, so return true
    return true;
}

// function its_a_digit(character)
//
//     character    A single-character string value.
//
// Returns: true if character is a digit (0-9)

function its_a_digit(character) {

    var digit_characters = "0123456789";

    // If it's not in the digit_characters string,
    // then it's not a digit so return false
    
    if (digit_characters.indexOf(character) == -1) {
        return false;
    }
    
    // Otherwise, it's a digit, so return true
    return true;
}

function its_integer(string_value) {

    // Run through each character in the string
    for (var counter = 0; counter < string_value.length; counter++) {
        
        // Get the current character
        current_char = string_value.charAt(counter);
        
        // If it's not a digit, return false
        if (!its_a_digit(current_char)) {
            return false;
        }
    }
    
    // Otherwise, the string has nothing but
    // digits, so return true
    return true;
}

// function its_a_digit_or_dot(character)
//
//     character    A single-character string value.
//
// Returns: true if character is a digit (0-9) or a dot (.)

function its_a_digit_or_dot(character) {

    var floating_point_characters = ".0123456789";

    // If it's not in the floating_point_characters string, then it's
    // not a valid floating point character, so return false
    if (floating_point_characters.indexOf(character) == -1) {
        return false;
    }
    
    // Otherwise, it's a digit, so return true
    return true;
}

// function its_floating_point(string_value)
//
//     string_value    A string value.
//
// Returns: true if string_value represents a floating-point number

function its_floating_point(string_value) {

    // Does it have a dot?
    if (string_value.indexOf(".") == -1) {
        
        // If not, return false
        return false;
    }
    
    // Run through the rest of the characters in the string
    for (var counter = 0; counter < string_value.length; counter++) {
        
        // Get the current character
        current_char = string_value.charAt(counter);
        
        // If it's not a digit or dot, return false
        if (!its_a_digit_or_dot(current_char)) {
            return false;
        }
    }
    
    // Otherwise, the string has nothing but
    // digits, so return true
    return true;
}

// function mandatory_fields_completed(current_form)
//
//     current_form    A reference to a Form object.
//
// Returns: true if all fields in current_form that
// have the custom "mandatory" field set to "true"
// are not empty.

function mandatory_fields_completed(current_form) {
    
    var missing_fields = new Array();
    var total_missing = 0;
    
    // Loop through all the form elements
    for (var counter = 0; counter < current_form.length; counter++) {
    
        // Is this a visible text field that's mandatory?
        if ((current_form[counter].type == "text" ||
            current_form[counter].type == "textarea" ||
            current_form[counter].type == "password") &&
            current_form[counter].mandatory) {
            
            // Is it empty?
            if (its_empty(current_form[counter].value)|| its_whitespace(current_form[counter].value)) {
              
                // If so, add the field to the array of missing fields
                missing_fields[total_missing] = current_form[counter];
                total_missing++;
            }
        }
    }

    // Were there any fields missing?
    if (total_missing > 0) {
    
        // Start the message
        var missing_message = "Los siguientes campos son obligatorios" +
		                      "\n y no se pueden rellenar solo con blancos\n\n"+
                              "\n______________________________\n\n";
        
        // Loop through the missing fields
        for (var counter = 0; counter < missing_fields.length; counter++) {
            missing_message += missing_fields[counter].name + "\n";
        }
    
        // Finish up and display the message
        missing_message += "\n______________________________\n\n" +
                       "Por favor rellene estos campos y envie el formulario.";
        alert(missing_message);
        
        // For emphasis, put the focus on the first missing field
        missing_fields[0].focus();
        
        return false;
    }
    else {
    
        return true;
    }
}

// function purge_characters(original_string, bad_characters)
//
//     original_string    A string value.
//     bad_characters     A string containing characters to
//                        be purged from original_string.
//
// Returns: original_string purged of all characters in the bad_characters string.

function purge_characters(original_string, bad_characters) {

    // This string will hold all the "good" characters
    var cleaned_string = "";
    
    // Run through each character in the original string
    for (var counter = 0; counter < original_string.length; counter++) {
        
        // Get the current character
        current_char = original_string.charAt(counter);
        
       // Is it in the string of bad characters?
       if (bad_characters.indexOf(current_char) == -1) {
       
           // If not, keep it
           cleaned_string += current_char;
       }
    }
    
    // Return the good characters
    return cleaned_string;
}

// function credit_card_valid(card_type, card_number)
//
//     card_type      A string specifying a credit card type
//                    ("Visa", "Mastercard", or "Amex")
//     card_number    A string containing a credit card number.
//
// Returns: true if card_number matches the mask associated with card_type

function credit_card_valid(card_type, card_number) {

    // Define the credit card masks
    var visa_mask = "4###############";
    var mastercard_mask = "55#############4";
    var amex_mask = "34############9";
    var card_mask=null;

    // Use card_type to determine which mask to use
    if (card_type.toUpperCase() == "VISA") {
        card_mask = visa_mask;
    }
    else if (card_type.toUpperCase() == "MASTERCARD") {
        card_mask = mastercard_mask;
    }
    else if (card_type.toUpperCase() == "AMEX") {
        card_mask = amex_mask;
    }

    // Does card_number match card_mask>
    if (!check_mask(card_number, card_mask, false)) {
        
        // If not, return false
        return false;
    }
    // If so, return true
    return true;
}

// function check_mask(field_value, mask, case_sensitive)
//
//     field_value       A string specifying a value to check against the specified mask.
//     mask              A string specifying the mask (use @ for letters and
//                       # for digits. All other charactes are treated literally.
//     case_sensitive    A boolean value: true - uppercase and lowercase literals must match
//                                        false - uppercase and lowercase are ignored
//
// Returns: true if field_value matches the mask.

function check_mask(field_value, mask, case_sensitive) {

    // If the strings are different lengths, return false
    if (field_value.length != mask.length) {
        return false;
    }
    
    // Run through each character in the mask
    for (var counter = 0; counter < mask.length; counter++) {
        
        // Get the current mask and field_value characters
        current_mask = mask.charAt(counter);
        current_char = field_value.charAt(counter);
        
       // Is the mask character a letter?
       if (current_mask == "@") {
           
           // If so, then if the current character isn't a letter, return false
           if (!its_a_letter(current_char)) {
               return false;
           } 
        
       }
       // Is the mask character a digit?
       else if (current_mask == "#") {
           
           // If so, then if the current character isn't a digit, return false
           if (!its_a_digit(current_char)) {
               return false;
           } 
        }
        // Otherwise, are the characters the same?
        else {

            // Is this a case-sensitive mask?
            if (!case_sensitive) {
        
                // If not, then use only uppercase characters
                current_mask = current_mask.toUpperCase();
                current_char = current_char.toUpperCase();
            }
            if (current_mask != current_char) {
                return false;
            }
        }
    }
    
    // If we get this far, we have a match
    return true;
}

// function valid_email(email_address)
//
//     email_address    A string specifying an email address.
//
// Returns: true if email_address is a valid address.

function valid_email(email_address) {

    // Check the length
    if (email_address.length < 5) {
        return false;
    }
    
    // Check @ and .
    at_location = email_address.indexOf("@");
    dot_location = email_address.lastIndexOf(".");
    
    if (at_location == -1 || dot_location == -1 || at_location > dot_location ) {
        return false;
    }

    // Is there at least one character before @?
    if (at_location == 0) {
        return false;
    }
    
    // Is there at least one character between @ and .?
    if (dot_location - at_location < 2 ) {
        return false;
    }

    // Is there at least one character after .?
    if (email_address.length - dot_location < 2) {
        return false;
    }

    // Otherwise, it's a valid address, so return true
    return true;
}

