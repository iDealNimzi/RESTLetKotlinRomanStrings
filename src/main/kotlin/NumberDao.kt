class NumberDao {
    //check if input is a number or likely a Roman String
    fun logicalResponse(input: String): String{
        return if (input.toIntOrNull() != null)
            romanString(input.toIntOrNull())
        else
            regularNumber(input)
    }
    //convert a given Integer to the mapped out Roman Symbol(s)
    fun romanString(input: Int?): String {
        if (input != null) {
            return input.toRomanString()
        }
        //prevent null return, return blank if unhappy path occurs
        return ""
    }
    //DAO Call for roman number back to String
    fun regularNumber(input: String): String {
        return input.toInteger().toString()
    }

}