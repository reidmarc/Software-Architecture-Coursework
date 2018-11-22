package Headquarters;

public class Validation
{
    public Validation()
    {

    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean isItOnlyCharacters(String value)
    {
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if(!Character.isLetter(chars[i]) && !Character.isWhitespace(chars[i]))
            {
                return false;
            }
        }
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean isItOnlyNumbersAndCharacters(String value)
    {
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if(!Character.isLetterOrDigit(chars[i]) && !Character.isWhitespace(chars[i]))
            {
                return false;
            }
        }
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean isItOnlyNumeric(String value)
    {
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            if(!Character.isDigit(chars[i]) && !Character.isWhitespace(chars[i]))
            {
                return false;
            }
        }
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------
    public boolean isItLessThan100Chars(String value)
    {
        if (value.length() > 99)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
