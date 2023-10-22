//Function that will take an Integer value and recursively continue returning the
//next roman string character as each subtraction is made from largest roman char
fun Int.toRomanString(): String = RomanString.closestNextRoman(this)
    .let { roman ->
        if (roman != null) {
            "$roman${(this - roman.input).toRomanString()}"
        } else {
            ""
        }
    }
//Function taking String Roman String value and converting it recursively
//to the target Integer value
fun String.toInteger() : Int {
    return RomanString.startingRoman(this)
        .let{roman ->
            if (roman != null) {
                roman.input + this.drop(roman.name.length).toInteger()
            } else {
                0
            }
        }
}

//Initialize table of Roman String values
private enum class RomanString(val input: Int) {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);
//Sort Romans by table value and find the next roman in size comparred to remaining Input
    companion object {
        fun closestNextRoman(value: Int) =
            values()
                .sortedByDescending { it.input }
                .firstOrNull { value >= it.input }
//Find starting Roman String character
        fun startingRoman(value: String) =
            values()
                .sortedByDescending { it.input }
                .firstOrNull { value.startsWith(it.name) }
    }
}